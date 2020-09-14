
package co.unicauca.parking.access;
import co.unicauca.parking.domain.Vehicle;
import co.unicauca.parking.service.Service;
import java.security.Provider;

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

public class VehicleRepository implements IVehicleRepository {

    private Connection conn;

    public VehicleRepository() {
        initDatabase();
    }

    @Override
    public boolean save(Vehicle newVehicle) {

        try {
            //Validate Vehicle
            if (newVehicle == null || newVehicle.getPlateNumber().isBlank() || newVehicle.getVehicleBrand().isBlank() || newVehicle.getCapacityPeople() < 0) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO Product ( plateNumber, vehicleBrand, capacityPeople ) "
                    + "VALUES ( ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newVehicle.getPlateNumber());
            pstmt.setString(2, newVehicle.getVehicleBrand());
            pstmt.setDouble(3, newVehicle.getCapacityPeople());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Provider.Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Vehicle> list() {
        List<Vehicle> vehicles = new ArrayList<>();
        try {

            String sql = "SELECT plateNumber, vehicleBrand, capacityPeople FROM Vehicle";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlateNumber(rs.getString("plateNumber"));
                newVehicle.setVehicleBrand(rs.getString("vehicleBrand"));
                newVehicle.setCapacityPeople(rs.getInt("capacityPeople"));

                vehicles.add(newVehicle);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Provider.Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }

    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	ProductId integer PRIMARY KEY,\n"
                + "	Name text NOT NULL,\n"
                + "	Price real\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Provider.Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Provider.Service.class.getName()).log(Level.SEVERE, null, ex);
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