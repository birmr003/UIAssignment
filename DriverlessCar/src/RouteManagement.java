
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class RouteManagement extends JPanel {

	private JPanel contentPane;
	
	private JLabel destinationLabel;
	private JTextArea destination;
	
	
	public RouteManagement(JPanel content) {
		
		JPanel content1 = new JPanel(new GridLayout(3,1,0,40));
		content1.setMinimumSize(new Dimension(520,720));
		
		
		add(content1);
		destinationLabel = new JLabel("Destination");
		destinationLabel.setFont(new Font("Arial", Font.BOLD,48));
		content1.add(new JLabel("Route Management"));
		content1.add(destinationLabel);
		content1.add(new JTextArea());
	}
	
}