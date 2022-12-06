package supercoders.parking.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ParkingAdministrationWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public ParkingAdministrationWindow() {
		//JFrame.setDefaultLookAndFeelDecorated(true);
				setTitle("SuperCoders Parking Administration");
				setLayout(new BorderLayout());
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().add(new ParkingAdministrationPanel(), BorderLayout.CENTER );
//				setJMenuBar(createMenuBar(panel));
			setMinimumSize(new Dimension(800,600));
				setVisible(true);
				
//				setResizable(false);
				pack();
	}	
}