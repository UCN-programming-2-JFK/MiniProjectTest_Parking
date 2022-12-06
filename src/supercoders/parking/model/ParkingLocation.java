package supercoders.parking.model;

public class ParkingLocation
{
    private int id;
    private String name;
    private int monthlyFee;
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
	public int getMonthlyFee() {
		return monthlyFee;
	}
	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	
	public ParkingLocation(int id, String name, int monthlyFee) {
		this(name, monthlyFee);
		this.id = id;
	}
	
	public ParkingLocation(String name, int monthlyFee) {
		this.name = name;
		this.monthlyFee = monthlyFee;
	}	
	@Override
	public String toString() {
		return getName() + " : " + getMonthlyFee() + " DKK/month";
	}
}