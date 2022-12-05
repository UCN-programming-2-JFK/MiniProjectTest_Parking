package supercoders.parking.model;

public class Car
{
    private String licensePlate;
    private boolean isElectric;
    
    public Car (String licensePlate, boolean isElectric) {
        this.setLicensePlate(licensePlate);
        this.setElectric(isElectric);
    }

    public boolean isElectric() {
        return isElectric;
    }

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public void setElectric(boolean isElectric) {
		this.isElectric = isElectric;
	}
}