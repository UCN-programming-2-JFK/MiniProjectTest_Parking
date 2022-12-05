package supercoders.parking.model;

import java.util.*;

public class Employee
{
	private int id;
    private String name;
    private boolean vip;
    private int yearEmployment;
    private ParkingSpace parkingPlace;
    private ArrayList<Car> cars;

    public Employee (int id, String name, boolean vip, int yearEmployment) {
    	this(name, vip, yearEmployment);
    }
    
    public Employee(String name, boolean vip, int yearEmployment) {
        this.name = name;
        this.vip = vip;
        this.yearEmployment = yearEmployment;
        parkingPlace = null;  // not necessary
        cars = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    
    public boolean hasCar(){
        return !cars.isEmpty();
    }
    
    public boolean isVip(){
        return vip;
    }
       
    public int getYearEmployment() {
        return yearEmployment;
    }
    
    public ParkingSpace getParkingPlace(){
        return parkingPlace;
    }
        
    
    public void setParkingSpace(ParkingSpace parkingPlace) {
        if (parkingPlace!=null ) {
            this.parkingPlace = parkingPlace;
        }
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


    //return true if there is a car that is lux...
    public boolean checkLuxurious(){
        // check on luxurious car
        boolean found = false;
        int index = 0;
        while(!found && index<cars.size()){
            Car car = cars.get(index);
            if (car.isLuxuryCar()) {
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
}