package supercoders.parking.controller;

import supercoders.parking.model.*;
/**
 * Write a description of class AssingParkingPlace here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AssignParkingPlace
{
    Employee employee = null;  //hold the employee for the particular use case scenario 

    
    public void assignFreePPEmployee(String employeeName) {
        Employee e = EmployeeContainer.getInstance().findEmployeeByName(employeeName);         
        ParkingSpace p = ParkingSpaceContainer.getInstance().findFirstAvailableParkingPlace();
        if (employee!=null) {
            if (employee.hasCar() && p!=null) {
                employee.setParkingSpace(p);
                p.setAvailable(false);
            }
        }
    }
}
