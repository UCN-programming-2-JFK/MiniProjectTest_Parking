package supercoders.parking.model.dao.database;

import java.sql.*;
import java.util.*;
import supercoders.parking.model.ParkingLocation;
import supercoders.parking.model.dao.ParkingLocationDao;

public class ParkingLocationDaoImplementation implements ParkingLocationDao {

	private Connection connection;

	public ParkingLocationDaoImplementation() {
		try {
			connection = SqlDbContext.getInstance().getConnection();
		} catch (SQLException exception) {
			System.out.print(exception.getLocalizedMessage());
		}
	}

	@Override
	public List<ParkingLocation> getAll() throws Exception {
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM ParkingLocation");
		ResultSet resultset = statement.executeQuery();
		return resultSetToParkingLocations(resultset);
	}


	@Override
	public ParkingLocation getParkingLocation(int id) throws Exception {
//		PreparedStatement statement = connection.prepareStatement("SELECT * FROM ParkingLocation WHERE LicensePlate = ?");
//		statement.setString(1, licensePlate);
//		ResultSet resultset = statement.executeQuery();
//		if (!resultset.isBeforeFirst()) {
//			return null;
//		}
//		resultset.next();
//		return resultSetToParkingLocation(resultset);
		return null;
	}

	@Override
	public int addParkingLocation(ParkingLocation newParkingLocation) throws Exception {
		PreparedStatement statement = connection.prepareStatement(
				"INSERT INTO ParkingLocation (LicensePlate, RegistrationDate, IsElectric, EmployeeInitials) VALUES(?, ?, ?, ?)");
//		statement.setString(1, newParkingLocation.getLicensePlate());
//		statement.setObject(2, newParkingLocation.getRegistrationDate());
//		statement.setBoolean(3, newParkingLocation.isElectric());
//		statement.setString(4, newParkingLocation.getEmployeeInitials());
//		int rowsAffected = statement.executeUpdate();
//		return rowsAffected > 0;
		return 0;
	}

	@Override
	public boolean updateParkingLocation(ParkingLocation vehicleToUpdate) throws Exception {
		PreparedStatement statement = connection.prepareStatement(
				"UPDATE ParkingLocation SET RegistrationDate=?, IsElectric=?, EmployeeInitials=? WHERE LicensePlate=?");
//
//		statement.setObject(1, vehicleToUpdate.getRegistrationDate());
//		statement.setBoolean(2, vehicleToUpdate.isElectric());
//		statement.setString(3, vehicleToUpdate.getEmployeeInitials());
//		statement.setString(4, vehicleToUpdate.getLicensePlate());

		int rowsAffected = statement.executeUpdate();
		return rowsAffected > 0;
	}

	@Override
	public boolean deleteParkingLocation(int id) throws Exception {
//		PreparedStatement statement = connection.prepareStatement("DELETE FROM ParkingLocation WHERE LicensePlate = ?");
//		statement.setString(1, licensePlate);
//		int rowsAffected = statement.executeUpdate();
//		return rowsAffected > 0;
		return true;
	}


	private List<ParkingLocation> resultSetToParkingLocations(ResultSet resultset) throws Exception {
		List<ParkingLocation> employees = new ArrayList<ParkingLocation>();
		while (resultset.next()) {
			ParkingLocation employee = resultSetToParkingLocation(resultset);
			employees.add(employee);
		}
		return employees;
	}

	private ParkingLocation resultSetToParkingLocation(ResultSet resultset) throws Exception {
		return new ParkingLocation(resultset.getInt("Id"), resultset.getString("Name"), resultset.getInt("MonthlyFee"));
	}
}