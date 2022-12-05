package supercoders.parking.model;

import java.util.*;

public class Employee
{
	private int id;
    private String name;
    private boolean isVip;
    private int employmentYear;
    private List<ParkingSpot> parkingSpots;
    private ArrayList<Car> cars;

    public Employee (int id, String name, boolean isVip, int employmentYear) {
    	this(name, isVip, employmentYear);
    }
    
    public Employee(String name, boolean isVip, int employmentYear) {
        this.setName(name);
        this.setVip(isVip);
        this.setEmploymentYear(employmentYear);
        parkingSpots = new ArrayList<ParkingSpot>(); 
        cars = new ArrayList<Car>();
    }

    
    public boolean hasCar(){
        return !cars.isEmpty();
    }
    
    public boolean isVip(){
        return isVip;
    }
           
    public List<ParkingSpot> getParkingSpots(){
        return new ArrayList<ParkingSpot>(parkingSpots);
    }
        
    public void addParkingSpot(ParkingSpot parkingPlace) {
            this.parkingSpots.add(parkingPlace);
        }

    public void addCar(Car car) {
        if (car!=null) {
            cars.add(car);
        }
    }
    public boolean removeCar(Car car) {
    	return cars.remove(car);
    }
    
    public List<Car> getCars(){
    	return new ArrayList<Car>(cars);
    }

    public boolean hasElectricCar(){
        boolean found = false;
        int index = 0;
        while(!found && index < cars.size()){
            Car car = cars.get(index);
            if (car.isElectric()) {
                found = true;
            } else {
                index++;
            }
        }
        return found;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	public int getEmploymentYear() {
		return employmentYear;
	}

	public void setEmploymentYear(int employmentYear) {
		this.employmentYear = employmentYear;
	}
}