package supercoders.parking.model;

import java.util.*;

import supercoders.parking.model.dao.EmployeeDao;
/**
 * Write a description of class EmployeeContainer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EmployeeContainer implements EmployeeDao
{
    private static EmployeeContainer uniqueInstance = new EmployeeContainer();
    private ArrayList<Employee> employees = new ArrayList<>();
    
    private EmployeeContainer() {    }
    
    public static EmployeeContainer getInstance() {       
        return uniqueInstance;
    }
    
    //assumption unique name
    public Employee findEmployeeByPartOfName(String partOfName){
        Employee foundEmployee = null;
        
        boolean searching = true;
        Iterator<Employee> it = employees.iterator();
        while(it.hasNext() && searching){
            Employee e = it.next();
            if (e.getFirstName().toLowerCase().indexOf(partOfName) > -1 || e.getLastName().toLowerCase().indexOf(partOfName) > -1) {
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

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(String initials) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEmployee(Employee employeeToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(String employeeInitials) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee FindEmployeeFromPartOfName(String partOfName) {
		// TODO Auto-generated method stub
		return null;
	}
}