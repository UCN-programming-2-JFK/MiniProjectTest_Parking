package supercoders.parking.controller;

import supercoders.parking.model.*;
import java.util.*;
/**
 * Write a description of class FeeCalculation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FeeCalculation {
    private static final int DISCOUNT = 15;
    private static final int SURCHARGE = 3;
        
//    public int calculateFee(String employeeName){
//        int cost= 0;
//        Employee e = EmployeeContainer.getInstance().findEmployeeByName(employeeName);         
//        if (e!=null && e.getParkingPlace() != null) {
//            cost = e.getParkingPlace().getFee();
//            //check if vip or not and apply the discount
//            if (e.isVip()) {
//                cost = cost - cost*DISCOUNT/100;
//            } else {
//                int seniority = this.getCurrentYear() - e.getYearEmployment();
//                cost = cost - cost * seniority/100;
//            }
//
//            if (e.checkLuxurious()) {
//                cost = cost + cost * SURCHARGE/100;
//            }       
//        }
//        return cost;
//    }

    private int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
