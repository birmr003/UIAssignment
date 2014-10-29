

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * 
 * @author Michael Bird
 *
 */
public class JobManagement extends JPanel {
	

	private JPanel contentPane;
	private String[] jobs;
	
	// not necessarily needed, but added anyway
	public int jobCount;
	
	/**
	 * Constructor
	 * @param content
	 */
	public JobManagement(JPanel content, MenuBar m) {
		contentPane = content;
		
		//TODO::entire panel design :)
		JPanel content1 = new JPanel(new GridLayout(7,0));
		content1.setMinimumSize(new Dimension(520,720));
		
		
		JLabel title = new JLabel("\nJob Management",SwingConstants.CENTER);
		title.setFont(new Font("Sans Serif", Font.BOLD, 30));
		content1.add(title);
		
		
		String []addresses = {
			"12 Smith Street, Salisbury Downs",
			"8 Elm Street, Marion",
			"23 Meow Road, Modbury",
			"UniSA Mawson Lakes Campus"	
		};
		
		String []reasons = {
			"Attacked by Walrus",
			"Heart Attack",
			"Stroke",
			"Venomous snake bite"
		};
		
		for(int i=0; i<4; i++){
			content1.add(new JLabel("LOCATION: " + addresses[i] + " REASON: " + reasons[i]));
		}
		
		add(content1);
	}
	
}