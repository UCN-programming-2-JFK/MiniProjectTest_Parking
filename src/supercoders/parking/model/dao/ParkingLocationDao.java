package supercoders.parking.model.dao;

import java.util.List;

import supercoders.parking.model.*;

public interface ParkingLocationDao {
	List<ParkingLocation> getAll();
	ParkingLocation getParkingLocation(int id);
	boolean addParkingLocation(ParkingLocation newParkingLocation);
	boolean updateParkingLocation(ParkingLocation parkingLocationToUpdate);
	boolean deleteParkingLocation(int id);
}