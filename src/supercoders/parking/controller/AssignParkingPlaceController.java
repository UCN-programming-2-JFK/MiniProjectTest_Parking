package supercoders.parking.controller;

import java.util.List;

import supercoders.parking.model.*;
import supercoders.parking.model.dao.EmployeeDao;
import supercoders.parking.model.dao.ParkingLocationDao;
import supercoders.parking.model.dao.database.EmployeeDaoImplementation;
import supercoders.parking.model.dao.database.ParkingLocationDaoImplementation;

public class AssignParkingPlaceController
{
    private ParkingLocation parkingLocation = null;
    private Employee employee = null;
    
    private ParkingLocationDao parkingLocationDao = new ParkingLocationDaoImplementation();
    private EmployeeDao employeeDao = new EmployeeDaoImplementation();
    
    private static AssignParkingPlaceController instance = new AssignParkingPlaceController();
    
    private AssignParkingPlaceController() {}
    
    public static AssignParkingPlaceController getInstance() {return instance;}
        
    public List<ParkingLocation> getParkingLocations() throws Exception{
    	return parkingLocationDao.getAll();
    }
    
    public List<Employee> getEmployees() throws Exception{
    	return employeeDao.getAll();
    }

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ParkingLocation getParkingLocation() {
		return parkingLocation;
	}

	public void setParkingLocation(ParkingLocation parkingLocation) {
		this.parkingLocation = parkingLocation;
	}
}