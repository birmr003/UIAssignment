import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;



/**
 * Class to control user login.
 * A window launches with two panels for the user to enter their ID and password.
 * A virtual keyboard is in the panel and the user clicks 'test' and clicks the "ENTER" key.
 * When the user clicks "ENTER" the password field automatically fills and the cursor focuses at the end of the stream.
 * When the 'LOGIN" is clicked or the user pushes "ENTER" the supplied credentials are checked for valid.
 * If the user exists, the program moves to the main system screen.
 * If the check fails, a dialog box informs the user of the problem and offers to try again.
 * 
 * @author Michael Bird & Susan Mayer
 * Created 23rd. October 2014
 * Version 1.0
 *
 */
@SuppressWarnings("serial")
public class LoginScreen extends JPanel {

	
	private JPanel contentPane;
	
	private JButton submitButton;
	
	private JLabel userLabel;
	
	private JLabel passwordLabel;
	
	private JTextField userField;
	
	private JPasswordField passwordField;
	
	//Setting up the virtual keyboard containers
	private JButton enter;	
	private JPanel keyboard;
	private String keystrokes = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	
	
	
	/**
	 * 
	 */
	public LoginScreen(JPanel panel, DriverlessCar mainLayout) {
		
		//set content pane details
		contentPane = panel;
		setOpaque(true);
		setBackground(Color.gray.brighter());
		submitButton = new JButton("Log in");
		submitButton.setFont(new Font("Sans Serif", Font.BOLD, 30));
		
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Create Login Form
		 * ------------------------------------------------------------------------------
		 */
		JPanel loginForm = new JPanel(new GridLayout(7,1,0,15));
		loginForm.setPreferredSize(new Dimension(600,700));
		loginForm.setBackground(Color.gray.brighter());
		
		
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Create username and password fields
		 * ------------------------------------------------------------------------------
		 */
		
		// initialize Labels + Text Fields
		userLabel = new JLabel("User ID");
		userField = new JTextField();
		passwordLabel = new JLabel("Password");
		passwordField = new JPasswordField();
		
		// Fonts/Text Color
		userLabel.setFont(new Font("Sans Serif", Font.BOLD,48));
		userField.setFont(new Font("Sans Serif",Font.PLAIN, 48));
		userField.setForeground(Color.BLUE);
		
		passwordLabel.setFont(new Font("Sans Serif", Font.BOLD,48));
		passwordField.setFont(new Font("Sans Serif",Font.PLAIN, 48));
		passwordField.setForeground(Color.BLUE);
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			char pw[] = {'t', 'e', 's', 't'};
			
			char userEnter[] = passwordField.getPassword();
			
			//Test for valid password
			if(Arrays.equals(userEnter, pw) ){
				//Clear both arrays on valid check!!
				Arrays.fill(pw, (char) 0);
				Arrays.fill(userEnter, (char) 0);
				//Load main program screen 
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
				cardLayout.invalidateLayout(contentPane);
				cardLayout.show(contentPane, "Main Menu");
			}
				
			else{
				JOptionPane.showMessageDialog(null, 
						"Please enter in your correct User ID and Password.",
						"Wrong Credentials",
						JOptionPane.ERROR_MESSAGE);
			}
				
					
			}
		});

		
		/*
		 * ------------------------------------------------------------------------------
		 * Message Prompt (ie. enter in your details) At top of screen
		 * ------------------------------------------------------------------------------
		 */
		JPanel title = new JPanel(new GridLayout(2,0));
		title.setBackground(Color.gray.brighter());
		JLabel t2 = new JLabel("(TEST DEPLOYMENT: Username=test, Password=test)", JLabel.CENTER);
		t2.setFont(new Font("Sans Serif",Font.BOLD, 14));
		title.add(new JLabel("Please enter your credentials.", JLabel.CENTER));
		title.add(t2);
		
		
		keyboard = new JPanel(new GridLayout(4,0));
		final JButton tab = new JButton("TAB");
		keyboard.add(tab);
		enter = new JButton("ENTER");
		enter.setActionCommand("Enter");
		
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				passwordField.setText("test");
				//Set the keyboard response focus in the password field
				passwordField.requestFocusInWindow(); 
				
				//Create a new robot to type enter automatically for test purposes
				try {
		            
		            Robot robot = new Robot();
		            robot.delay(4000);
		            robot.keyPress(KeyEvent.VK_ENTER);
		            
		            
		        } catch (AWTException a) {
		            a.printStackTrace();
		        }


								
			}});
		
		for(int i = 0; i <= 25; i++){
			final String temp = "" + keystrokes.charAt(i);
			JButton btn = new JButton(temp);
			
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(e.getSource()!= enter){
				   	    String actionCommand = e.getActionCommand().toLowerCase();
					    userField.setText(userField.getText() + actionCommand);
					}
									
			   }		
				
			});
			
			keyboard.add(btn);
			keyboard.add(enter);
		}
        
	
		/*
		 * ------------------------------------------------------------------------------
		 * Add Components to Layout
		 * ------------------------------------------------------------------------------
		 */
		loginForm.add(title);
		loginForm.add(userLabel);
		loginForm.add(userField);
		loginForm.add(passwordLabel);
		loginForm.add(passwordField);
		loginForm.add(submitButton);
		loginForm.add(keyboard);
		
		
		
		
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Button Listeners (Submit Button)
		 * ------------------------------------------------------------------------------
		 */

		
		// Will Present the user with a message if username && password != "test"
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				char pw[] = {'t', 'e', 's', 't'};
				
				char userEnter[] = passwordField.getPassword();
				
				//Test for valid password
				if(Arrays.equals(userEnter, pw) ){
					//Clear both arrays on valid check!!
					Arrays.fill(pw, (char) 0);
					Arrays.fill(userEnter, (char) 0);
					//Load main program screen
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
					cardLayout.invalidateLayout(contentPane);
					cardLayout.show(contentPane, "Main Menu");
				}
					
				else{
					JOptionPane.showMessageDialog(null, 
							"Please enter in your correct User ID and Password.",
							"Wrong Credentials",
							JOptionPane.ERROR_MESSAGE);
				}
			}
	});
				
				
		// Add form to layout
		add(loginForm);
		
	}
	
	

}
