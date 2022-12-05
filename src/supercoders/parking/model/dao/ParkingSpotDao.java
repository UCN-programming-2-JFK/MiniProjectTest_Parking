package supercoders.parking.model.dao;

import java.util.List;

import supercoders.parking.model.ParkingSpot;

public interface ParkingSpotDao {
	List<ParkingSpot> getAll() throws Exception;
	ParkingSpot getParkingSpot(int id) throws Exception;
	int addParkingSpot(ParkingSpot newParkingSpot) throws Exception;
	boolean updateParkingSpot(ParkingSpot parkingSpotToUpdate) throws Exception;
	boolean deleteParkingSpot(int id) throws Exception;
	
	List<ParkingSpot> getByEmployeeId(String employeeInitials) throws Exception;
	
}