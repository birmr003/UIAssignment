import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.EmptyBorder;




/**
 * 
 * @author Michael Bird
 *
 */
public class MainMenu extends JPanel {
	
	public MenuBar topMenu;
	
	private JPanel contentPane;
	
	private JPanel rightSide;
	
	private JButton buttonTopLeft;
	
	private JButton buttonFrontView;
	
	private JButton buttonTopRight;
	
	private JButton buttonLeftView;
	
	private JButton buttonMapView;
	
	private JButton buttonRightView;
	
	private JButton buttonBottomRight;
	
	private JButton buttonRearView;
	
	private JButton buttonBottomLeft;
	
	private JButton buttonLogout;
	
	private JButton buttonCallDispatch;
	
	private JButton buttonEmergencyMode;
	
	private JButton buttonManualDriving;
	

	// Only way of getting around making the call dispatch label to count
	// I really wanted to make the button text rather than overlay a label
	 static class C
	 {
		 int seconds=0;
	     int minutes=0;
	     int hours=0;
	     
	     String seconds_text = String.format("%02d", seconds);
	     String minutes_text = String.format("%02d", minutes);
	     String hours_text = String.format("%02d", hours);
	     
    	 String s = "";

	     C(){
	    	 setTime();
	     }
	     
	     private void add(){
	    	 seconds++;
	    	 if(seconds == 60){
	    		 seconds = 0;
	    		 minutes++;
	    		 if(minutes ==60){
	    			 minutes = 0;
	    			 hours++;
	    		 }
	    	 }
	    	 setTime();
	     }
	     
	     private void setTime(){
		     seconds_text = String.format("%02d", seconds);
		     minutes_text = String.format("%02d", minutes);
		     hours_text = String.format("%02d", hours);
	    	 s = hours_text + ":" +minutes_text + ":" + seconds_text;
	     }
	     
	     public String time(){
	    	 add();
	    	 return s;
	     }
	     
	 }
	
	/**
	 * Constructor
	 * @param panel
	 * @param mainLayout
	 */
	public MainMenu(JPanel panel, DriverlessCar mainLayout){
		contentPane = panel;
		setOpaque(true);
		setBackground(Color.gray.brighter());
		
		/*
		 * ------------------------------------------------------------------------------
		 * Set up JSplitPane for left(GPS) and right(Content)
		 * ------------------------------------------------------------------------------
		 */

		JSplitPane j = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		j.setPreferredSize(new Dimension(1270,760));
		j.setEnabled(false);
		
		// Add menu bar
		topMenu = new MenuBar(contentPane,mainLayout);
		
		
		// Left side
		JPanel leftSide = getLeftSide();
		
		// rightSide
		//rightSide = new JPanel(new CardLayout());   // removed to see if still works
		rightSide = getRightSide();
		
		// GPS SIDE
		j.setLeftComponent(leftSide);
		
		// CONTENT SIDE
		j.setRightComponent(rightSide);

		// SET BUTTON LISTENERS
		addListeners();
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Add menu bar and JSplitPane to layout
		 * ------------------------------------------------------------------------------
		 */
		add(topMenu,BorderLayout.PAGE_START);
		add(j);
		
	}
	
	
	
	private JPanel getLeftSide(){
		
		
		// Set up left side Panel
		JPanel leftSide = new JPanel(new FlowLayout(0,0,0));
		leftSide.setMaximumSize(new Dimension(650,720));
		leftSide.setMinimumSize(new Dimension(650,720));
				

		/*
		 * ------------------------------------------------------------------------------
		 * Left Side - Top Row - Row 1
		 * 
		 * 	--	Left: Button  (175, 200)
		 * 	--	Middle: Camera Feed (300,200)
		 * 	--	Right: Button  (175, 200)
		 * 
		 * ------------------------------------------------------------------------------
		 */
		
	
		// Create r1 panel with 3 empty elements 
		JPanel r1 = new JPanel(new FlowLayout(0,0,0));
		JPanel r1_elem[] = {
				new JPanel(new FlowLayout(0,0,0)),
				new JPanel(new FlowLayout(0,0,0)),
				new JPanel(new FlowLayout(0,0,0))
		};
				
		
		// Top Right Button
		r1_elem[0].setPreferredSize(new Dimension(175, 200));
		buttonTopRight = new JButton("<html>" + "<p>CURRENT JOBS<p><br><br>" + "<p style='text-align:center'>3<p>" + "</html>");
		buttonTopRight.setPreferredSize(new Dimension(175,200));
		buttonTopRight.setBackground(Color.decode("#16A79D"));
		//buttonTopRight.setOpaque(true);
		r1_elem[0].add(buttonTopRight);
		
		
		
		// Middle - Camera View
		ImageIcon frontViewImage = new ImageIcon(MainMenu.class.getResource("Images/frontview.jpg"));
		buttonFrontView = new JButton();
		buttonFrontView.setIcon(frontViewImage);
		buttonFrontView.setBorder(null);
		buttonFrontView.setMargin(new Insets(0, 0, 0, 0));
		r1_elem[1].add(buttonFrontView);
		r1_elem[1].setPreferredSize(new Dimension(300, 200));
		
		

		// Top Left Button
		r1_elem[2].setPreferredSize(new Dimension(175, 200));
		buttonTopLeft = new JButton("<html>" + "ADD OR CHANGE ROUTE<br>" + "</html>");
		buttonTopLeft.setBackground(Color.decode("#CF4858"));
		buttonTopLeft.setPreferredSize(new Dimension(174,200));
		r1_elem[2].add(buttonTopLeft);
		
		
		
		// Add elements to row 1 panel
		for(JPanel i : r1_elem){
			r1.add(i,FlowLayout.LEFT);
		}
		
		
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Left Side - Middle Row - Row 2
		 * 
		 * 	--	Left: Button  (175, 250)
		 * 	--	Middle: Camera Feed (300, 250)
		 * 	--	Right: Button  (175, 250)
		 * ------------------------------------------------------------------------------
		 */
		
		// Set up row 2 panel
		JPanel r2 = new JPanel(new FlowLayout(0,0,0));
		r2.setPreferredSize(new Dimension(650, 250));
		JPanel r2_elem[] = {
				new JPanel(new FlowLayout(0,0,0)),
				new JPanel(new FlowLayout(0,0,0)),
				new JPanel(new FlowLayout(0,0,0))
		};

		
		// Middle - Left Camera
		r2_elem[0].setPreferredSize(new Dimension(175,r2.getPreferredSize().height));
		ImageIcon leftViewImage = new ImageIcon(MainMenu.class.getResource("Images/leftview.jpg"));
		buttonLeftView = new JButton();
		buttonLeftView.setIcon(leftViewImage);
		buttonLeftView.setBorder(null);
		buttonLeftView.setMargin(new Insets(0, 0, 0, 0));
		r2_elem[0].add(buttonLeftView);
		
		
		// Middle - Map
		r2_elem[1].setPreferredSize(new Dimension(300, r2.getPreferredSize().height));
		ImageIcon gpsImage = new ImageIcon(MainMenu.class.getResource("Images/gps.jpg"));
		r2_elem[1].add(new JLabel(gpsImage));
		
		
		// Middle - Right Camera
		r2_elem[2].setPreferredSize(new Dimension(175, r2.getPreferredSize().height));
		ImageIcon rightViewImage = new ImageIcon(MainMenu.class.getResource("Images/rightview.jpg"));
		buttonRightView = new JButton();
		buttonRightView .setIcon(rightViewImage);
		buttonRightView .setBorder(null);
		buttonRightView .setMargin(new Insets(0, 0, 0, 0));
		r2_elem[2].add(buttonRightView);
		
		
		// Add elements to row 2 panel
		for(JPanel i : r2_elem){
			r2.add(i);
		}
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Left Side - Second-Bottom Row - Row 3
		 * 
		 * 	--	Left: Button  (175, 200)
		 * 	--	Middle: Camera Feed (300,200)
		 * 	--	Right: Button  (175, 200)
		 * 
		 * ------------------------------------------------------------------------------
		 */
		
		// Set up row 3 panel
		JPanel r3 = new JPanel(new FlowLayout(0,0,0));
		JPanel r3_elem[] = {
				new JPanel(new FlowLayout(0,0,0)),
				new JPanel(new FlowLayout(0,0,0)),
				new JPanel(new FlowLayout(0,0,0))
		};
		
		
		// Right Side button
		r3_elem[0].setPreferredSize(new Dimension(175, 200));
		buttonBottomRight = new JButton("PARK VEHICLE");
		buttonBottomRight.setPreferredSize(new Dimension(175,200));
		buttonBottomRight.setBackground(Color.decode("#80628B"));
		r3_elem[0].add(buttonBottomRight);
		

		// Rear View Camera
		r3_elem[1].setPreferredSize(new Dimension(300, 200));
		ImageIcon rearViewImage = new ImageIcon(MainMenu.class.getResource("Images/rearview.jpg"));
		buttonRearView = new JButton();
		buttonRearView.setIcon(rearViewImage);
		buttonRearView.setBorder(null);
		buttonRearView.setMargin(new Insets(0, 0, 0, 0));
		r3_elem[1].add(buttonRearView);
		
		
		// Left side button
		r3_elem[2].setPreferredSize(new Dimension(175, 200));
		buttonBottomLeft = new JButton("EMERGENCY STOP");
		buttonBottomLeft.setPreferredSize(new Dimension(175,200));
		buttonBottomLeft.setBackground(Color.decode("#F4AC42"));
		r3_elem[2].add(buttonBottomLeft);
		
		
		// Add elements to row 3
		for(JPanel i : r3_elem){
			r3.add(i,FlowLayout.LEFT);
		}
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Left Side - Bottom Row - Row 4
		 * 
		 * Uses whatever space is left generally, could be bigger/smaller if needed
		 * ------------------------------------------------------------------------------
		 */
		
		
		// New panel for row 4
		JPanel r4 = new JPanel(new FlowLayout(0,0,0));
	
		
		// Create / add buttons to row 4 panel
		
		// emergency mode button
		buttonEmergencyMode = new JButton("<html><p style='text-align:center'>EMERGENCY DRIVING"
				+ " ---- OFF</p><html>");
		buttonEmergencyMode.setBackground(Color.decode("#FF3333"));
		buttonEmergencyMode.setPreferredSize(new Dimension(235, 45));
		
		// manual driving button
		buttonManualDriving = new JButton("<html><p style='text-align:center'>MANUAL DRIVING"
				+ " ---- OFF</p><html>");
		buttonManualDriving.setBackground(Color.decode("#FF3333"));
		buttonManualDriving.setPreferredSize(new Dimension(235, 45));
		
		// call dispatch button
		buttonCallDispatch = new JButton("Call Dispatch");
		buttonCallDispatch.setPreferredSize(new Dimension(180, 45));
		
		
		r4.add(buttonEmergencyMode);
		r4.add(buttonCallDispatch);
		r4.add(buttonManualDriving);
		
		/*
		 * ------------------------------------------------------------------------------
		 * Left Side - Bottom Row - Row 5
		 * 
		 * Settings/login row
		 * ------------------------------------------------------------------------------
		 */
		// New panel for row 4
		JPanel r5 = new JPanel(new FlowLayout(0,0,0));
	
		
		// Create / add buttons to row 4 panel
		buttonLogout = new JButton("LOGOUT");
		buttonLogout.setForeground(Color.decode("#FFFFFF"));
		buttonLogout.setBackground(Color.decode("#003366"));
		buttonLogout.setPreferredSize(new Dimension(650, 30));
		r5.add(buttonLogout);
		
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Add each row to the left side panel and return
		 * ------------------------------------------------------------------------------
		 */
		leftSide.add(r4);
		leftSide.add(r1);
		leftSide.add(r2);
		leftSide.add(r3);
		leftSide.add(r5);
		
		
		// return the completed panel
		return leftSide;
		
	}
	
	
	
	/*
	 * All Screens to be shown on the right are added here.
	 * Each one is in a separate java file, if a screen has its own separate screens
	 * then it can have its own cardlayout or tabbed navigation(preferable + easy to code)
	 * @return
	 */
	public JPanel getRightSide(){
		final JPanel rightSide = new JPanel(new CardLayout());
		
		rightSide.setMaximumSize(new Dimension(520,720));
		rightSide.setMinimumSize(new Dimension(520,720));
		
		
		rightSide.add(new RouteManagement(rightSide, topMenu),  "Add Route");
		rightSide.add(new JobManagement(rightSide),  "Job Management");
		
		// add camera feeds (USE THE EXACT IMAGE NAME)
		rightSide.add(new CameraFeed(rightSide, "frontview"),  "Front Camera View");
		rightSide.add(new CameraFeed(rightSide, "rearview"),  "Rear Camera View");
		rightSide.add(new CameraFeed(rightSide, "leftview"),  "Left Camera View");
		rightSide.add(new CameraFeed(rightSide, "rightview"),  "Right Camera View");
		//rightSide.add(new CameraFeed(rightSide, "frontview"),  "Front Camera View");   // GPS??
		
		return rightSide;
	}
	
	/*
	 * Main menu button listeners
	 */
	public void addListeners(){

		
		buttonTopRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout cardLayout = (CardLayout) rightSide.getLayout();
				cardLayout.invalidateLayout(contentPane);
				cardLayout.show(rightSide, "Job Management");	
				setPainted(buttonTopRight);
			}
		});
		
		buttonFrontView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout cardLayout = (CardLayout) rightSide.getLayout();
				cardLayout.invalidateLayout(contentPane);
				buttonFrontView.setBackground(Color.WHITE);
				cardLayout.show(rightSide, "Front Camera View");	
			}
		});
		
		buttonRearView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout cardLayout = (CardLayout) rightSide.getLayout();
				cardLayout.invalidateLayout(contentPane);
				buttonFrontView.setBackground(Color.WHITE);
				cardLayout.show(rightSide, "Rear Camera View");	
			}
		});
		
		buttonLeftView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout cardLayout = (CardLayout) rightSide.getLayout();
				cardLayout.invalidateLayout(contentPane);
				buttonFrontView.setBackground(Color.WHITE);
				
				cardLayout.show(rightSide, "Left Camera View");	
			}
		});
		
		buttonRightView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout cardLayout = (CardLayout) rightSide.getLayout();
				cardLayout.invalidateLayout(contentPane);
				buttonFrontView.setBackground(Color.WHITE);
				cardLayout.show(rightSide, "Right Camera View");	
				setPainted(buttonRightView);
			}
		});
		
		
		
		buttonBottomLeft.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Executing Emergency Stop");
				setPainted(buttonBottomLeft);
			}
		});
		
		
		
		buttonBottomRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Parking Vehicle.");
				setPainted(buttonBottomRight);
			}
		});
		
		
		
		buttonTopLeft.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout cardLayout = (CardLayout) rightSide.getLayout();
				cardLayout.invalidateLayout(contentPane);
				cardLayout.show(rightSide, "Add Route");	
				setPainted(buttonTopLeft);
			}
		});
	
	
		
		
		buttonLogout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setPainted(buttonLogout);
				int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Logout?",  JOptionPane.YES_NO_OPTION);
				if(selection == JOptionPane.YES_OPTION){
					
					
					
					// set default frame back to home screen
					CardLayout cardLayout = (CardLayout) rightSide.getLayout();
					cardLayout.invalidateLayout(contentPane);
					cardLayout.show(rightSide, "Add Route");	
					
					
					CardLayout logout = (CardLayout) contentPane.getLayout();
					logout.invalidateLayout(contentPane);
					logout.show(contentPane, "Login");	
				}
			}
		});
		
		
		
		buttonEmergencyMode.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				toggleEmergencyDriving();
				topMenu.changeEmergencyMode();
				setPainted(buttonEmergencyMode);
			}
		});
		

		buttonManualDriving.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				toggleManualDriving();
				topMenu.changeDrivingMode();
				setPainted(buttonManualDriving);
			}
		});
		
		buttonCallDispatch.addActionListener(new ActionListener(){
			
			// Whether or not the timer should run
			boolean active = true;
			
			// The timer and the task to be done
			java.util.Timer myTimer = null;
			java.util.TimerTask timerTask = null;
			
			public void actionPerformed(ActionEvent e){
				setPainted(buttonCallDispatch);
				
				// random name
				final String names[] = {"Michael", "Sue", "Anthony", "Doug", "Liam", 
						 "Robyn", "Anne", "Sean"};
		    	Random rand = new Random();
		    	int n = rand.nextInt(names.length) + 0;
				final String name = names[n];
				
				// Make a new timer task and time format
				final C c = new C();
				timerTask = new java.util.TimerTask() {
				    @Override
				    public void run() {
				        buttonCallDispatch.setText("<html>" + c.time() + "<br>Talking to - " + name + "<html>");
				        
				    }
				};
				
				// Execute timer
				if(active == true){
					myTimer = new java.util.Timer();
					myTimer.schedule(timerTask, 0, 1* 1000);
					active = false;
				}
				
				// Reset to 'Call Dispatch'
				if(!buttonCallDispatch.getText().equals("Call Dispatch")){
					buttonCallDispatch.setText("Call Dispatch");
					myTimer.cancel();
					timerTask.cancel();
					active = true;
					
				}
				


			}
		});
		

		
	
	}
	
	/**
	 * 
	 */
	public void toggleManualDriving(){
		/*
		String off = "<html><p style='text-align:center'>MANUAL DRIVING<p>"
				+ "<br><p style='text-align:center'>OFF<p><html>"; 
		String on = "<html><p style='text-align:center'>MANUAL DRIVING<p>"
				+ "<br><p style='text-align:center'>ON<p><html>";*/
		
		String off = "<html><p style='text-align:center'>MANUAL DRIVING"
				+ " ---- OFF</p><html>"; 
		String on = "<html><p style='text-align:center'>MANUAL DRIVING"
				+ " ---- ON</p><html>";
		
		
		if(buttonManualDriving.getText().equals(off)){
			buttonManualDriving.setText(on);
			buttonManualDriving.setBackground(Color.decode("#92CD00"));
		}
		else{
			buttonManualDriving.setText(off); 
			buttonManualDriving.setBackground(Color.decode("#FF3333"));
		}
	}
	
	
	/**
	 * 
	 */
	public void toggleEmergencyDriving(){
		String off = "<html><p style='text-align:center'>EMERGENCY DRIVING"
				+ " ---- OFF</p><html>"; 
		String on = "<html><p style='text-align:center'>EMERGENCY DRIVING"
				+ " ---- ON</p><html>";
	
		if(buttonEmergencyMode.getText().equals(off)){
			buttonEmergencyMode.setText(on);
			buttonEmergencyMode.setBackground(Color.decode("#92CD00"));
		}
		else{
			buttonEmergencyMode.setText(off); 
			buttonEmergencyMode.setBackground(Color.decode("#FF3333"));
		}
			
		
	}
	
	
	// Stops ugly borders around the button text from showing - yay
	private void setPainted(JButton b){
		b.setFocusPainted(false);
	}
	
	
	
	
	
	
	
	
}
