import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



/**
 * 
 * @author Michael Bird
 *
 */
public class LoginScreen extends JPanel {

	
	private JPanel contentPane;
	
	private JButton submitButton;
	
	private JLabel userLabel;
	
	private JLabel passwordLabel;
	
	private JTextField userField;
	
	private JPasswordField passwordField;
	
	
	/**
	 * 
	 */
	public LoginScreen(JPanel panel, DriverlessCar mainLayout) {
		
		//set content pane details
		contentPane = panel;
		setOpaque(true);
		setBackground(Color.gray.brighter());
		submitButton = new JButton("Log in");
		
		
		
		
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
		
		
		
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Button Listeners (Submit Button)
		 * ------------------------------------------------------------------------------
		 */

		
		// Will Present the user with a message if username && password != "test"
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!(userField.getText().equals("test") && passwordField.getText().equals("test"))){
					JOptionPane.showMessageDialog(null, 
							"Please enter in your correct User ID and Password.",
							"Wrong Credentials",
							JOptionPane.ERROR_MESSAGE
							);
				}
				else{
					userField.setText("");
					passwordField.setText("");
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
					cardLayout.invalidateLayout(contentPane);
					cardLayout.show(contentPane, "Main Menu");	
				}
							
			}
		});
		
		
		// Add form to layout
		add(loginForm);
		
	}
	

	
	

}
