import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;




public class MenuBar extends JPanel{

	
	private JPanel contentPane;
	
	
	public MenuBar(JPanel panel, DriverlessCar mainLayout){
		contentPane = panel;
		setOpaque(true);
		
		JSplitPane menu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		JPanel leftSide = new JPanel(new GridLayout(1,2));
		JPanel rightSide = new JPanel(new GridLayout(1,2));
		
		

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
		menu.setPreferredSize(new Dimension(1290,100));
		menu.setResizeWeight(0.67);
		rightSide.add(timeLabel);
		rightSide.add(new JLabel("CURRENT FUEL ICON HERE THANK YOU ^_^ "));
		leftSide.add(new JLabel("Current Destination: 22 Jump Street, FAKE SUBURB, 1234"));
		menu.setLeftComponent(leftSide);
		menu.setRightComponent(rightSide);
		
		
		// add components to menu
		add(menu);
		
		
		
		
		
		
		
		
	}
	
	
	
	

	
	
	
}
