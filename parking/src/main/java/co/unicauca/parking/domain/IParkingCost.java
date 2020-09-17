/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parking.domain;
import java.util.Date;


/**
 *
 * @author Personal
 */
public interface IParkingCost {

    public double calculateCost(int horas, int minutos);

}
