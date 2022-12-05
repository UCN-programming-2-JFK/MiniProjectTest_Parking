package supercoders.parking.model;

public class ParkingSpot
{
    private int id;
    private int spotNumber;
    private int parkingLocationId;
    private boolean available;
    
    public ParkingSpot(int id, int spotNumber, int parkingLocationId) {
        this(spotNumber, parkingLocationId);
    	this.setId(id);
    }

    public ParkingSpot(int spotNumber, int parkingLocationId) {
        this.setSpotNumber(spotNumber);
        this.setParkingLocationId(parkingLocationId);
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

	public int getParkingLocationId() {
		return parkingLocationId;
	}

	public void setParkingLocationId(int parkingLocationId) {
		this.parkingLocationId = parkingLocationId;
	}
}