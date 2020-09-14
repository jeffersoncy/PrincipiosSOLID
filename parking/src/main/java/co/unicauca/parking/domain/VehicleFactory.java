/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parking.domain;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author Personal
 */
public class VehicleFactory {

    private Map<VehicleEnum, IParkingCost> dictionary;
    
    
    //Singleton
    private static VehicleFactory instance;
    
    private VehicleFactory() {
        dictionary = new EnumMap<>(VehicleEnum.class);
        dictionary.put(VehicleEnum.MOTO, new MotoParkingCost());
        dictionary.put(VehicleEnum.CARRO, new CarParkingCost());
    }
    
    /**
     * devuelve la instancia de la clase
     *
     * @return
     */
    public static VehicleFactory getInstance() {
        if (instance == null) {
            instance = new VehicleFactory();

        }
        return instance;
    }

    public IParkingCost getDelivery(VehicleEnum vehicle) {
        IParkingCost result = null;
        if (dictionary.containsKey(vehicle)) {
            result = dictionary.get(vehicle);
        }

        return result;
    }
}
