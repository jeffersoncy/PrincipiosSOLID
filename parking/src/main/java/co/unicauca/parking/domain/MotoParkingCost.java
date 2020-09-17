/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parking.domain;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Personal
 */
public class MotoParkingCost implements IParkingCost{
    
    @Override
    public double calculateCost( Date time) {
       int minutos = (int) TimeUnit.MILLISECONDS.toMinutes(time.getTime());
       long horas = TimeUnit.MILLISECONDS.toHours(time.getTime());
       minutos = (int) (minutos - TimeUnit.HOURS.toMinutes(horas));
       double cuentaCobro = 0;
       double cuentaCobromin = 0;
       if(horas < 1)
       {
           cuentaCobro = 1000;
       }
       else
       {
           cuentaCobro = 1000;
           cuentaCobromin = ((500 * (minutos * 100 / 60))/100);
           for (int i = 0; i < horas-1; i++)
           {
               cuentaCobro = cuentaCobro + 500;
           }
       }
       double cuentatotal = (cuentaCobro+cuentaCobromin)*0.01;
       return Math.ceil(cuentatotal)*100;
    }
}