/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parking.domain;
import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author Personal
 */
public interface IParkingCost {

    public double calculateCost(Vehicle vehicle, Calendar input, Calendar output);

}
