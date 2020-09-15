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
    
    private VehicleEnum typeVehicle;
    
    //private String vehicleModel;
     
    private String plateNumber;

    private String vehicleBrand;

    private int capacityPeople;

    /**
     *
     * @param plateNumber : placa del vehiculo
     * @param vehicleBrand : marca del vehiculo
     * @param capacityPeople : capacidad del vehiculo
     */

    public Vehicle(){}
    public Vehicle(String plateNumber, String vehicleBrand, int capacityPeople, VehicleEnum typeVehicle) {
        this.plateNumber = plateNumber;
        this.vehicleBrand = vehicleBrand;
        this.capacityPeople = capacityPeople;
        this.typeVehicle = typeVehicle;
    }   
    
    // getters and setters

    /**
     * @return the typeVehicle
     */
    public VehicleEnum getTypeVehicle() {
        return typeVehicle;
    }

    /**
     * @param typeVehicle the typeVehicle to set
     */
    public void setTypeVehicle(VehicleEnum typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    /**
     * @return the plateNumber
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * @param plateNumber the plateNumber to set
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * @return the vehicleBrand
     */
    public String getVehicleBrand() {
        return vehicleBrand;
    }

    /**
     * @param vehicleBrand the vehicleBrand to set
     */
    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    /**
     * @return the capacityPeople
     */
    public int getCapacityPeople() {
        return capacityPeople;
    }

    /**
     * @param capacityPeople the capacityPeople to set
     */
    public void setCapacityPeople(int capacityPeople) {
        this.capacityPeople = capacityPeople;
    }

    
    @Override
    public String toString() {
        return "Vehicle{" + "Plate Number=" + getPlateNumber() + ", Brand =" + getVehicleBrand()+ ", Capacity People=" + getCapacityPeople()+", Type=" + getTypeVehicle()+'}';
    }





}
