package supercoders.parking.model;

import java.util.*;
/**
 * Write a description of class EmployeeContainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EmployeeContainer
{
    private static EmployeeContainer uniqueInstance = new EmployeeContainer();
    private ArrayList<Employee> employees;
    
    private EmployeeContainer() {
        employees = new ArrayList<>();
    }
    
    public static EmployeeContainer getInstance() {       
        return uniqueInstance;
    }
    
    //assumption unique name
    public Employee findEmployeeByName(String name){
        Employee foundEmployee = null;
        
        boolean searching = true;
        Iterator<Employee> it = employees.iterator();
        while(it.hasNext() && searching){
            Employee e = it.next();
            //TODO lower case etc.
            if (e.getName().equals(name)) {
                foundEmployee = e;
                searching = false;
            }           
        }       
        return foundEmployee; 
    }
    

    public boolean addEmployee (Employee e) {
        boolean result = false;
        if (e!= null) {
            result = employees.add(e);
        }
        return result;
    }

}
