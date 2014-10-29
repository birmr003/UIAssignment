import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * 
 * @author Michael Bird
 *
 */
public class VehicleMaintenance extends JPanel {
	private JPanel contentPane;
	private JLabel title;
	
	public VehicleMaintenance(JPanel content) {
		
		
		
		title = new JLabel("Vehicle Maintenence");
		title.setFont(new Font("Sans Serif", Font.BOLD, 30));
		add(title);
	}
	

}
