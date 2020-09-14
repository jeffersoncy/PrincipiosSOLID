package co.unicauca.parking.access;

import co.unicauca.parking.domain.Vehicle;
import java.util.List;

/**
 *
 * @author Personal
 */
public interface IVehicleRepository {
    boolean save(Vehicle newVehicle);
    
    List<Vehicle> list();
    
}
