package supercoders.parking.model;

public class Car
{
    private String licensePlate;
    private boolean isLuxuryCar;
    
    public Car (String licensePlate, boolean isLuxuryCar) {
        this.setLicensePlate(licensePlate);
        this.isLuxuryCar = isLuxuryCar;
    }

    public boolean isLuxuryCar() {
        return isLuxuryCar;
    }

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
}