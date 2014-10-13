import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;




/**
 * 
 * @author 
 *
 */
public class MainMenu extends JPanel {
	
	private JPanel contentPane;
	
	// menu items
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	
	
	
	public MainMenu(JPanel panel, DriverlessCar mainLayout){
		contentPane = panel;
		setOpaque(true);
		setBackground(Color.gray.brighter());
		add(new JLabel("Main Menu Label"));
	}
	
	
}
