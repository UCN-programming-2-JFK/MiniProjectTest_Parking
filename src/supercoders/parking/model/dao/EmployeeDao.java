package supercoders.parking.model.dao;

import java.util.List;

import supercoders.parking.model.Employee;

public interface EmployeeDao {
	List<Employee> getAll();
	Employee getEmployee(String initials);
	boolean addEmployee(Employee newEmployee);
	boolean updateEmployee(Employee employeeToUpdate);
	boolean deleteEmployee(String employeeInitials);
	
	Employee FindEmployeeFromPartOfName(String partOfName);
}