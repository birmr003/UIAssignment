
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class JobManagement extends JPanel {

	private JPanel contentPane;
	public int jobCount;
	
	public JobManagement(JPanel content) {
		contentPane = content;
		add(new JLabel("Job Management"));
		
		
		System.out.println(getParent());
		
	}
	
}