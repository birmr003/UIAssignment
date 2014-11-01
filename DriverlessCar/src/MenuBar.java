import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Helpers.Time;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;



/**
 * The menu bar is present on all pages except the login screen.
 * <p>
 * It shows the current destination, and other navigation related details on the left side. On the
 * right side, the current time and a few descriptive icons are used to represent things such
 * as the fuel, and current speed of the car.
 * <p>
 * Please note that some of the methods in the menu bar are depreciated due to design changes. Changing
 * emergency mode and manual driving no longer has any place in the menu bar.
 * @author Michael Bird
 *
 */
public class MenuBar extends JPanel{

	
	private JPanel contentPane;
	
	/**
	 * Where the car is currently going
	 */
	public JLabel destinationText;
	
	/**
	 * Whether the car is in auto or manual mode
	 */
	public JLabel drivingMode;
	
	/**
	 * Emergency status TEXT - active or not
	 */
	public JLabel emergencyModeStatus;
	
	
	/**
	 * Emeregency status boolean - true or false. Can be changed.
	 */
	private boolean emergencyStatus = false;

	/**
	 * Current driving mode string
	 */
	private String currentDrivingMode = "Automatic";
	
	
	private JLabel timeText;
	
	private java.util.Timer myTimer;
	private java.util.TimerTask timerTask;
	
	
	
	
	
	/**
	 * The menu bar is displayed on the main menu screen
	 * @param panel
	 * @param mainLayout
	 */
	public MenuBar(JPanel panel, DriverlessCar mainLayout){
		contentPane = panel;
		setOpaque(true);
		
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * JSplitPane menu - Left and Right Side Declaration
		 * ------------------------------------------------------------------------------
		 */
		
		JSplitPane menu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		// Left side stores the destination text and emergency/driving status
		JPanel leftSide = new JPanel(new GridLayout(2,0));
		leftSide.setBackground(Color.decode("#393939"));
		leftSide.setMinimumSize(new Dimension(650,100));
		leftSide.setMaximumSize(new Dimension(650,100));
		
		// Right stores image icons and the current time
		JPanel rightSide = new JPanel(new GridLayout(1,4));
		
		menu.setEnabled(false);
		menu.setPreferredSize(new Dimension(1270,100));
		menu.setResizeWeight(0.4);
		
		
		
		
		

		/*
		 * ------------------------------------------------------------------------------
		 * Right Side
		 * ------------------------------------------------------------------------------
		 */
		
		// time label (Automatically updates)
		final JLabel time = new JLabel();
		Font font = new Font("Sans Serif", Font.BOLD, 40);
		time.setFont(font);
		final DateFormat timeFormat = new SimpleDateFormat("HH:mm");
		ActionListener timerListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				Date date = new Date();
				String timeText = timeFormat.format(date);
				time.setText(timeText);
			}
		};
		Timer timer = new Timer(1000, timerListener);
		timer.setInitialDelay(0);
		timer.start();	
		

		// Create image icons
		ImageIcon wifi = new ImageIcon(MainMenu.class.getResource("Images/wifi.png"));
		ImageIcon speed = new ImageIcon(MainMenu.class.getResource("Images/speed.png"));
		ImageIcon fuelGauge = new ImageIcon(MainMenu.class.getResource("Images/gasGauge.png"));
		
		
		
		// Add components to the right side
		rightSide.add(time);
		rightSide.add(new JLabel(wifi));
		rightSide.add(new JLabel(speed));
		rightSide.add(new JLabel(fuelGauge));
		
		
		
		
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Left Side
		 * ------------------------------------------------------------------------------
		 */		
		
		
		
		JPanel topLeft = new JPanel(new GridLayout(1,2));
		
		
		// Create text labels
		drivingMode = new JLabel("Driving Mode: Automatic",JLabel.CENTER);
		drivingMode.setForeground(Color.WHITE);
		
		emergencyModeStatus = new JLabel("Emergency Mode: NOT RUNNING", JLabel.CENTER);
		emergencyModeStatus.setForeground(Color.WHITE);
		
		// end top
		
		
		// Set destination text default and font
		destinationText = new JLabel("Current Destination: 1 North Terrace, Adelaide, 5000, SA", JLabel.CENTER);
		destinationText.setFont(new Font("Sans Serif Pro", Font.BOLD,16));
		destinationText.setForeground(Color.WHITE);
		
		
		topLeft.setBackground(Color.decode("#FF5A09"));
		
		
		timeText = new JLabel("", JLabel.CENTER);
		
		JLabel currentSuburb = new JLabel("Current Suburb: Adelaide", JLabel.CENTER);
		
		final Time c = new Time();
		timerTask = new java.util.TimerTask() {
		    @Override
		    public void run() {
		        timeText.setText("<html> <p style='text-align:center'>Duration Driving: " + c.time() + "</p><html>");
		    }
		};
		
		myTimer = new java.util.Timer();
		myTimer.schedule(timerTask, 0, 1* 1000);
		
		topLeft.add(currentSuburb , BorderLayout.CENTER);
		topLeft.add(timeText, BorderLayout.CENTER);
		
		
		
		
		
		
		// Add components to the left side
		leftSide.add(topLeft);
		leftSide.add(destinationText);
		
		
		// Set the left and right JSplitPane panes
		menu.setLeftComponent(leftSide);
		menu.setRightComponent(rightSide);
		
		
		// Add JSplitPane to menu
		add(menu);
		
	}
	

	public void setElapsedTime(){
		
	}
	
	/**
	 * Sets the current destination
	 * @param text The destination to travel to
	 */
	public void setDestinationText(String text){
		this.destinationText.setText("Current Destination: " + text);
	}
	
	
	/**
	 * Switches the driving mode from auto to manual and vise versa.
	 */
	public void changeDrivingMode(){
		currentDrivingMode = (currentDrivingMode.equals("Automatic") ? "Manual" : "Automatic");
		this.drivingMode.setText("Driving Mode: " + currentDrivingMode);
	}
	
	
	/**
	 * Toggles emergency mode on and off
	 */
	public void changeEmergencyMode(){
		emergencyStatus = (emergencyStatus == true ? false : true);
		String mode = (emergencyStatus == true ? "ACTIVE" : "NOT RUNNING");
		this.emergencyModeStatus.setText("Emergency Mode: " + mode);
	}
	

	
}
