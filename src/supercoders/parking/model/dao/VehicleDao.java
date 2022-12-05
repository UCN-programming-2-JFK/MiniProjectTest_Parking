package supercoders.parking.model.dao;
import java.util.List;

import supercoders.parking.model.*;

public interface VehicleDao {
	List<Vehicle> getAll() throws Exception;
	Vehicle getVehicle(String licensePlate) throws Exception;
	boolean addVehicle(Vehicle newVehicle) throws Exception;
	boolean updateVehicle(Vehicle vehicleToUpdate) throws Exception;
	boolean deleteVehicle(String licensePlate) throws Exception;
	
	List<Vehicle> getByEmployeeInitials(String employeeInitials) throws Exception;
}