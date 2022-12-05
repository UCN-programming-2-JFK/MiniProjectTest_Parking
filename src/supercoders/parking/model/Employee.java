package supercoders.parking.model;

import java.util.ArrayList;
import java.util.Calendar;
/**
 * Write a description of class Employee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Employee
{
    private String name;
    private boolean vip;
    private int yearEmployment;
    private ParkingSpace parkingPlace;
    private ArrayList<Car> cars;

    public Employee (String name, boolean vip, int yearEmployment) {
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

    public void registerCar(Car car) {
        if (car!=null) {
            cars.add(car);
        }
    }


    //return true if there is a car that is lux...
    public boolean checkLuxurious(){
        // check on luxurious car
        boolean found = false;
        int index = 0;
        while(!found && index<cars.size()){
            Car car = cars.get(index);
            if (car.isLuxurious()) {
                found = true;
            } else {
                index++;
            }
        }
        return found;
    }
}
