/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parking.service;

import co.unicauca.parking.access.IVehicleRepository;
import co.unicauca.parking.domain.IParkingCost;
import co.unicauca.parking.domain.Vehicle;
import co.unicauca.parking.domain.VehicleFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jefferson Eduardo Campo y Fabian David Marin 
 */
public class Service {
    // Ahora hay una dependencia de una abstracción, no es algo concreto,
    private IVehicleRepository repository;

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de IProductRepository
     */
    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    public double calculateParkingCost(Vehicle vehicle, int horas, int minutos) {

        //Validate product.
        if (vehicle == null) {
            return -1;
        }
        //falta implementar la interface
        IParkingCost delivery = VehicleFactory.getInstance().getDelivery(vehicle.getTypeVehicle());
        double result = delivery.calculateCost(horas,minutos);
        
        return result;
    }
    
    public boolean saveVehicle(Vehicle newVehicle) {

        //Validate product
        if (newVehicle == null || newVehicle.getPlateNumber().isEmpty()) {
            return false;
        }

        repository.save(newVehicle);
        return true;

    }
    
    public List<Vehicle> listVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = repository.list();;

        return vehicles;
    }
}
