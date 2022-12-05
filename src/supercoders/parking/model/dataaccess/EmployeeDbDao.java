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
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addEmployee(Employee newEmployee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(Employee carToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(String licensePlate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee FindEmployeeFromPartOfName(String partOfName) {
		// TODO Auto-generated method stub
		return null;
	}

}
