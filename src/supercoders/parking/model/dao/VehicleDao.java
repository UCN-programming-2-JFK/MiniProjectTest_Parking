package supercoders.parking.model.dao;
import java.util.List;

import supercoders.parking.model.*;

public interface VehicleDao {
	List<Vehicle> getAll();
	Vehicle getVehicle(String licensePlate);
	boolean addVehicle(Vehicle newVehicle);
	boolean updateVehicle(Vehicle vehicleToUpdate);
	boolean deleteVehicle(String licensePlate);
	
	List<Vehicle> getByOwnerId(int ownerId);
}