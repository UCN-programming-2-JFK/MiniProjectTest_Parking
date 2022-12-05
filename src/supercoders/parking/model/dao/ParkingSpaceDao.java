package supercoders.parking.model.dao;

import java.util.List;

import supercoders.parking.model.ParkingSpace;

public interface ParkingSpaceDao {
	List<ParkingSpace> getAll();
	ParkingSpace getParkingSpace(int id);
	boolean addParkingSpace(ParkingSpace newParkingSpace);
	boolean updateParkingSpace(ParkingSpace parkingSpaceToUpdate);
	boolean deleteParkingSpace(int id);
}
