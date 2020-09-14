/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parking.main;

import co.unicauca.parking.domain.VehicleEnum;
import co.unicauca.parking.domain.Vehicle;
import co.unicauca.parking.domain.IParkingCost;
import co.unicauca.parking.domain.MotoParkingCost;
import co.unicauca.parking.domain.CarParkingCost;
import co.unicauca.parking.domain.TruckPartingCost;
import co.unicauca.parking.domain.VehicleFactory;
/**
 *
 * @author Personal
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vehicle moto1 = new Vehicle("123-ABC", "SUZUKI", 2, "2008", VehicleEnum.MOTO);
    }
    
}
