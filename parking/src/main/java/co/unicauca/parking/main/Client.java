/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parking.main;

import co.unicauca.parking.access.Factory;
import co.unicauca.parking.access.IVehicleRepository;
import co.unicauca.parking.domain.VehicleEnum;
import co.unicauca.parking.domain.Vehicle;
import co.unicauca.parking.service.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Personal
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        IVehicleRepository repository = Factory.getInstance().getRepository("default");
        Service service = new Service(repository);
        SimpleDateFormat simple = new SimpleDateFormat("HH:mm");
        Date input = null;
        Date output = null;
        
        input = simple.parse("11:00");
        output = simple.parse("12:40");
        
        System.out.println(" la hora ingresada es: "+input.getHours()+" y los minutos son: "+input.getMinutes());
        
        Vehicle moto1 = new Vehicle("123-ABC", "SUZUKI", 10, VehicleEnum.MOTO);
        Vehicle carro1 = new Vehicle("123-CDE", "MAZDA", 15, VehicleEnum.CAR);
        Vehicle truck1 = new Vehicle("123-EFG", "CAT", 45, VehicleEnum.TRUCK);
        
        service.saveVehicle(moto1);
        service.saveVehicle(carro1);
        service.saveVehicle(truck1);
        
        for (Vehicle p : service.listVehicles()) {
            System.out.println(p);
        }
        
        System.out.println("El costo es: "+service.calculateParkingCost(moto1, input, output));
        System.out.println("El costo es: "+service.calculateParkingCost(carro1, input, output));
        System.out.println("El costo es: "+service.calculateParkingCost(truck1, input, output));
    }
}
