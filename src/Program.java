import java.util.List;

import supercoders.parking.model.Employee;
import supercoders.parking.model.dao.database.EmployeeDaoImplementation;

public class Program {

	public static void main(String[] args) {
		try {
			List<Employee> employees =  new EmployeeDaoImplementation().getAll();
			for(Employee employee : employees) {
				System.out.print(employee.getFirstName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}