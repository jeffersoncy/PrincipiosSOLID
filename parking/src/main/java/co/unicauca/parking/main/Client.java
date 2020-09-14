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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Personal
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simple = new SimpleDateFormat("HH:mm");
        Date input = null;
        Date output = null;
        input = simple.parse("09:42");
        output = simple.parse("10:42");
        
        System.out.println(" la hora ingresada es: "+input.getHours()+" y los minutos son: "+input.getMinutes());
        
        Vehicle moto1 = new Vehicle("123-ABC", "SUZUKI", 2, "2008", VehicleEnum.MOTO);
        
    }
    
}
