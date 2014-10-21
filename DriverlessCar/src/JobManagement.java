
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * 
 * @author 
 *
 */
public class JobManagement extends JPanel {
	

	private JPanel contentPane;
	
	// not necessarily needed, but added anyway
	public int jobCount;
	
	/**
	 * Constructor
	 * @param content
	 */
	public JobManagement(JPanel content) {
		contentPane = content;
		
		//TODO::entire panel design :)
		
		
		add(new JLabel("Job Management"));
		
		
	}
	
}