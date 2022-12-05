package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;

import javax.management.loading.PrivateClassLoader;

import org.junit.jupiter.api.*;
import supercoders.parking.model.Employee;
import supercoders.parking.model.Vehicle;
import supercoders.parking.model.dao.EmployeeDao;
import supercoders.parking.model.dao.VehicleDao;
import supercoders.parking.model.dao.database.EmployeeDaoImplementation;
import supercoders.parking.model.dao.database.VehicleDaoImplementation;

class VehicleDataaccessTests {

	private static VehicleDao vehicleDao = new VehicleDaoImplementation();
	private static EmployeeDao employeeDao = new EmployeeDaoImplementation();
		
	private static Employee owner = new Employee("TESTABCD", "Owner [TEST]", "Testerson", false, LocalDate.now());
	private final static String firstVehicleLicensePlate = "TEST123";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		deleteOwnerWithAllTestVehicles(); // cleanup in case last test run was terminated before clean up
		createOwnerAndThreeVehicles();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		deleteOwnerWithAllTestVehicles();
	}

	@Test
	void testAddGetByLicensePlateAndDelete() throws Exception {
		
		Vehicle newVehicle = new Vehicle("TEST999", LocalDate.now(), false, owner.getInitials());
		int numberOfOwnersVehicles = vehicleDao.getByEmployeeInitials(owner.getInitials()).size();
		vehicleDao.addVehicle(newVehicle);
		int numberOfOwnersVehiclesAfterAdd = vehicleDao.getByEmployeeInitials(owner.getInitials()).size();
		assertEquals(numberOfOwnersVehicles + 1, numberOfOwnersVehiclesAfterAdd, "New vehicle was not added");
		vehicleDao.deleteVehicle(newVehicle.getLicensePlate());
		
		int numberOfOwnersVehiclesAfterDelete = vehicleDao.getByEmployeeInitials(owner.getInitials()).size();
		assertEquals(numberOfOwnersVehiclesAfterAdd-1, numberOfOwnersVehiclesAfterDelete, "New vehicle was not deleted");
	}


	@Test
	void testGetAllVehicles() throws Exception {
		List<Vehicle> vehicles = vehicleDao.getAll();
		assertTrue(vehicles.size() >= 3, "Didn't find at least three vehicles");
	}
//
	@Test
	void testVehicleUpdate() throws Exception {
		
		final boolean newIsElectrical = true;
		final LocalDate newRegistrationDate = LocalDate.now().minusYears(15);

		Vehicle car = vehicleDao.getVehicle(firstVehicleLicensePlate);
		car.setIsElectric(newIsElectrical);
		car.setRegistrationDate(newRegistrationDate);

		vehicleDao.updateVehicle(car);

		Vehicle carFromDatabase = vehicleDao.getVehicle(firstVehicleLicensePlate);
		assertTrue(car.isElectric() == carFromDatabase.isElectric(), "Is electric not updated");
		assertEquals(car.getRegistrationDate() , carFromDatabase.getRegistrationDate(), "Registration date not updated");
	}

	@Test
	void testFindVehiclesByEmployeeInitials() throws Exception {
		List<Vehicle> vehicles = vehicleDao.getByEmployeeInitials(owner.getInitials());
		assertEquals(3, vehicles.size(), "Didn't find the employee's three vehicles");
	}

	private static void createOwnerAndThreeVehicles() throws Exception {

		employeeDao.addEmployee(owner);
		
		List<Vehicle> vehicles = new ArrayList<>();
		LocalDate date = LocalDate.now();
		date.minusYears(1);
		vehicles.add(new Vehicle(firstVehicleLicensePlate, date, false, owner.getInitials()));
		
		date.minusYears(1);
		vehicles.add(new Vehicle("TEST456", date, false, owner.getInitials()));
		
		date.minusYears(1);
		vehicles.add(new Vehicle("TEST789", date, true, owner.getInitials()));
		
		for (Vehicle vehicle : vehicles) {
			vehicleDao.addVehicle(vehicle);
		}
	}

	private static void deleteOwnerWithAllTestVehicles() throws Exception {
		employeeDao.deleteEmployee(owner.getInitials());
	}
}