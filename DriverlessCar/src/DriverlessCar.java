import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

/**
 * User Interfaces - Checkpoint 5: Implementation
 * 
 * <p>
 * mainWindow.java
 * <p>
 * 
 * mainWindow is the main menu of the driverless car interface. It will link
 * to all other corresponding screens. The screens that should be linked
 * to from the main menu are:
 * <ul>
 *<li>Route Management</li>
 *<li>Job Management</li>
 *<li>Settings</li>
 *<li>Login Screen(after logging out)</li>
 *<li>Supply Management</li>
 *<li>Camera Feeds</li>
 *<li>Manual Controls</li>
 * </ul>
 * <p>
 * 
 * @author Sue Mayer, Michael Bird, Anthony Defazio, Sean Stach
 * @version 1.0
 * @date 12/10/2014
 */
public class DriverlessCar {

	/*
	 * Class member declarations
	 * Include all panel classes here
	*/
	
	// content pane
	private JPanel contentPane;
	
	// login screen
	private LoginScreen loginScreenPanel;
	
	// main menu
	private MainMenu mainMenuPanel;
	
	// menu bar - ie. date, time and a home button
	private MenuBar statusBar;
	
	private void GUIdisplay(){
		
		// This is the window that all of our panes will be stored in
		JFrame frame = new JFrame("TEST MODE: Driverless Ambulance Interface v.1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		    
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
		
		
		
		/* A cardlayout allows as to add 'Cards' to the screen.
		   This is a nifty layout as we can add the main menu/s + login
		   screens and switch between them seemlessly without creating
		   another window*/
		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		contentPane.setLayout(new CardLayout());
		
		
		
		/*
		 * These are the main screens that are used so far.
		 * This does not include screens such as 'Route Management'That are navigated through the main menu. 
		 * For something like that, the screen would have its own subset of screens that it can get to
		 * This gives us versatility by adding a class for each screen.
		 */
		loginScreenPanel = new LoginScreen(contentPane, this);
		mainMenuPanel = new MainMenu(contentPane,this);
		
				
		// add each screen to the contentPane
		contentPane.add(loginScreenPanel,  "Login");
		contentPane.add(mainMenuPanel, "Main Menu");
		
		
		// set up frame layout
		frame.getContentPane().add(contentPane, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setSize(1301,930);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	
	
	
	// main method
	public static void main(String[] args) {	

	SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new DriverlessCar().GUIdisplay();
			}
		});
	}
}

