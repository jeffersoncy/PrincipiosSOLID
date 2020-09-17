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
    public double calculateCost(Date time) {
       int minutos = time.getMinutes();
       int horas = time.getHours();
       double cuentaCobro;
       double cuentaCobromin;
       double sorteo;
       double cuentaTotal;
       
       cuentaCobro = 15000;
       cuentaCobromin = 0;
       cuentaTotal = 0;
       sorteo = Math.random()*1000;
       
       if(sorteo == 100)
       {
           cuentaTotal = 0;
       }
       
       if(horas == 24)
       {
           cuentaTotal = 15000 * 0.01;
       }
       else if(horas <= 12)
       {
           cuentaTotal = 10000 * 0.01;
       }
       else if(horas > 12 && horas < 24)
       {
           cuentaCobromin = (5000 * (minutos * 100/60)/100);
           
           for(int i = horas; i > 12; i --)
           {
               cuentaCobro += 5000;
           }
           
           cuentaTotal = (cuentaCobro + cuentaCobromin) * 0.01;
       }
       else if(horas > 24)
       {
           cuentaCobromin = (5000 * (minutos * 100/60)/100);
           
           for(int i = horas; i > 24; i --)
           {
               cuentaCobro += 5000;
           }
           
           cuentaTotal = (cuentaCobro + cuentaCobromin) * 0.01;
       }
       
       return Math.ceil(cuentaTotal) * 100;
    }
}
