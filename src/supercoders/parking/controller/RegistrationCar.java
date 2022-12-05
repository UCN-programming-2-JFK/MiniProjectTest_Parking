package supercoders.parking.controller;

import supercoders.parking.model.*;
/**
 * DRAFT
 * Controller class for the registration Car use case
 *
 * @author GiBe
 * @version Oct. 2020
 */
public class RegistrationCar {
    //the fields are used to maintain the state of the use case
    Employee employee = null;  

    public Employee findEmployeeByName(String employeeName) {
        employee = EmployeeContainer.getInstance().findEmployeeByName(employeeName); 
        return employee;
    }

    public boolean registerCar(String numberPlate, boolean lux) {
        boolean returnValue = false;
        Car c = new Car(numberPlate, lux);
        if (employee != null) {
            employee.registerCar(c); 
            returnValue = true;
        }
        return returnValue;
    }

}
