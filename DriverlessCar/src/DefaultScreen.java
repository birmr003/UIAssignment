import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class DefaultScreen extends JPanel {
	
	
	public DefaultScreen(JPanel content){
		JPanel blankscreen = new JPanel();
		
		JLabel title = new JLabel("Welcome", SwingConstants.CENTER);
		title.setFont(new Font("Sans Serif", Font.BOLD, 50));
		
		blankscreen.add(content, "Main Menu");
		blankscreen.add(title);
		
		add(title);
	}

}
