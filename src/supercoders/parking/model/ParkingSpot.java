package supercoders.parking.model;

public class ParkingSpot
{
    private int id;
    private int spotNumber;
    private boolean available;
    
    public ParkingSpot(int id, int spotNumber) {
        this(spotNumber);
    	this.setId(id);
    }

    public ParkingSpot(int spotNumber) {
        this.setSpotNumber(spotNumber);
        available = true;    	
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public void setAvailable(boolean value) {
        available = value;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	public void setSpotNumber(int spotNumber) {
		this.spotNumber = spotNumber;
	}
}