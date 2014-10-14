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
		
		JSplitPane j = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		j.setPreferredSize(new Dimension(1290,890));
		//JPanel grid = new JPanel(new GridLayout(1,2));
		//grid.setPreferredSize(new Dimension(600,700));
		

		JPanel g = new JPanel();
		JPanel g2 = new JPanel();
		
		g.setBackground(Color.gray.darker());
		
		j.setLeftComponent(g);
		j.setRightComponent(g2);
		//j.setDividerSize(0);
		j.setResizeWeight(0.45);
		j.setDividerLocation(0.45);
		j.setEnabled(false);


		
		add(j);

		
		
		
		
	}
	
	
}
