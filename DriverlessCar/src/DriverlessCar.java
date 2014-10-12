import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
 * <li>screen 1</li>
 * </ul>
 * <p>
 * 
 * @author Sue Mayer, Michael Bird, Liam Murphy, Anthony Defazio, Sean Stach
 * @version 1.0
 * @date 12/10/2014
 */
public class DriverlessCar {

	
	public static void main(String[] args) {
		// create frame
		LoginScreen login = new LoginScreen();
		
		// validate frame
		login.validate();
		
		// inner class - Window Adaptor
		class adapt extends WindowAdapter{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		}
		
		// Add listener - modified to use inner class
		login.addWindowListener(new adapt());
		
		// Set the frame as visible
		login.setVisible(true);
	}
}
