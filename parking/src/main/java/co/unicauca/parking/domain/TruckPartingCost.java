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
public class TruckPartingCost implements IParkingCost {

    @Override
    public double calculateCost(Date input, Date output) {
       long diferencia = output.getTime()-input.getTime();
       int minutos = (int) TimeUnit.MILLISECONDS.toMinutes(diferencia);
       long horas = TimeUnit.MILLISECONDS.toHours(diferencia);
       minutos = (int) (minutos - TimeUnit.HOURS.toMinutes(horas));
       double cuentaCobro = 0;
       double cuentaCobromin = 0;
       if(horas < 12)
       {
           cuentaCobro = 10000;
       }
       else
       {
           cuentaCobro = 2000;
           cuentaCobromin = ((1000 * (minutos * 100 / 60))/100);
           for (int i = 0; i < horas-1; i++)
           {
               cuentaCobro = cuentaCobro + 1000;
           }
       }
       double cuentatotal = (cuentaCobro+cuentaCobromin)*0.01;
       return Math.ceil(cuentatotal)*100;
    }
    
}
