import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * 
 * @author Michael Bird
 *
 */
public class ManualDrivingControls extends JPanel {
	private JPanel contentPane;
	private JLabel title;
	private int width = 430;
	private JTextArea touchPanel;
	private JButton toggleHelmet;
	private String[] status = {"... Helmet Attached", "... Helmet Disconnected"};
	
	public ManualDrivingControls(JPanel content) {
		
		JPanel content1 = new JPanel(new FlowLayout());
		content1.setPreferredSize(new Dimension(width,700));
		
		
		title = new JLabel("Manual Driving Controls", SwingConstants.CENTER);
		title.setFont(new Font("Sans Serif", Font.BOLD, 30));
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Manual Controls content
		 * ------------------------------------------------------------------------------
		 */
		
		// help text prompts
		JLabel prompt = new JLabel("Please attach your navigational helmet");
		JLabel prompt2 = new JLabel("Touch screen functionality will only be present with an attached helmet");

		
		// generic space
		JPanel space = new JPanel();
		space.setPreferredSize(new Dimension(width,30));
		
		// simple touch pad (textbox)
		touchPanel = new JTextArea();
		touchPanel.setBackground(Color.GRAY);
		touchPanel.setPreferredSize(new Dimension(width,400));
		touchPanel.setEditable(false);
		
		
		// current helmet status
		toggleHelmet = new JButton(" ");
		toggleHelmet.setPreferredSize(new Dimension(width,40));
		toggleHelmetStatus();
		toggleHelmet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				toggleHelmet.setFocusPainted(false);
				toggleHelmetStatus();
			}
		});		
		
		
		
		
		
		
		
		// add content ie. manual controls
		content1.add(prompt);
		content1.add(prompt2);
		content1.add(space);
		content1.add(touchPanel);
		content1.add(toggleHelmet);
		
		
		
		
		
		add(title);
		add(content1);
	}
	
	
	private void toggleHelmetStatus(){
		
		if(toggleHelmet.getText().equals(status[0])){
			toggleHelmet.setText(status[1]);
			toggleHelmet.setBackground(Color.decode("#FF3333"));
			touchPanel.setVisible(false);
		}
		else{
			toggleHelmet.setText(status[0]);
			toggleHelmet.setBackground(Color.decode("#92CD00"));
			touchPanel.setVisible(true);
		}
		
		
	}
	
	

}