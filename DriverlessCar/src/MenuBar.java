import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;




public class MenuBar extends JPanel{

	
	private JPanel contentPane;
	public JLabel destinationText;
	public JLabel drivingMode;
	public JLabel emergencyModeStatus ;
	private boolean emergencyStatus = false;
	private String currentDrivingMode = "Automatic";
	
	
	public MenuBar(JPanel panel, DriverlessCar mainLayout){
		contentPane = panel;
		setOpaque(true);
		
		
		JSplitPane menu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		JPanel leftSide = new JPanel(new GridLayout(2,0));
		JPanel rightSide = new JPanel(new GridLayout(1,3));
		
		

		/*
		 *Time Label
		 */
		final JLabel timeLabel = new JLabel();
		Font font = new Font("Arial", Font.BOLD, 40);
		timeLabel.setFont(font);
		final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		ActionListener timerListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				Date date = new Date();
				String time = timeFormat.format(date);
				timeLabel.setText(time);
			}
		};
		Timer timer = new Timer(1000, timerListener);
		timer.setInitialDelay(0);
		timer.start();	
		
		menu.setEnabled(false);
		menu.setPreferredSize(new Dimension(1270,100));
		
		menu.setResizeWeight(0.45);
		rightSide.add(timeLabel);
		ImageIcon wifi = new ImageIcon(MainMenu.class.getResource("Images/wifi.png"));
		ImageIcon fuelGauge = new ImageIcon(MainMenu.class.getResource("Images/gasGauge.png"));
		rightSide.add(new JLabel(wifi));
		rightSide.add(new JLabel(fuelGauge));
		
		// Left Side
		JPanel topLeft = new JPanel(new GridLayout(1,2));
		//topLeft.setMaximumSize(new Dimension(470,100));
		drivingMode = new JLabel();
		emergencyModeStatus = new JLabel();
		changeEmergencyMode();
		changeDrivingMode();
		drivingMode.setHorizontalAlignment(JLabel.CENTER);
		emergencyModeStatus.setHorizontalAlignment(JLabel.CENTER);
		
		topLeft.add(drivingMode);
		topLeft.add(emergencyModeStatus);
		
		
		destinationText = new JLabel("Current Destination: North Terrace, Adelaide, 5000,SA");
		destinationText.setFont(new Font("Arial", Font.BOLD,18));
		destinationText.setForeground(Color.WHITE);
		destinationText.setHorizontalAlignment(JLabel.CENTER);
		leftSide.add(topLeft);
		leftSide.add(destinationText);
		leftSide.setBackground(Color.gray);
		
		leftSide.setMinimumSize(new Dimension(650,100));
		rightSide.setMinimumSize(new Dimension(650,100));
		rightSide.setMaximumSize(new Dimension(650,100));
		leftSide.setMaximumSize(new Dimension(650,100));
		
		
		menu.setLeftComponent(leftSide);
		menu.setRightComponent(rightSide);
		
		
		add(menu);
		
	}
	
	public void setDestinationText(JLabel text){
		this.destinationText.setText("Current Destination: " + text.getText());
	}
	
	public void changeDrivingMode(){
		currentDrivingMode = (currentDrivingMode.equals("Automatic") ? "Manual" : "Automatic");
		this.drivingMode.setText("Driving Mode: " + currentDrivingMode);
	}
	
	public void changeEmergencyMode(){
		emergencyStatus = (emergencyStatus == true ? false : true);
		String mode = (emergencyStatus == true ? "ACTIVE" : "NOT RUNNING");
		this.emergencyModeStatus.setText("Emergency Mode: " + mode);
	}
	
	
	
	

	
	
	
}
