package supercoders.parking.model;

import java.time.LocalDate;
import java.util.*;

public class Employee
{
	private String initials, firstName, lastName;
    private boolean isManager;
    private LocalDate employmentDate;
    private List<ParkingSpot> parkingSpots;
    private ArrayList<Vehicle> cars;

    public Employee (String initials, String firstName, String lastName, boolean isManager, LocalDate employmentDate) {
    	this.setInitials(initials);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setIsManager(isManager);
        this.setEmploymentDate(employmentDate);
        parkingSpots = new ArrayList<ParkingSpot>(); 
        cars = new ArrayList<Vehicle>();
    }

    public boolean hasCar(){
        return !cars.isEmpty();
    }
    
    public boolean isManager(){
        return isManager;
    }
           
    public List<ParkingSpot> getParkingSpots(){
        return new ArrayList<ParkingSpot>(parkingSpots);
    }
        
    public void addParkingSpot(ParkingSpot parkingPlace) {
            this.parkingSpots.add(parkingPlace);
        }

    public void addCar(Vehicle car) {
        if (car!=null) {
            cars.add(car);
        }
    }
    public boolean removeCar(Vehicle car) {
    	return cars.remove(car);
    }
    
    public List<Vehicle> getCars(){
    	return new ArrayList<Vehicle>(cars);
    }

    public boolean hasElectricCar(){
        boolean found = false;
        int index = 0;
        while(!found && index < cars.size()){
            Vehicle car = cars.get(index);
            if (car.isElectric()) {
                found = true;
            } else {
                index++;
            }
        }
        return found;
    }

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}

	public LocalDate getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(LocalDate employmentDate) {
		this.employmentDate = employmentDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + getInitials() + "] " + getFirstName() + " " + getLastName();
	}
}