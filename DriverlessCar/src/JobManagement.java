

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
	private JLabel currentJobLabel = new JLabel();
	private JTextArea currentJob;
	private JButton buttonCancel;
	private int width = 430;
	
	// not necessarily needed, but added anyway
	public int jobCount;
	
	/**
	 * Constructor
	 * @param content
	 */
	public JobManagement(JPanel content, MenuBar m) {
		contentPane = content;
		
		
		JPanel content1 = new JPanel(new FlowLayout());
		content1.setPreferredSize(new Dimension(width,700));
		
		JPanel space[] ={
				new JPanel(),
				new JPanel(),
				new JPanel(),
				new JPanel()
		};
		
		for(JPanel i : space){
			i.setPreferredSize(new Dimension(width,16));
		}
		
		
		JLabel title = new JLabel("Job Management",SwingConstants.CENTER);
		
		title.setFont(new Font("Sans Serif", Font.BOLD, 30));
		content1.add(title);
		
		content1.add(space[0]);
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Current Job  - label + cancel button
		 * ------------------------------------------------------------------------------
		 */
		
		
		currentJobLabel = new JLabel("Current Job", JLabel.LEFT);
		currentJobLabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
		content1.add(currentJobLabel);
		currentJob = new JTextArea();
		currentJob.setPreferredSize(new Dimension(width,50));
		currentJob.setEditable(false);
		
		buttonCancel = new JButton("Cancel Job");
		buttonCancel.setPreferredSize(new Dimension(width,50));
		
		content1.add(currentJob);
		content1.add(buttonCancel);
		
		/*
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
		}*/
		
		add(content1);
		buttonListeners();
	}
	
	
	public void buttonListeners(){
		buttonCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				buttonCancel.setFocusPainted(false);
				currentJob.setText("asdasdasdasd");
			}
		});		
		
	
		
		
	}
	
	
}