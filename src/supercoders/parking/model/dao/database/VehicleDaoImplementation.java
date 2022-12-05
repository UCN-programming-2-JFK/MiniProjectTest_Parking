package supercoders.parking.model.dao.database;

import java.sql.*;
import java.util.*;
import supercoders.parking.model.Vehicle;
import supercoders.parking.model.dao.VehicleDao;

public class VehicleDaoImplementation implements VehicleDao {

	private Connection connection;

	public VehicleDaoImplementation() {
		try {
			connection = SqlDbContext.getInstance().getConnection();
		} catch (SQLException exception) {
			System.out.print(exception.getLocalizedMessage());
		}
	}

	@Override
	public List<Vehicle> getAll() throws Exception {
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM Vehicle");
		ResultSet resultset = statement.executeQuery();
		return resultSetToVehicles(resultset);
	}


	@Override
	public Vehicle getVehicle(String licensePlate) throws Exception {
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM Vehicle WHERE LicensePlate = ?");
		statement.setString(1, licensePlate);
		ResultSet resultset = statement.executeQuery();
		if (!resultset.isBeforeFirst()) {
			return null;
		}
		resultset.next();
		return resultSetToVehicle(resultset);
	}

	@Override
	public boolean addVehicle(Vehicle newVehicle) throws Exception {
		PreparedStatement statement = connection.prepareStatement(
				"INSERT INTO Vehicle (LicensePlate, RegistrationDate, IsElectric, EmployeeInitials) VALUES(?, ?, ?, ?)");
		statement.setString(1, newVehicle.getLicensePlate());
		statement.setObject(2, newVehicle.getRegistrationDate());
		statement.setBoolean(3, newVehicle.isElectric());
		statement.setString(4, newVehicle.getEmployeeInitials());
		int rowsAffected = statement.executeUpdate();
		return rowsAffected > 0;
	}

	@Override
	public boolean updateVehicle(Vehicle vehicleToUpdate) throws Exception {
		PreparedStatement statement = connection.prepareStatement(
				"UPDATE Vehicle SET RegistrationDate=?, IsElectric=?, EmployeeInitials=? WHERE LicensePlate=?");

		statement.setObject(1, vehicleToUpdate.getRegistrationDate());
		statement.setBoolean(2, vehicleToUpdate.isElectric());
		statement.setString(3, vehicleToUpdate.getEmployeeInitials());
		statement.setString(4, vehicleToUpdate.getLicensePlate());

		int rowsAffected = statement.executeUpdate();
		return rowsAffected > 0;
	}

	@Override
	public boolean deleteVehicle(String licensePlate) throws Exception {
		PreparedStatement statement = connection.prepareStatement("DELETE FROM Vehicle WHERE LicensePlate = ?");
		statement.setString(1, licensePlate);
		int rowsAffected = statement.executeUpdate();
		return rowsAffected > 0;
	}

	@Override
	public List<Vehicle> getByEmployeeInitials(String employeeInitials) throws Exception {
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM Vehicle WHERE EmployeeInitials = ?");
		statement.setString(1, employeeInitials);
		ResultSet resultset = statement.executeQuery();
		return resultSetToVehicles(resultset);
	}

	private List<Vehicle> resultSetToVehicles(ResultSet resultset) throws Exception {
		List<Vehicle> employees = new ArrayList<Vehicle>();
		while (resultset.next()) {
			Vehicle employee = resultSetToVehicle(resultset);
			employees.add(employee);
		}
		return employees;
	}

	private Vehicle resultSetToVehicle(ResultSet resultset) throws Exception {
		Vehicle vehicle = new Vehicle(resultset.getString("LicensePlate"),
				resultset.getDate("RegistrationDate").toLocalDate(), resultset.getBoolean("IsElectric"),
				resultset.getString("EmployeeInitials"));
		return vehicle;
	}
}