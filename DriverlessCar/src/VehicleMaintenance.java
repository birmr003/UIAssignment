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
	private JButton buttonRequestRepairs;
	private JButton buttonCallout;
	private JLabel titleServiceDetails;
	private JLabel titleManufacturer;
	private int width = 430;

	
	public VehicleMaintenance(JPanel content) {
		
		JPanel content1 = new JPanel(new FlowLayout());
		content1.setPreferredSize(new Dimension(width,700));
		
		title = new JLabel("Vehicle Maintenence", JLabel.CENTER);
		title.setFont(new Font("Sans Serif", Font.BOLD, 30));
		
		/*
		 * ------------------------------------------------------------------------------
		 * Service Details
		 * ------------------------------------------------------------------------------
		 */
		
		titleServiceDetails = new JLabel("Service Details", JLabel.LEFT);
		titleServiceDetails.setFont(new Font("Sans Serif", Font.BOLD, 30));
		
		JPanel serviceDetails = new JPanel(new GridLayout(6,1));
		serviceDetails.setPreferredSize(new Dimension(width, 200));
		
		JLabel servicedetails[] = {
				new JLabel("Current Kilometers: 76,533"),
				new JLabel("Next Service: 80,000"),
				new JLabel("Previous Mechanic: Tony Stark")
		};
		
		
		// Add service details into service details panel
		serviceDetails.add(titleServiceDetails);
		for(JLabel i : servicedetails){
			serviceDetails.add(i);
		}
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Manufacturer Details
		 * ------------------------------------------------------------------------------
		 */
		
		
		JPanel manufacturerDetails = new JPanel(new GridLayout(6,2,0,2));
		manufacturerDetails.setPreferredSize(new Dimension(width, 200));
		
		titleManufacturer = new JLabel("Manufacturer", JLabel.LEFT);
		titleManufacturer .setFont(new Font("Sans Serif", Font.BOLD, 30));
		JLabel manufacturerdetails[] = {
				new JLabel(""),
				new JLabel("Driverless Ambulance"),
				new JLabel("Manufactured By: Google"),
				new JLabel("Series: AX21"),
				new JLabel("Model No: DAMB069AU"),
				new JLabel("Year: 2022"),
				new JLabel("Engine Size: 6182 cc"),
				new JLabel("Power: 340 kW")
		};
		
		manufacturerDetails.add(titleManufacturer);
		for(JLabel i: manufacturerdetails){
			manufacturerDetails.add(i);
		}
		
		

		
		/*
		 * ------------------------------------------------------------------------------
		 * Request Repairs Button + Callout
		 * ------------------------------------------------------------------------------
		 */
		
		buttonRequestRepairs = new JButton("Request Emergency Repairs");
		buttonRequestRepairs.setPreferredSize(new Dimension(width,50));
		buttonRequestRepairs.setForeground(Color.decode("#FFFFFF"));
		buttonRequestRepairs.setBackground(Color.decode("#393939"));
		
		buttonCallout = new JButton("Emergency Callout");
		buttonCallout.setPreferredSize(new Dimension(width,50));
		buttonCallout.setForeground(Color.decode("#FFFFFF"));
		buttonCallout.setBackground(Color.decode("#393939"));
		
		
		
		
		JPanel space = new JPanel();
		space.setPreferredSize(new Dimension(width,16));
		
		
		// add to layout
		content1.add(title);
		content1.add(space);
		content1.add(serviceDetails);
		content1.add(manufacturerDetails);
		content1.add(buttonRequestRepairs);
		content1.add(new JPanel());
		content1.add(buttonCallout);
		add(content1);
		
		
		// add button listeners
		buttonListeners();
		
	}
	

	public void buttonListeners(){
		buttonCallout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					buttonCallout.setFocusPainted(false);
			}
		});		
		
		buttonRequestRepairs.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					buttonRequestRepairs.setFocusPainted(false);
			}
		});			
		
		
	}
	
	
	
	
	
}
