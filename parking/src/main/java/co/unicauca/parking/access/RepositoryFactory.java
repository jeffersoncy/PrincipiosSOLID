/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parking.access;

import co.unicauca.solid.dip.domain.access.IVehicleRepository;
import co.unicauca.solid.dip.domain.access.VehicleRepository;

/**
 *
 * @author Personal
 */
public class RepositoryFactory {
    private static RepositoryFactory instance;
    
    private RepositoryFactory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static RepositoryFactory getInstance() {

        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;

        /**
     * Método que crea una instancia concreta de la jerarquia IProductRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IProductRepository
     */
    public IVehicleRepository getRepository(String type) {

        IVehicleRepository result = null;

        switch (type) {
            case "default":
                result = new VehicleRepository();
                break;
        }

        return result;

    }
}
