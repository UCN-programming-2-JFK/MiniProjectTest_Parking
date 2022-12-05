package supercoders.parking.model;
/**
 * Write a description of class Car here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car
{
    private String numberPlate;
    private boolean luxurious;
    
    public Car () {
    }
    
    public Car (String numberPlate, boolean luxurious) {
        this.numberPlate = numberPlate;
        this.luxurious = luxurious;
    }

    public boolean isLuxurious() {
        return luxurious;
    }
}
