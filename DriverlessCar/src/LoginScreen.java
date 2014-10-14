import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



/**
 * 
 * @author 
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
		
		
		
		
		// login form
		JPanel loginForm = new JPanel(new GridLayout(6,1,0,15));
		loginForm.setPreferredSize(new Dimension(600,700));
		loginForm.setBackground(Color.gray.brighter());
		
		
		
		
		// create username/password fields
		userField = new JTextField();
		userField.setFont(new Font("Arial",Font.PLAIN, 48));
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial",Font.PLAIN, 48));
		
		
		
		
		// set username/password label text
		userLabel = new JLabel("User ID");
		userLabel.setFont(new Font("Arial", Font.BOLD,48));
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Arial", Font.BOLD,48));

		
		
		
		
		// title details (ie. please enter in details)   ## NOT YET FULLY FUNCTIONAL
		JPanel title = new JPanel(new BorderLayout());
		title.setBackground(Color.gray.brighter());
		JLabel t1 = new JLabel("Please enter your credentials");
		JLabel t2 = new JLabel("(TEST DEPLOYMENT: Username=test, Password=test)");
		t2.setHorizontalAlignment(JLabel.CENTER);
		t2.setVerticalAlignment(JLabel.CENTER);
		
		//title.add(t1);
		title.add(t2, BorderLayout.CENTER);
		
		// Add components to login grid form
		loginForm.add(title);
		loginForm.add(userLabel);
		loginForm.add(userField);
		loginForm.add(passwordLabel);
		loginForm.add(passwordField);
		loginForm.add(submitButton);

		// Log in button event listener
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!(userField.getText().equals("test") || passwordField.equals("test"))){
					JOptionPane.showMessageDialog(null, 
							"Please enter in your correct User ID and Password."
							);
				}
				else{
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
					cardLayout.invalidateLayout(contentPane);
					cardLayout.show(contentPane, "Main Menu");	
				}
							
			}
		});
		add(loginForm);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return (new Dimension(900,900));
	}
	
	

}
