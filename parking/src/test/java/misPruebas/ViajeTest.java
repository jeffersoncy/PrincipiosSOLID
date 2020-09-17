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
import java.text.SimpleDateFormat;
import java.util.Date;
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
     * Test de la clase ViajeFamiliar.
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
     * Test de la clase .
     *
     * @throws java.text.ParseException
     */
    @Test
    public void testMotoParkingcostMenorHora() throws ParseException {
        System.out.println("test Moto parking cost menos de una hora");
        IVehicleRepository repository = Factory.getInstance().getRepository("default");
        Service Factura = new Service(repository);
        Vehicle moto1 = new Vehicle("123-ABC", "SUZUKI", 10, VehicleEnum.MOTO);
        SimpleDateFormat simple = new SimpleDateFormat("HH:mm");
        Date input = simple.parse("00:40");
        int costo = (int) Factura.calculateParkingCost(moto1,input);
        assertEquals(1000,costo);
    }
//    /**
//     * Test de la clase ViajeIncentivo.
//     *
//     * @throws java.text.ParseException
//     */
//    @Test
//    public void testViajeIncentivo() throws ParseException {
//        System.out.println("Viaje incentivo");
//        ViajeIncentivo viaje = new ViajeIncentivo("Popayán", "Medellin", 2100000, new SimpleDateFormat("dd/MM/yyyy").parse("03/06/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2019"), "Emtel");
//        assertEquals("Popayán", viaje.getOrigen());
//        assertEquals("Medellin", viaje.getDestino());
//        assertEquals(2100000, viaje.getCosto());
//        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("03/06/2019"), viaje.getFechaSalida());
//        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2019"), viaje.getFechaLlegada());
//        assertEquals("Emtel", viaje.getEmpresa());
//        assertEquals("Viaje incentivo que te envia la empresa Emtel", viaje.descripcion());
//        assertEquals("Cualquier método implementado en la clase base", viaje.cualquierMetodo());
//        assertEquals("Método implementado en la clase hija viaje de incentivo", viaje.cualquierMetodo2());
//    }
//
//    /**
//     * Test de la clase ViajeIndividual.
//     *
//     * @throws java.text.ParseException
//     */
//    @Test
//    public void testViajeIndividual() throws ParseException {
//        System.out.println("Viaje individual");
//        Viaje viaje = new ViajeIndividual("Popayán", "San Andres", 4250000, new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"));
//        assertEquals("Popayán", viaje.getOrigen());
//        assertEquals("San Andres", viaje.getDestino());
//        assertEquals(4250000, viaje.getCosto());
//        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), viaje.getFechaSalida());
//        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"), viaje.getFechaLlegada());
//        assertEquals("Disfruta tu viaje individual", viaje.descripcion());
//        assertEquals("Cualquier método implementado en la clase base", viaje.cualquierMetodo());
//        assertEquals("Cualquier método2 implementado en la clase base", viaje.cualquierMetodo2());
//
//    }
//
//    /**
//     * Test de la clase ViajeTodoIncluido.
//     *
//     * @throws java.text.ParseException
//     */
//    @Test
//    public void testViajeTodoIncluido() throws ParseException {
//        System.out.println("Viaje todo incluido");
//        Viaje viaje = new ViajeTodoIncluido("Popayán", "Cartagena", 7350000, new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"));
//        assertEquals("Popayán", viaje.getOrigen());
//        assertEquals("Cartagena", viaje.getDestino());
//        assertEquals(7350000, viaje.getCosto());
//        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"), viaje.getFechaSalida());
//        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2019"), viaje.getFechaLlegada());
//        assertEquals("Disfruta tu viaje todo incluido", viaje.descripcion());
//        assertEquals("Cualquier método implementado en la clase base", viaje.cualquierMetodo());
//        assertEquals("Cualquier método2 implementado en la clase base", viaje.cualquierMetodo2());
//    }

}
