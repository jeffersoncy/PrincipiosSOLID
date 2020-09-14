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
public class MotoParkingCost implements IParkingCost{
    @Override
    public double calculateCost(Vehicle vehicle, Calendar input, Calendar output) {
       int hora;
       int minutes;
       double cuentaCobro;
       hora = output.get(Calendar.HOUR)-input.get(Calendar.HOUR);
       minutes = input.get(Calendar.MINUTE);
       if(hora < 1)
       {
           cuentaCobro = 1000;
       }
       else
       {
           cuentaCobro = (500 * (minutes * 100 / 60)/100);
           for (int i = 0; i < hora; i++)
           {
               cuentaCobro = cuentaCobro + 500;
           }
       }
       return cuentaCobro;
    }
}
