package supercoders.parking.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import supercoders.parking.controller.AssignParkingPlaceController;
import supercoders.parking.model.Employee;

public class ParkingAdministrationPanel extends JPanel {
	private static final long serialVersionUID = 1L;


	private EmployeesPanel employeePanel = new EmployeesPanel();
	private ParkingLocationPanel parkingLocationPanel = new ParkingLocationPanel();

	public ParkingAdministrationPanel() {
		setBackground(Color.yellow);
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = constraints.weighty = 1;
		add(employeePanel, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 0;
		add(parkingLocationPanel, constraints);
		
		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(300, 800));
		panel.setBackground(Color.red);
		constraints.gridx = 1;
		constraints.gridy = 0;
		add(panel, constraints);
		try {
			employeePanel.setEmployees(AssignParkingPlaceController.getInstance().getEmployees());
			parkingLocationPanel.setParkingLocations(AssignParkingPlaceController.getInstance().getParkingLocations());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}