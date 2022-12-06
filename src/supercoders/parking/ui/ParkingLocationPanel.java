package supercoders.parking.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import supercoders.parking.model.Employee;
import supercoders.parking.model.ParkingLocation;

public class ParkingLocationPanel extends JPanel implements ItemListener {

	private static final long serialVersionUID = 1L;
	private JComboBox<ParkingLocation> parkingLocationComboBox;

	public ParkingLocationPanel() {
		setMinimumSize(new Dimension(200, 800));
		GridLayout gridLayout = new GridLayout(18, 1);
		setLayout(gridLayout);
		JLabel employeeLabel = new JLabel(" ParkingLocations:");
		add(employeeLabel);
		parkingLocationComboBox = new JComboBox<>();
		add(parkingLocationComboBox, 0,1);
		add(new JPanel());
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

	public void setParkingLocations(List<ParkingLocation> locations) {
		parkingLocationComboBox.removeAllItems();
		for (ParkingLocation location: locations) {
			parkingLocationComboBox.addItem(location);
		}
	}

	public ParkingLocation getSelectedParkingLocation() {
		return (ParkingLocation) parkingLocationComboBox.getSelectedItem();
	}

}