
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * Instead of making a screen for each camera feed, this screen displays the camera feed as specified
 * in the constructor. Four instances are needed for four camera feeds for example. This is pretty much 
 * hard coded in for more asthetic reasons.
 * 
 * @author Michael Bird
 *
 */
public class CameraFeed extends JPanel {

	private JPanel contentPane;
	
	// All of the viable camera feeds we could show
	final private String screens[] = {
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
		String text = "";
		JLabel viewText = new JLabel();
		viewText.setFont(new Font("Sans Serif", Font.BOLD, 30));
		
		
		for(String i : screens){
			if(i.equals(view)){

				url += "Images/" + view + "_large.jpg";
				contains = true;
				
				if(i == screens[0]){
					text = "Front Camera View";
				}
				if(i == screens[1]){
					text = "Rear Camera View";
				}
				if(i == screens[2]){
					text = "Left Camera View";
				}
				if(i == screens[3]){
					text = "Right Camera View";
				}
			}
		}
		
		viewText.setText("Viewing: " + text);
		
		if(contains == true){
			
			ImageIcon viewImage = new ImageIcon(CameraFeed.class.getResource(url));
	 
			JLabel l = new JLabel(viewImage);
			
			add(viewText);
			add(l);
		}
		else{
			add(new JLabel("Invalid Image, Please add image to the Camera Feed class"));
		}

		
	}
	
	
	
}
