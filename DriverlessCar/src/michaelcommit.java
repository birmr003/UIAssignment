import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class michaelcommit extends JPanel {

	private JPanel contentPane;
	
	public michaelcommit (JPanel content) {
		JPanel p = new JPanel(new GridLayout(2,1));
		p.setBackground(Color.RED.LIGHT_GRAY);
		p.setPreferredSize(new Dimension(590,700));
		//setPreferredSize(content.getPreferredSize());
		p.add(new JLabel("Please add a new route here"));
		add(p);
	}
	
}
