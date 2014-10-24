import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * 
 * @author Michael Bird
 *
 */
public class Settings extends JPanel {
	
	private JPanel contentPane;
	static final int CLIMATE_MIN = 0;
	static final int CLIMATE_MAX = 30;
	static final int CLIMATE_INIT = 15;    //initial
	static final int RADVOL_MIN = 0;
	static final int RADVOL_MAX = 110;
	static final int RADVOL_INIT = 55;    //initial
	private JLabel climateLabel;
	private JLabel soundLabel;
	private JLabel radioLabel;
	private JLabel freqLabel;
	private JLabel ventLabel;
	private JButton ventButton = new JButton();
	private JButton freqButton = new JButton();
	private JTextArea frequency = new JTextArea();
	
	JSlider climateControl = new JSlider(JSlider.HORIZONTAL,
			CLIMATE_MIN, CLIMATE_MAX, CLIMATE_INIT);
	JSlider radVolControl = new JSlider(JSlider.HORIZONTAL,
			RADVOL_MIN, RADVOL_MAX, RADVOL_INIT);
	
	//private boolean isVentOn = false;
	
	public Settings(JPanel content) {
		JPanel theContent = new JPanel(new GridLayout(12,1));
			
			
			
			//Climate control with slider
			climateLabel = new JLabel("Climate");
			climateLabel.setFont(new Font("Serif", Font.BOLD,36));
			climateControl.setMinorTickSpacing(1);
			
			//Create the label table
			Hashtable labelTable = new Hashtable();
			labelTable.put( new Integer( 0 ), new JLabel("Cold") );
			labelTable.put( new Integer( CLIMATE_MAX ), new JLabel("Hot") );
			climateControl.setLabelTable( labelTable );
			climateControl.setPaintLabels(true);
			
			//Fan
			ventLabel = new JLabel("Ventilation Fan");
			ventLabel.setFont(new Font("Serif", Font.BOLD,16));
			ventButton.setText("Off");
			ventButton.setBackground(Color.decode("#FF3333"));
			ventButton.addActionListener(new ActionListener(){
				boolean active = false;
				public void actionPerformed(ActionEvent e){
					
					active = active == true ? false : true;
					
					
					if(active == true){
						ventButton.setText("On");
						ventButton.setBackground(Color.decode("#92CD00"));
					}
					else{
						ventButton.setText("Off");
						ventButton.setBackground(Color.decode("#FF3333"));
					}			
				}
			});
			
			//Sounds controls with slider
			soundLabel = new JLabel("Sound");
			soundLabel.setFont(new Font("Serif", Font.BOLD,36));

			radioLabel = new JLabel("Radio Volume");
			radioLabel.setFont(new Font("Serif", Font.BOLD,16));
			frequency.setText("107.10");
			
			Hashtable volLabelTable = new Hashtable();
			volLabelTable.put( new Integer( 0 ), new JLabel("0") );
			volLabelTable.put( new Integer( 10 ), new JLabel("1") );
			volLabelTable.put( new Integer( 20 ), new JLabel("2") );
			volLabelTable.put( new Integer( 30 ), new JLabel("3") );
			volLabelTable.put( new Integer( 40 ), new JLabel("4") );
			volLabelTable.put( new Integer( 50 ), new JLabel("5") );
			volLabelTable.put( new Integer( 60 ), new JLabel("6") );
			volLabelTable.put( new Integer( 70 ), new JLabel("7") );
			volLabelTable.put( new Integer( 80 ), new JLabel("8") );
			volLabelTable.put( new Integer( 90 ), new JLabel("9") );
			volLabelTable.put( new Integer( 100 ), new JLabel("10") );
			volLabelTable.put( new Integer( 110 ), new JLabel("11") );
			radVolControl.setLabelTable( volLabelTable );
			radVolControl.setPaintLabels(true);
			freqButton.setText("AM");
			freqButton.addActionListener(new ActionListener(){
				boolean active = false;
				public void actionPerformed(ActionEvent e){
					
					active = active == true ? false : true;
					
					
					if(active == true){
						freqButton.setText("FM");
					}
					else{
						freqButton.setText("AM");
					}			
				}
			});
			
			freqLabel = new JLabel("Frequency:");
			freqLabel.setFont(new Font("Serif", Font.BOLD,16));
			
			//Adding content
			theContent.add(new JLabel("Settings"));
			theContent.add(climateLabel);
			theContent.add(climateControl);
			theContent.add(ventLabel);
			theContent.add(ventButton);
			theContent.add(soundLabel);
			theContent.add(radioLabel);
			theContent.add(radVolControl);	
			theContent.add(freqLabel);
			theContent.add(frequency);
			theContent.add(freqButton);
			add(theContent);
			
	}
	

}