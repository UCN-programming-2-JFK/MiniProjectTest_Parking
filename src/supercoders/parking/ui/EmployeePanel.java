package supercoders.parking.ui;

import java.awt.*;
import javax.swing.*;

import supercoders.parking.model.Employee;

public class EmployeePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Employee employee;
	private GridLayout gridLayout = new GridLayout(8, 2);
	private JLabel initialsLabel, firstNameLabel, lastNameLabel, managerLabel, employmentDateLabel;

	public EmployeePanel() {

		setBackground(Color.white);
		this.setLayout(gridLayout);
		add(new JLabel("Initials"));
		add(initialsLabel = new JLabel());
		add(new JLabel("First name(s)"));
		add(firstNameLabel = new JLabel());
		add(new JLabel("Last name"));
		add(lastNameLabel = new JLabel());
		add(new JLabel("Manager"));
		add(managerLabel = new JLabel());
		add(new JLabel("Employment date"));
		add(employmentDateLabel = new JLabel());
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
		updateLabels();
	}

	private void updateLabels() {

		initialsLabel.setText(getEmployee().getInitials());
		firstNameLabel.setText(getEmployee().getFirstName());
		lastNameLabel.setText(getEmployee().getLastName());
		managerLabel.setText(getEmployee().isManager() ? "yes" : "no");
		employmentDateLabel.setText(getEmployee().getEmploymentDate().toString());

	}
}