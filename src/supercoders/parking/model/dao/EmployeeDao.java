package supercoders.parking.model.dao;

import java.util.List;

import supercoders.parking.model.Employee;

public interface EmployeeDao {
	List<Employee> getAll();
	Employee getEmployee(int id);
	boolean addEmployee(Employee newEmployee);
	boolean updateEmployee(Employee carToUpdate);
	boolean deleteEmployee(String licensePlate);
	
	Employee FindEmployeeFromPartOfName(String partOfName);
}
