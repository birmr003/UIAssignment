

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
	private JTextArea currentJobAddress;
	private JTextArea currentJobDescription;
	private String currentJobStr;
	private JButton buttonCancel;
	private JTable jobTable;
	private int width = 430;
	final private String [][]data = {
			{"12 Smith Street, Salisbury, SA, 5000","Bear Attack"},
			{"8 Elm Street, Marion, SA, 5000","Heart Attack"},
			{"23 Meow Road, Modbury, SA, 5000","Stroke"},
			{"UniSA Mawson Lakes Campus, SA, 5000","Venomous snake bite"}	
	};
	
	

	
	/**
	 * Constructor
	 * @param content
	 */
	public JobManagement(JPanel content, final MenuBar m) {
		contentPane = content;
		
		// layout manager
		JPanel content1 = new JPanel(new FlowLayout());
		content1.setPreferredSize(new Dimension(width,700));
		
		// space objects just in case
		JPanel space[] ={
				new JPanel(),
				new JPanel(),
				new JPanel(),
				new JPanel()
		};
		
		for(JPanel i : space){
			i.setPreferredSize(new Dimension(width,16));
		}
		
		
		// main title
		JLabel title = new JLabel("Job Management",SwingConstants.CENTER);
		title.setFont(new Font("Sans Serif", Font.BOLD, 30));
		
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Current Job  - label + cancel button
		 * ------------------------------------------------------------------------------
		 */
		
		
		currentJobLabel = new JLabel("Current Job", SwingConstants.LEFT);
		currentJobLabel.setPreferredSize(new Dimension(width,40));
		currentJobLabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
		
		currentJobAddress = new JTextArea();
		currentJobAddress.setPreferredSize(new Dimension(width,40));
		currentJobAddress.setFont(new Font("Sans Serif", Font.BOLD, 20));
		currentJobAddress.setForeground(Color.BLUE);
		currentJobAddress.setEditable(false);
		
		currentJobDescription = new JTextArea();
		currentJobDescription.setPreferredSize(new Dimension(width,40));
		currentJobDescription.setFont(new Font("Sans Serif", Font.BOLD, 20));
		currentJobDescription.setForeground(Color.BLUE);
		currentJobDescription.setEditable(false);
		
		
		
		buttonCancel = new JButton("Cancel Job");
		buttonCancel.setForeground(Color.decode("#FFFFFF"));
		buttonCancel.setBackground(Color.decode("#393939"));
		buttonCancel.setPreferredSize(new Dimension(width,50));
		
		
		/*
		 * ------------------------------------------------------------------------------
		 * Jobs - ie. a table
		 * ------------------------------------------------------------------------------
		 */
		
		JLabel titleAvailableJobs = new JLabel("Available Jobs", SwingConstants.LEFT);
		titleAvailableJobs.setPreferredSize(new Dimension(width,40));
		titleAvailableJobs.setFont(new Font("Sans Serif", Font.BOLD, 30));
		
		
		
		JTextPane jobTextBox[] = {
				new JTextPane(),
				new JTextPane(),
				new JTextPane(),
				new JTextPane()
		};
		
		
		JPanel jobRow[] = {
				new JPanel(new BorderLayout()),
				new JPanel(new BorderLayout()),
				new JPanel(new BorderLayout()),
				new JPanel(new BorderLayout())
		};
		

		for(int i=0; i< jobRow.length; i++){
			final int j = i;
			jobRow[i].setPreferredSize(new Dimension(width, 40));
			jobTextBox[i].setContentType("text/html");
			jobTextBox[i].setEditable(false);
			jobTextBox[i].setPreferredSize(new Dimension(width-110,40));
			jobRow[i].add(jobTextBox[i],BorderLayout.WEST);
			
			
			
			jobTextBox[i].setText("<html><b>Address:</b> " +data[i][0] + "<br>" +
								"<b>Description:</b> " + data[i][1] + "<html>");
			
			final JButton b = new JButton("Accept Job");
			
			
			b.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					b.setFocusPainted(false);
					setCurrentJob(data[j][0], data[j][1]);
					m.setDestinationText(data[j][0]);
				}
			});	
			
			b.setMinimumSize(new Dimension(60,40));
			b.setMaximumSize(new Dimension(60,40));
			b.setForeground(Color.decode("#FFFFFF"));
			b.setBackground(Color.decode("#393939"));
			jobRow[i].add(b, BorderLayout.EAST);
		}
		
		
		
		// add to content pane
		content1.add(currentJobLabel);
		content1.add(currentJobAddress);
		content1.add(currentJobDescription);
		content1.add(space[2]);
		content1.add(buttonCancel);
		content1.add(space[0]);
		content1.add(titleAvailableJobs);
		for(JPanel i : jobRow){
			JPanel j = new JPanel();
			j.setPreferredSize(new Dimension(width,16));
			content1.add(i);
			content1.add(j);
		}
	
		

		
		// add to layout
		add(title);
		add(space[1]);
		add(content1);
		
		buttonListeners();
	}
	
	
	private void buttonListeners(){
		buttonCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				buttonCancel.setFocusPainted(false);
				setCurrentJob("---- No Current Job ----","");
			}
		});		
	}
	
	public void setCurrentJob(){
		currentJobAddress.setText(currentJobStr);
	}
	
	public void setCurrentJob(String address, String reason){
		currentJobAddress.setText(address);;
		currentJobDescription.setText(reason);;
	}
	
	
}