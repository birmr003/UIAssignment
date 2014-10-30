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
	private JLabel settings = new JLabel("Settings");	
	private JLabel climateLabel;
	private JLabel soundLabel;
	private JLabel radioLabel;
	private JLabel freqLabel;
	private JLabel ventLabel;
	private JLabel cdStatusLabel = new JLabel("Playing Funky Town...");
	private String currentSongStr = "Funky Town";
	private JButton ventButton = new JButton();
	private JButton freqButton = new JButton();
	private JButton radButton = new JButton();
	private JButton cdButton = new JButton();
	private JButton auxButton = new JButton();
	private JTextArea frequency = new JTextArea();
	JPanel musicCards = new JPanel(new CardLayout());;
	JPanel radioCard = new JPanel(new GridLayout(1,3));
	JPanel cdCard = new JPanel(new GridLayout(2,1));
	JPanel auxCard = new JPanel();
	JSlider climateControl = new JSlider(JSlider.HORIZONTAL,
			CLIMATE_MIN, CLIMATE_MAX, CLIMATE_INIT);
	JSlider radVolControl = new JSlider(JSlider.HORIZONTAL,
			RADVOL_MIN, RADVOL_MAX, RADVOL_INIT);
	
	//private boolean isVentOn = false;
	
	public Settings(JPanel content) {
		JPanel theContent = new JPanel(new GridLayout(12,1,0,5));
			
			
			
			//Climate control with slider
			climateLabel = new JLabel("Climate");
			climateLabel.setFont(new Font("Sans Serif", Font.BOLD,30));
			climateControl.setMinorTickSpacing(1);
			
			//Create the label table
			Hashtable labelTable = new Hashtable();
			labelTable.put( new Integer( 0 ), new JLabel("Cold") );
			labelTable.put( new Integer( CLIMATE_MAX ), new JLabel("Hot") );
			climateControl.setLabelTable( labelTable );
			climateControl.setPaintLabels(true);
			
			//Fan
			ventLabel = new JLabel("Ventilation Fan");
			ventLabel.setFont(new Font("Sans Serif", Font.BOLD,30));
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
			soundLabel.setFont(new Font("Sans Serif", Font.BOLD,30));

			radioLabel = new JLabel("Volume");
			radioLabel.setFont(new Font("Sans Serif", Font.BOLD,16));
			frequency.setText("107.10");
			
			musicCards.add(radioCard, "Radio controller");
			musicCards.add(cdCard, "CD controller");
			musicCards.add(auxCard, "AUX controller");
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
			radButton.setBackground(Color.decode("#92CD00"));
			auxButton.setBackground(Color.decode("#FF3333"));
			cdButton.setBackground(Color.decode("#FF3333"));
			freqLabel = new JLabel("Frequency:");
			freqLabel.setFont(new Font("Sans Serif", Font.BOLD,16));
			
			JPanel musicButtons = new JPanel(new GridLayout(1,3));
			radButton.setText("RADIO");
			radButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){				
	
					radButton.setBackground(Color.decode("#92CD00"));
					auxButton.setBackground(Color.decode("#FF3333"));
					cdButton.setBackground(Color.decode("#FF3333"));
				    CardLayout cl = (CardLayout)(musicCards.getLayout());
				    cl.show(musicCards, "Radio controller");
				}
			});
			musicButtons.add(radButton);
			auxButton.setText("AUX");
			auxButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){				
	
					auxButton.setBackground(Color.decode("#92CD00"));
					radButton.setBackground(Color.decode("#FF3333"));
					cdButton.setBackground(Color.decode("#FF3333"));
					
				    CardLayout cl = (CardLayout)(musicCards.getLayout());
				    cl.show(musicCards, "AUX controller");
				}
			});
			musicButtons.add(auxButton);
			cdButton.setText("CD");
			cdButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){				
	
					cdButton.setBackground(Color.decode("#92CD00"));
					auxButton.setBackground(Color.decode("#FF3333"));
					radButton.setBackground(Color.decode("#FF3333"));
				    CardLayout cl = (CardLayout)(musicCards.getLayout());
				    cl.show(musicCards, "CD controller");
				}
			});
			musicButtons.add(cdButton);
			
			//Setting up cards
			radioCard.add(freqLabel);
			radioCard.add(frequency);
			radioCard.add(freqButton);
			
			auxCard.add(new JLabel("AUX Connected..."));
			
			JPanel cdButtons = new JPanel(new GridLayout(1,6));
			
			JButton playBtn = new JButton("Play");
			playBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){				
					cdStatusLabel.setText("Playing " + currentSongStr + "...");
				}
			});
			cdButtons.add(playBtn);
			
			JButton pauseBtn = new JButton("Pause");
			pauseBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){				
					cdStatusLabel.setText(currentSongStr + " Paused");
				}
			});
			cdButtons.add(pauseBtn);
			
			JButton stopBtn = new JButton("Stop");
			stopBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){				
					cdStatusLabel.setText(currentSongStr + " Stopped");
				}
			});
			cdButtons.add(stopBtn);
			
			JButton prevBtn = new JButton("PREV");
			prevBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){				
					if(currentSongStr.equals("Funky Town")){
						currentSongStr = "Bohemian Rhapsody";
					}else{
						currentSongStr = "Funky Town";
					}
					cdStatusLabel.setText("Playing " + currentSongStr + "...");
				}
			});
			cdButtons.add(prevBtn);
			
			JButton nextBtn = new JButton("next");
			nextBtn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){				
					if(currentSongStr.equals("Funky Town")){
						currentSongStr = "Bohemian Rhapsody";
					}else{
						currentSongStr = "Funky Town";
					}
					cdStatusLabel.setText("Playing " + currentSongStr + "...");
				}
			});
			cdButtons.add(nextBtn);
			cdButtons.add(new JButton("Eject"));
			
			cdCard.add(cdButtons);
			cdCard.add(cdStatusLabel);
			
			//Adding content
			settings.setFont(new Font("Sans Serif", Font.BOLD, 30));
			theContent.add(settings);
			theContent.add(climateLabel);
			theContent.add(climateControl);
			theContent.add(ventLabel);
			theContent.add(ventButton);
			theContent.add(soundLabel);
			theContent.add(radioLabel);
			theContent.add(radVolControl);	
			theContent.add(musicButtons);
			theContent.add(musicCards);
			add(theContent);
			
	}
	

}