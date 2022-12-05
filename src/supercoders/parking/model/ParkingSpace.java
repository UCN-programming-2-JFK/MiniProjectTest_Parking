package supercoders.parking.model;
/**
 * Write a description of class ParkingSpace here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ParkingSpace
{
    private int id;
    private char lot;
    private String location;
    private int fee;
    private boolean available;

    
    public ParkingSpace(int id, int fee) {
        this.id = id;
        this.fee = fee;
        available = true;
    }
    
    public int getFee() {
        return fee;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public void setAvailable(boolean value) {
        available = value;
    }
    
}
