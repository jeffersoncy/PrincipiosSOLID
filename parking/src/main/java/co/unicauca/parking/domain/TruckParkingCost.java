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
public class TruckParkingCost implements IParkingCost {

    @Override
    public double calculateCost(Date input, Date output) {
       long diferencia = output.getTime()-input.getTime();
       int minutos = (int) TimeUnit.MILLISECONDS.toMinutes(diferencia);
       long horas = TimeUnit.MILLISECONDS.toHours(diferencia);
       minutos = (int) (minutos - TimeUnit.HOURS.toMinutes(horas));
       double cuentaCobro = 0;
       double cuentaCobromin = 0;
       double sorteo = Math.random()*1000;
       
       if(sorteo == 700)
       {
           return 0;
       }
       
       if(horas == 24)
       {
           return 15000;
       }
       
       if(horas <= 12)
       {
           return 10000;
       }
       
       if(horas > 24)
       {
           cuentaCobro = 15000;
           cuentaCobromin = (7500 *(minutos * 100/60)/100);
           
           for(int i = 0; i < horas - 1; i ++)
           {
               cuentaCobro = cuentaCobro + 7500;
           }
       }    
       
       double cuentatotal = (cuentaCobro + cuentaCobromin) * 0.01; 
       return Math.ceil(cuentatotal) * 100;
    }
}
