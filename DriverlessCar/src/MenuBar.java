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
		JPanel rightSide = new JPanel(new GridLayout(1,4));
		
		

		/*
		 *Time Label
		 */
		final JLabel time = new JLabel();
		Font font = new Font("Arial", Font.BOLD, 40);
		time.setFont(font);
		final DateFormat timeFormat = new SimpleDateFormat("HH:mm");
		ActionListener timerListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				Date date = new Date();
				String timeText = timeFormat.format(date);
				time.setText(timeText);
			}
		};
		Timer timer = new Timer(1000, timerListener);
		timer.setInitialDelay(0);
		timer.start();	
		
		menu.setEnabled(false);
		menu.setPreferredSize(new Dimension(1270,100));
		
		menu.setResizeWeight(0.4);
		rightSide.add(time);
		ImageIcon wifi = new ImageIcon(MainMenu.class.getResource("Images/wifi.png"));
		ImageIcon speed = new ImageIcon(MainMenu.class.getResource("Images/speed.png"));
		ImageIcon fuelGauge = new ImageIcon(MainMenu.class.getResource("Images/gasGauge.png"));
		rightSide.add(new JLabel(wifi));
		rightSide.add(new JLabel(speed));
		rightSide.add(new JLabel(fuelGauge));
		
		// Left Side
		JPanel topLeft = new JPanel(new GridLayout(1,2));
		drivingMode = new JLabel();
		emergencyModeStatus = new JLabel();
		changeEmergencyMode();
		changeDrivingMode();
		drivingMode.setHorizontalAlignment(JLabel.CENTER);
		drivingMode.setForeground(Color.WHITE);
		emergencyModeStatus.setHorizontalAlignment(JLabel.CENTER);
		emergencyModeStatus.setForeground(Color.WHITE);
		
		topLeft.add(drivingMode);
		topLeft.add(emergencyModeStatus);
		
		leftSide.setMinimumSize(new Dimension(650,100));
		leftSide.setMaximumSize(new Dimension(650,100));
		//rightSide.setMaximumSize(new Dimension(620,100));
		
		destinationText = new JLabel("Current Destination: North Terrace, Adelaide, 5000,SdA");
		destinationText.setFont(new Font("Arial", Font.BOLD,18));
		destinationText.setForeground(Color.WHITE);
		destinationText.setHorizontalAlignment(JLabel.CENTER);
		leftSide.add(topLeft);
		leftSide.add(destinationText);
		leftSide.setBackground(Color.decode("#393939"));
		
		topLeft.setBackground(Color.decode("#FF5A09"));
		
		

		
		menu.setLeftComponent(leftSide);
		menu.setRightComponent(rightSide);
		
		
		add(menu);
		
	}
	
	public void setDestinationText(String text){
		this.destinationText.setText("Current Destination: " + text);
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
