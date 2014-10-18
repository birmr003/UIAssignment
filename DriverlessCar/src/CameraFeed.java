import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * Instead of making a screen for each camera feed, this screen displays the camera feed as specified
 * in the constructor. Four instances are needed for four camera feeds for example.
 * 
 * @author Michael Bird
 *
 */
public class CameraFeed extends JPanel {

	private JPanel contentPane;
	
	// All of the viable camera feeds we could show
	private String screens[] = {
			"frontview",
			"rearview",
			"leftview",
			"rightview",
			"gps"
	};
	

	/**
	 * Constructor
	 * @param content
	 */
	public CameraFeed (JPanel content, String view) {

		String url = "";
		boolean contains = false;
		
		for(String i : screens){
			if(i.equals(view)){
				url += "Images/" + view + ".jpg";
				contains = true;
			}
		}
		
		if(contains == true){
			ImageIcon viewImage = new ImageIcon(CameraFeed.class.getResource(url));
			
			
			// TODO::set the size of the image to a reasonable size. Not necessarily the size of the panel
			// because different of aspect ratios etc. 
			
			
			add(new JLabel(viewImage));
		}
		else{
			add(new JLabel("Invalid Image, Please add image to the Camera Feed class"));
		}

		
	}
	
	
	
}
