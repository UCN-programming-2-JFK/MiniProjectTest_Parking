package supercoders.parking.model;

public class ParkingSpace
{
    private int id;
    private char lot;
    private String location;
    private int fee;
    private boolean available;
    
    public ParkingSpace(int id, char lot, String location, int fee) {
        this(lot, location, fee);
    	this.setId(id);
    }

    public ParkingSpace(char lot, String location, int fee) {
        this.setLot(lot);
        this.setLocation(location);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getLot() {
		return lot;
	}

	public void setLot(char lot) {
		this.lot = lot;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}