/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parking.domain;

/**
 *
 * @author Personal
 */
public class Vehicle {

    private String plateNumber;

    private String vehicleBrand;

    private int capacityPeople;

    /**
     *
     * @param plateNumber : placa del vehiculo
     * @param vehicleBrand : marca del vehiculo
     * @param capacityPeople : capacidad del vehiculo
     */

    public Vehicle(String plateNumber, String vehicleBrand, int capacityPeople) {
        this.plateNumber = plateNumber;
        this.vehicleBrand = vehicleBrand;
        this.capacityPeople = capacityPeople;
    }

    public Vehicle() {
    }

    // getters and setters
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public int getCapacityPeople() {
        return capacityPeople;
    }

    public void setCapacityPeople(int capacityPeople) {
        this.capacityPeople = capacityPeople;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "id=" + plateNumber + ", name=" + vehicleBrand + ", price=" + capacityPeople + '}';
    }

}
