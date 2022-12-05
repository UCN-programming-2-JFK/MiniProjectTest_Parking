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
        Employee employee = EmployeeContainer.getInstance().findEmployeeByName(employeeName);         
        ParkingSpace parkingSpace = ParkingSpaceContainer.getInstance().findFirstAvailableParkingPlace();
        if (employee!=null) {
            if (employee.hasCar() && parkingSpace!=null) {
                employee.setParkingSpace(parkingSpace);
                parkingSpace.setAvailable(false);
            }
        }
    }
}
