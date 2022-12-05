package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;
import org.junit.jupiter.api.*;
import supercoders.parking.model.Employee;
import supercoders.parking.model.dao.EmployeeDao;
import supercoders.parking.model.dao.database.EmployeeDaoImplementation;

class DataaccessTests {

	private static EmployeeDao employeeDao = new EmployeeDaoImplementation();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		deleteAllTestEmployees(); // cleanup in case last test run was terminated before clean up
		createFiveEmployees();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		deleteAllTestEmployees();
	}

	@Test
	void testAddGetByInitialsAndDelete() throws Exception {
		
		Employee newEmployee = new Employee("XUXU", "Xuluthu [TEST]", "Xuluthuson", false, LocalDate.now());
		int numberOfTestPersons = employeeDao.findEmployeesFromPartOfName("TEST").size();
		employeeDao.addEmployee(newEmployee);
		int numberOfTestPersonsAfterAdd = employeeDao.findEmployeesFromPartOfName("TEST").size();
		assertEquals(numberOfTestPersons + 1, numberOfTestPersonsAfterAdd, "New employee was not added");
		employeeDao.deleteEmployee(newEmployee.getInitials());
		
		int numberOfTestPersonsAfterDelete = employeeDao.findEmployeesFromPartOfName("TEST").size();
		assertEquals(numberOfTestPersonsAfterAdd-1, numberOfTestPersonsAfterDelete, "New employee was not deleted");
	}

	@Test
	void testGetAllEmployees() throws Exception {
		List<Employee> employees = employeeDao.getAll();
		assertTrue(employees.size() >= 5, "Didn't find five Employees");
	}

	@Test
	void testEmployeeUpdate() throws Exception {
		
		final String newFirstName = "Anna new [TEST]";
		final String newLastName = "Annasonson";
		final boolean newManagerStatus = true;
		final LocalDate newEmploymentDate = LocalDate.now().minusYears(15);

		Employee anna = employeeDao.getEmployee("ANAN");
		anna.setFirstName(newFirstName);
		anna.setLastName(newLastName);
		anna.setIsManager(newManagerStatus);
		anna.setEmploymentDate(newEmploymentDate);

		employeeDao.updateEmployee(anna);

		Employee annaFromDatabase = employeeDao.getEmployee("ANAN");
		assertTrue(anna.getFirstName().equals(annaFromDatabase.getFirstName()), "First name not updated");
		assertTrue(anna.getLastName().equals(annaFromDatabase.getLastName()), "Last name not updated");
		assertTrue(anna.isManager() == annaFromDatabase.isManager(), "Manager status not updated");
		assertTrue(anna.getEmploymentDate().equals(annaFromDatabase.getEmploymentDate()), "Employment date not updated");
	}

	@Test
	void testFindEmployeesByPartOfName() throws Exception {
		List<Employee> employees = employeeDao.findEmployeesFromPartOfName("TEST");
		assertEquals(5, employees.size(), "Didn't find the five TEST Employees");
	}

	private static void createFiveEmployees() throws Exception {
		List<Employee> employees = new ArrayList<>();
		LocalDate date = LocalDate.now();
		date.minusYears(1);
		employees.add(new Employee("ANAN", "Anna [TEST]", "Annason", false, date));

		date.minusYears(1);
		employees.add(new Employee("BOBO", "Bob [TEST]", "Bobberson", false, date));

		date.minusYears(1);
		employees.add(new Employee("CHICHI", "Chira [TEST]", "Chirason", true, date));

		date.minusYears(1);
		employees.add(new Employee("DEDE", "Dennis [TEST]", "Dennison", true, date));

		date.minusYears(1);
		employees.add(new Employee("EGEG", "Edith [TEST]", "Edithson", false, date));

		for (Employee employee : employees) {
			employeeDao.addEmployee(employee);
		}
	}

	private static void deleteAllTestEmployees() throws Exception {
		List<Employee> employees = employeeDao.findEmployeesFromPartOfName("TEST");
		for (Employee employeeToDelete : employees) {
			employeeDao.deleteEmployee(employeeToDelete.getInitials());
		}
	}
}