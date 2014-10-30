

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * The base of operations for the operator to set or modify the current destination. The paramedic also has
 * the option of choosing to toggle patrolling on/off.
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
		
		JPanel content1 = new JPanel(new FlowLayout());
		content1.setPreferredSize(new Dimension(width,720));
		
		JLabel title = new JLabel("Route Management", SwingConstants.CENTER);
		title.setFont(new Font("Sans Serif", Font.BOLD, 30));

		
		buttonSetDestination = new JButton("Set Destination");
		buttonSetDestination.setPreferredSize(new Dimension(width,60));
		
		
		JPanel space = new JPanel();
		space.setPreferredSize(new Dimension(width,100));
		buttonPatrol = new JButton("Patrol Area");
		
		buttonPatrol.setForeground(Color.decode("#FFFFFF"));
		buttonPatrol.setBackground(Color.decode("#393939"));
		buttonPatrol.setPreferredSize(new Dimension(width,60));
		
		buttonSetDestination.setForeground(Color.decode("#FFFFFF"));
		buttonSetDestination.setBackground(Color.decode("#393939"));
		
		menubar = m;
		destination = new JTextArea();
		destination.setWrapStyleWord(true);
		destination.setLineWrap(true);
		destination.setFont(new Font("Sans Serif", Font.BOLD, 20));
		destination.setForeground(Color.BLUE);
		destination.setPreferredSize(new Dimension(width, 60));
		
		destination.setText(m.destinationText.getText().substring(21));

		
		JPanel space2 = new JPanel();
		space2.setPreferredSize(new Dimension(width,16));
		
		destinationLabel = new JLabel("Add/Modify Route", SwingConstants.LEFT);
		destinationLabel.setPreferredSize(new Dimension(width,60));
		destinationLabel.setFont(new Font("Sans Serif", Font.BOLD,30));
		

		content1.add(destinationLabel);
		content1.add(destination);
		content1.add(buttonSetDestination);
		content1.add(space);
		content1.add(buttonPatrol);
		
		
		add(title);
		add(space2);
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