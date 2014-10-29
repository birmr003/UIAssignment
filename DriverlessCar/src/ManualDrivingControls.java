import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * 
 * @author Michael Bird
 *
 */
public class ManualDrivingControls extends JPanel {
	private JPanel contentPane;
	private JLabel title;
	
	public ManualDrivingControls(JPanel content) {
		title = new JLabel("Manual Driving Controls", SwingConstants.CENTER);
		title.setFont(new Font("Sans Serif", Font.BOLD, 30));
		
		add(title);
	}
	

}