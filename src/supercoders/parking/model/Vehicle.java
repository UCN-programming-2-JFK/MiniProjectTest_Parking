package supercoders.parking.model;

import java.time.LocalDate;

public class Vehicle
{
    private String licensePlate;
    private boolean isElectric;
    private String employeeInitials;
    private LocalDate registrationDate;
    
    public Vehicle (String licensePlate, LocalDate registrationDate, boolean isElectric, String employeeInitials) {
        this.setLicensePlate(licensePlate);
        this.setRegistrationDate(registrationDate);
        this.setIsElectric(isElectric);
        this.setEmployeeInitials(employeeInitials);
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

	public void setIsElectric(boolean isElectric) {
		this.isElectric = isElectric;
	}

	public String getEmployeeInitials() {
		return employeeInitials;
	}

	public void setEmployeeInitials(String ownerInitials) {
		this.employeeInitials = ownerInitials;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
}