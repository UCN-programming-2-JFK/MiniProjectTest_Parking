package supercoders.parking.model;

import java.sql.Date;

public class RentalAgreement
{
    private int id;
    private int spotNumber;
    private int employeeId;
    private Date startDate, endDate;

	public RentalAgreement(int id, int employeeId, int spotNumber, Date startDate, Date endDate) {
		this(employeeId, spotNumber, startDate, endDate);
		this.setId(id);
	}

	public RentalAgreement(int employeeId, int spotNumber, Date startDate, Date endDate) {
		this.setEmployeeId(employeeId);
		this.setSpotNumber(spotNumber);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
}