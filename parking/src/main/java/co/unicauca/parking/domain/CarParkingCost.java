/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parking.domain;

import java.util.Date;

/**
 *
 * @author Jefferson Eduardo Campo y Fabian David Marin
 */
public class CarParkingCost implements IParkingCost{

    @Override
    public double calculateCost(int horas,int minutos) {
       double cuentaCobro = 0;
       double cuentaCobromin = 0;
       if(horas < 1)
       {
           cuentaCobro = 2000;
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
