/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parking.domain;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Personal
 */
public class MotoParkingCost implements IParkingCost{
    
    @Override
    public double calculateCost(Vehicle vehicle, Date input, Date output) {
//       int hora;
//       int minutes;
//       double cuentaCobro;
//       hora = input.getHours();
//       minutes = input.getMinutes();
//       if(hora < 1)
//       {
//           cuentaCobro = 1000;
//       }
//       else
//       {
//           cuentaCobro = (500 * (minutes * 100 / 60)/100);
//           for (int i = 0; i < hora; i++)
//           {
//               cuentaCobro = cuentaCobro + 500;
//           }
//       }
       return 555;
    }
}
