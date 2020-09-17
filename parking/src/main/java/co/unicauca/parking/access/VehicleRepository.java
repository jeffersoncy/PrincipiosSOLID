package co.unicauca.parking.access;

import co.unicauca.parking.domain.Vehicle;
import co.unicauca.parking.domain.VehicleEnum;
import co.unicauca.parking.service.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jefferson Eduardo Campo y Fabian David Marin
 */

public class VehicleRepository implements IVehicleRepository {

    private Connection conn;

    public VehicleRepository() {
        initDatabase();
    }

    @Override
    public boolean save(Vehicle newVehicle) {

        try {
            //Validate Vehicle
            if (newVehicle == null || newVehicle.getPlateNumber().isEmpty() || newVehicle.getVehicleBrand().isEmpty() || newVehicle.getCapacityPeople() <0 ){
                return false;
            }

            String sql = "INSERT INTO Vehicle (plateNumber, vehicleBrand, capacityPeople, typeVehicle) "
                    + "VALUES ( ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newVehicle.getPlateNumber());
            pstmt.setString(2, newVehicle.getVehicleBrand());
            pstmt.setInt(3, newVehicle.getCapacityPeople());
            pstmt.setString(4, newVehicle.getTypeVehicle().toString());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Vehicle> list() {
        List<Vehicle> vehicles = new ArrayList<>();
        try {

            String sql = "SELECT plateNumber, vehicleBrand, capacityPeople, typeVehicle FROM Vehicle";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlateNumber(rs.getString("plateNumber"));
                newVehicle.setVehicleBrand(rs.getString("vehicleBrand"));
                newVehicle.setCapacityPeople(rs.getInt("capacityPeople"));
                String type = rs.getString("typeVehicle");
                newVehicle.setTypeVehicle(VehicleEnum.valueOf(type));
                vehicles.add(newVehicle);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }

    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	plateNumber text PRIMARY KEY,\n"
                + "	vehicleBrand text NOT NULL,\n"
                + "	capacityPeople integer,\n"
                + "	typeVehicle text\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() {
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}