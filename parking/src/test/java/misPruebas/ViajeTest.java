/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misPruebas;

import co.unicauca.parking.access.Factory;
import co.unicauca.parking.access.IVehicleRepository;
import co.unicauca.parking.domain.*;
import co.unicauca.parking.service.Service;
import java.text.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Libardo Pantoja, Ricardo Zambrano
 */
public class ViajeTest {

    public ViajeTest() {
    }
    
    /**
     * Test de la clase Vehicle.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testVehicle() throws ParseException {
        System.out.println("testVehicle");
        Vehicle moto1 = new Vehicle("123-ABC", "SUZUKI", 10, VehicleEnum.MOTO);
        Vehicle carro1 = new Vehicle("123-CDE", "MAZDA", 15, VehicleEnum.CAR);
        assertEquals(VehicleEnum.MOTO, moto1.getTypeVehicle());
        assertEquals("123-ABC", moto1.getPlateNumber());
        assertEquals(10, moto1.getCapacityPeople());
        assertEquals("SUZUKI", moto1.getVehicleBrand());
        assertEquals(VehicleEnum.CAR, carro1.getTypeVehicle());
        assertEquals("123-CDE", carro1.getPlateNumber());
        assertEquals(15, carro1.getCapacityPeople());
        assertEquals("MAZDA", carro1.getVehicleBrand());
    }
    /**
     * Test de la clase MotoParkingCost.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testMotoParkingcostMenorHora() throws ParseException {
        System.out.println("test Moto parking cost menos de una hora");
        IVehicleRepository repository = Factory.getInstance().getRepository("default");
        Service Factura = new Service(repository);
        Vehicle moto1 = new Vehicle("123-ABC", "SUZUKI", 10, VehicleEnum.MOTO);
        int costo = (int) Factura.calculateParkingCost(moto1,0,36);
        assertEquals(1000,costo);
    }
    /**
     * Test de la clase MotoParkingCost.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testMotoParkingcostMayorHora() throws ParseException {
        System.out.println("test Moto parking cost mayor a una hora");
        IVehicleRepository repository = Factory.getInstance().getRepository("default");
        Service Factura = new Service(repository);
        Vehicle moto1 = new Vehicle("123-ABC", "SUZUKI", 10, VehicleEnum.MOTO);
        int costo = (int) Factura.calculateParkingCost(moto1,01,30);
        assertEquals(1300,costo);
    }
    /**
     * Test de la clase MotoParkingCost.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testMotoParkingcostRedondeo() throws ParseException {
        System.out.println("test Moto parking cost redondeo");
        IVehicleRepository repository = Factory.getInstance().getRepository("default");
        Service Factura = new Service(repository);
        Vehicle moto1 = new Vehicle("123-ABC", "SUZUKI", 10, VehicleEnum.MOTO);
        //obtenemos en este caso 1275 en el cual se redondearía a 1300
        int costo = (int) Factura.calculateParkingCost(moto1,01,33);
        assertEquals(1300,costo);
        // y en este caso 1240 en el cual se redondearía a 1300
        costo = (int) Factura.calculateParkingCost(moto1,01,29);
        assertEquals(1300,costo);
    }
    /**
     * Test de la clase CarParkingCost.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testCarParkingcostMenorHora() throws ParseException {
        System.out.println("test Car parking cost menos de una hora");
        IVehicleRepository repository = Factory.getInstance().getRepository("default");
        Service Factura = new Service(repository);
        Vehicle car1 = new Vehicle("123-CDE", "Mazda", 10, VehicleEnum.CAR);
        int costo = (int) Factura.calculateParkingCost(car1,00,40);
        assertEquals(2000,costo);
    }
    /**
     * Test de la clase CarParkingCost.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testCarParkingcostMayorHora() throws ParseException {
        System.out.println("test Car parking cost mayor a una hora");
        IVehicleRepository repository = Factory.getInstance().getRepository("default");
        Service Factura = new Service(repository);
        Vehicle car1 = new Vehicle("123-CDE", "Mazda", 10, VehicleEnum.CAR);
        int costo = (int) Factura.calculateParkingCost(car1,01,30);
        assertEquals(2500,costo);
    }
    /**
     * Test de la clase CarParkingCost.
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testCarParkingcostRedondeo() throws ParseException {
        System.out.println("test Car parking cost redondeo");
        IVehicleRepository repository = Factory.getInstance().getRepository("default");
        Service Factura = new Service(repository);
        Vehicle car1 = new Vehicle("123-CDE", "Mazda", 10, VehicleEnum.CAR);
        //obtenemos en este caso 2560 en el cual se redondearía a 2600
        int costo = (int) Factura.calculateParkingCost(car1,01,34);
        assertEquals(2600,costo);
        // y en este caso 2530 en el cual se redondearía a 2600
        costo = (int) Factura.calculateParkingCost(car1,01,32);
        assertEquals(2600,costo);
    }
    
    
}
