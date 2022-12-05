package supercoders.parking.model.dao;
import java.util.List;

import supercoders.parking.model.*;

public interface CarDao {
	List<Car> getAll();
	Car getCar(String licensePlate);
	boolean addCar(Car newCar);
	boolean updateCar(Car carToUpdate);
	boolean deleteCar(String licensePlate);
}