package supercoders.parking.model.dao;

import java.util.List;

import supercoders.parking.model.ParkingSpot;

public interface ParkingSpotDao {
	List<ParkingSpot> getAll();
	ParkingSpot getParkingSpot(int id);
	boolean addParkingSpot(ParkingSpot newParkingSpot);
	boolean updateParkingSpot(ParkingSpot parkingSpotToUpdate);
	boolean deleteParkingSpot(int id);
	
	List<ParkingSpot> getByEmployeeId(int employeeId);
	
}