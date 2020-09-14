/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
