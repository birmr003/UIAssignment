
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class RouteManagement extends JPanel {

	private JPanel contentPane;
	private MenuBar menubar;
	private JLabel destinationLabel;
	private JTextArea destination;
	private JButton buttonSetDestination;
	private JButton buttonPatrol;
	
	public RouteManagement(JPanel content, MenuBar m) {
		
		JPanel content1 = new JPanel(new GridLayout(6,1));
		content1.setMinimumSize(new Dimension(520,720));
		
		buttonSetDestination = new JButton("Set Destination");
		buttonPatrol = new JButton("Patrol Area");
		
		menubar = m;
		destination = new JTextArea();
		
		add(content1);
		destinationLabel = new JLabel("Destination");
		destinationLabel.setFont(new Font("Serif", Font.BOLD,48));
		
		content1.add(new JLabel("Route Management"));
		content1.add(destinationLabel);
		content1.add(destination);
		content1.add(buttonSetDestination);
		content1.add(buttonPatrol);
		
		buttonListeners();

	}

	private void buttonListeners(){
		buttonSetDestination.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					menubar.setDestinationText(destination.getText());
					buttonSetDestination.setFocusPainted(false);
			}
		});	
		
		buttonPatrol.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					menubar.setDestinationText("----Patrolling Area----");
					buttonPatrol.setFocusPainted(false);
			}
		});		
	}
	
	
	

}