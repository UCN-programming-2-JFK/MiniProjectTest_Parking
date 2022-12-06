package supercoders.parking.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import supercoders.parking.model.Employee;

public class EmployeesPanel extends JPanel implements ItemListener {

	private static final long serialVersionUID = 1L;
	private JComboBox<Employee> employeesComboBox;
	private EmployeePanel employeePanel;
	
	public EmployeesPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		setLayout(gridBagLayout);
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(0,1));
		JLabel employeeLabel = new JLabel(" Employees:");
		employeeLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		topPanel.add(employeeLabel);
		
		employeesComboBox = new JComboBox<>();
		employeesComboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
		
		topPanel.add(employeesComboBox);
		
		employeesComboBox.addItemListener(this);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridwidth = 3;
		constraints.weightx = constraints.weighty = 1;
		constraints.fill = GridBagConstraints.BOTH;
		add(topPanel, constraints);
		
		constraints.gridx=0;
		constraints.gridy = 1;
		constraints.weighty = 5;
		add(employeePanel = new EmployeePanel(), constraints);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Employee employee = (Employee)e.getItem();
		employeePanel.setEmployee(employee);
	}

	public void setEmployees(List<Employee> employees) {
		employeesComboBox.removeAllItems();
		for (Employee employee : employees) {
			employeesComboBox.addItem(employee);
		}
	}

	public Employee getSelectedEmployee() {
		return (Employee) employeesComboBox.getSelectedItem();
	}

}