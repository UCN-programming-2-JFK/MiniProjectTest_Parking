package supercoders.parking.model.dao.database;

import java.sql.*;
import java.util.*;
import supercoders.parking.model.Employee;
import supercoders.parking.model.dao.EmployeeDao;

public class EmployeeDaoImplementation implements EmployeeDao {

	private Connection connection;

	public EmployeeDaoImplementation() {
		try {
			connection = SqlDbContext.getInstance().getConnection();
		} catch (SQLException exception) {
			System.out.print(exception.getLocalizedMessage());
		}
	}

	@Override
	public List<Employee> getAll() throws Exception {
		 PreparedStatement statement = connection.prepareStatement("SELECT * FROM Employee");
		 ResultSet resultset =  statement.executeQuery();
		 return resultSetToEmployees(resultset);
	}

	@Override
	public Employee getEmployee(String initials) throws Exception {
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM Employee WHERE Initials = ?");
		statement.setString(1, initials);
		ResultSet resultset = statement.executeQuery();
		if(!resultset.isBeforeFirst()) {return null;}
		resultset.next();
		return resultSetToEmployee(resultset);
	}

	@Override
	public boolean addEmployee(Employee newEmployee) throws Exception {
		PreparedStatement statement = connection.prepareStatement("INSERT INTO Employee (Initials, FirstName, LastName, IsManager, EmploymentDate) VALUES(?, ?, ?, ?, ?)");
		statement.setString(1, newEmployee.getInitials());
		statement.setString(2, newEmployee.getFirstName());
		statement.setString(3, newEmployee.getLastName());
		statement.setBoolean(4, newEmployee.isManager());
		statement.setObject(5,newEmployee.getEmploymentDate());

		int rowsAffected = statement.executeUpdate();
		return rowsAffected > 0;
	}

	@Override
	public boolean updateEmployee(Employee employeeToUpdate) throws Exception {
		PreparedStatement statement = connection.prepareStatement("UPDATE Employee SET FirstName=?, LastName=?, IsManager=?, EmploymentDate=? WHERE Initials=?");
		
		statement.setString(1, employeeToUpdate.getFirstName());
		statement.setString(2, employeeToUpdate.getLastName());
		statement.setBoolean(3, employeeToUpdate.isManager());
		statement.setObject(4, employeeToUpdate.getEmploymentDate());
		statement.setString(5, employeeToUpdate.getInitials());

		int rowsAffected = statement.executeUpdate();
		return rowsAffected > 0;
	}

	@Override
	public boolean deleteEmployee(String employeeInitials) throws Exception {
		PreparedStatement statement = connection.prepareStatement("DELETE FROM Employee WHERE Initials = ?");
		statement.setString(1, employeeInitials);
		int rowsAffected = statement.executeUpdate();
		return rowsAffected > 0;
	}

	@Override
	public List<Employee> findEmployeesFromPartOfName(String partOfName) throws Exception {
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM Employee WHERE FirstName LIKE ? OR LastName LIKE ?");
		statement.setString(1, "%" + partOfName + "%");
		statement.setString(2, "%" + partOfName + "%");
		ResultSet resultset = statement.executeQuery();
		return resultSetToEmployees(resultset);
	}

	private List<Employee> resultSetToEmployees(ResultSet resultset) throws Exception {
		List<Employee> employees = new ArrayList<Employee>();
		while (resultset.next()) {
			Employee employee = resultSetToEmployee(resultset);
			employees.add(employee);
		}
		return employees;
	}

	private Employee resultSetToEmployee(ResultSet resultset) throws Exception {
		Employee employee = new Employee(resultset.getString("Initials"), resultset.getString("FirstName"),
				resultset.getString("LastName"), resultset.getBoolean("IsManager"),
				resultset.getDate("EmploymentDate").toLocalDate());
		return employee;
	}
}