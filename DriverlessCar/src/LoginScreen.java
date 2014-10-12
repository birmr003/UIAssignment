import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class LoginScreen extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public LoginScreen() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set size and title
		setSize(1200,900);
		this.setTitle("Driverless Car Login Screen");
		
		//set content pane details
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	
	
	

}
