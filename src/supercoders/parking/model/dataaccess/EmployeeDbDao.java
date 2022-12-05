package supercoders.parking.model.dataaccess;

import java.util.List;

import supercoders.parking.model.Employee;
import supercoders.parking.model.dao.EmployeeDao;

public class EmployeeDbDao implements EmployeeDao {

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(String initials) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addEmployee(Employee newEmployee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employeeToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(String employeeInitials) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee FindEmployeeFromPartOfName(String partOfName) {
		// TODO Auto-generated method stub
		return null;
	}

}
