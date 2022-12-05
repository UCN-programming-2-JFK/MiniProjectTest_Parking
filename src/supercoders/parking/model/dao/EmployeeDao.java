package supercoders.parking.model.dao;

import java.util.List;

import supercoders.parking.model.Employee;

public interface EmployeeDao {
	List<Employee> getAll() throws Exception;
	Employee getEmployee(String initials) throws Exception;
	boolean addEmployee(Employee newEmployee) throws Exception;
	boolean updateEmployee(Employee employeeToUpdate) throws Exception;
	boolean deleteEmployee(String employeeInitials) throws Exception;
	
	List<Employee> findEmployeesFromPartOfName(String partOfName) throws Exception;
}