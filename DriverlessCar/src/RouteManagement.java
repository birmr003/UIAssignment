

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Michael Bird
 *
 */
public class RouteManagement extends JPanel {

	private JPanel contentPane;
	private MenuBar menubar;
	private JLabel destinationLabel;
	private JTextArea destination;
	private JButton buttonSetDestination;
	private JButton buttonPatrol;
	private int width = 430;
	
	public RouteManagement(JPanel content, MenuBar m) {
		
		JPanel content1 = new JPanel(new GridLayout(6,1));
		content1.setPreferredSize(new Dimension(width,720));
		
		JLabel title = new JLabel("Route Management", SwingConstants.CENTER);
		title.setFont(new Font("Sans Serif", Font.BOLD, 30));

		
		buttonSetDestination = new JButton("Set Destination");
		buttonPatrol = new JButton("Patrol Area");
		
		buttonPatrol.setForeground(Color.decode("#FFFFFF"));
		buttonPatrol.setBackground(Color.decode("#393939"));
		
		buttonSetDestination.setForeground(Color.decode("#FFFFFF"));
		buttonSetDestination.setBackground(Color.decode("#393939"));
		
		menubar = m;
		destination = new JTextArea();
		destination.setFont(new Font("Sans Serif", Font.BOLD, 30));
		destination.setForeground(Color.BLUE);
		destination.setPreferredSize(new Dimension(width, 50));

		
		
		add(content1);
		destinationLabel = new JLabel("Add/Modify Route", SwingConstants.LEFT);
		destinationLabel.setFont(new Font("Sans Serif", Font.BOLD,30));
		
		content1.add(title);
		//content1.add(new JLabel(""));
		content1.add(destinationLabel);
		content1.add(destination);
		content1.add(buttonSetDestination);
		//content1.add(new JLabel(""));
		content1.add(new JLabel(""));
		content1.add(buttonPatrol);
		
		
		
		add(content1);
		
		
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