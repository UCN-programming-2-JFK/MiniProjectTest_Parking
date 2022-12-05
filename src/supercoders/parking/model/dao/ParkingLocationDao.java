package supercoders.parking.model.dao;

import java.util.List;

import supercoders.parking.model.*;

public interface ParkingLocationDao {
	List<ParkingLocation> getAll() throws Exception;
	ParkingLocation getParkingLocation(int id) throws Exception;
	int addParkingLocation(ParkingLocation newParkingLocation) throws Exception;
	boolean updateParkingLocation(ParkingLocation parkingLocationToUpdate) throws Exception;
	boolean deleteParkingLocation(int id) throws Exception;
}