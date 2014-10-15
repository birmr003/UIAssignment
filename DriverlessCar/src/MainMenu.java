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
	
	private MenuBar topMenu;
	private JPanel contentPane;
	private JPanel rightSide;
	private JButton buttonTopLeft;
	
	
	public MainMenu(JPanel panel, DriverlessCar mainLayout){
		contentPane = panel;
		setOpaque(true);
		setBackground(Color.gray.brighter());
		//setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		JSplitPane j = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		j.setPreferredSize(new Dimension(1270,730));

		
		JPanel leftSide = getLeftSide();
		
		rightSide = new JPanel(new CardLayout());
		rightSide = getRightSide();
		//rightSide.setPreferredSize(new Dimension(580,750));
		

		
		j.setLeftComponent(leftSide);
		j.setRightComponent(rightSide);

		j.setEnabled(false);

		
		topMenu = new MenuBar(contentPane,mainLayout);
		
		add(topMenu,BorderLayout.PAGE_START);
		add(j);
	}
	
	
	
	private JPanel getLeftSide(){
		
		// left side
		JPanel leftSide = new JPanel(new FlowLayout(0,0,0));
				
		leftSide.setMaximumSize(new Dimension(650,720));
		leftSide.setMinimumSize(new Dimension(650,720));
				

		/*
		 * Left Side - Row 2
		 */
		JPanel leftSide_r1 = new JPanel(new FlowLayout(0,0,0));
		JPanel leftSide_r1_elem[] = {
				new JPanel(new FlowLayout(0,0,0)),
				new JPanel(new FlowLayout(0,0,0)),
				new JPanel(new FlowLayout(0,0,0))
		};
				
		
		// Left Side r1
		leftSide_r1_elem[0].setPreferredSize(new Dimension(175, 200));
		JButton buttonTopRight = new JButton(
				"<html>" + "CURRENT JOBS<br><br>" + "3" + "</html>"
				
				);
		buttonTopRight.setPreferredSize(new Dimension(175,200));
		leftSide_r1_elem[0].add(buttonTopRight);
		
		
		// r1 Camera - Front View
		ImageIcon frontViewImage = new ImageIcon(MainMenu.class.getResource("frontview.jpg"));
		leftSide_r1_elem[1].add(new JLabel(frontViewImage));
		leftSide_r1_elem[1].setPreferredSize(new Dimension(300, 200));
		
		
		
		// Right side r1
		//leftSide_r1_elem[2].setBackground(Color.RED);

		
		leftSide_r1_elem[2].setPreferredSize(new Dimension(175, 200));
		buttonTopLeft = new JButton(
				"<html>" + "ADD OR CHANGE ROUTE<br>" + "</html>"
				);
		buttonTopLeft.setPreferredSize(new Dimension(174,200));
		

		
		
		
		leftSide_r1_elem[2].add(buttonTopLeft);
		
		
		for(JPanel i : leftSide_r1_elem){
			leftSide_r1.add(i,FlowLayout.LEFT);
		}
		
		
		/*
		 * Left Row 2 Specification
		 */
		JPanel leftSide_r2 = new JPanel(new FlowLayout(0,0,0));
		leftSide_r2.setPreferredSize(new Dimension(650, 250));

		JPanel leftSide_r2_elem[] = {
				new JPanel(new FlowLayout(0,0,0)),
				new JPanel(new FlowLayout(0,0,0)),
				new JPanel(new FlowLayout(0,0,0))
		};

		
		// LEFT CAMERA
		leftSide_r2_elem[0].setPreferredSize(new Dimension(175,leftSide_r2.getPreferredSize().height));
		ImageIcon leftViewImage = new ImageIcon(MainMenu.class.getResource("leftview.jpg"));
		leftSide_r2_elem[0].add(new JLabel(leftViewImage));
		
		
		// MAP
		leftSide_r2_elem[1].setPreferredSize(new Dimension(300, leftSide_r2.getPreferredSize().height));
		ImageIcon gpsImage = new ImageIcon(MainMenu.class.getResource("gps.jpg"));
		leftSide_r2_elem[1].add(new JLabel(gpsImage));
		
		
		// RIGHT CAMERA
		leftSide_r2_elem[2].setBackground(Color.YELLOW);
		leftSide_r2_elem[2].setPreferredSize(new Dimension(175, leftSide_r2.getPreferredSize().height));
		leftSide_r2_elem[2].setPreferredSize(new Dimension(175,leftSide_r2.getPreferredSize().height));
		ImageIcon rightViewImage = new ImageIcon(MainMenu.class.getResource("rightview.jpg"));
		leftSide_r2_elem[2].add(new JLabel(rightViewImage));
		
		
		
		
		
		for(JPanel i : leftSide_r2_elem){
			leftSide_r2.add(i);
		}
		
		
		/*
		 * Row 3 Specification
		 */
		JPanel leftSide_r3 = new JPanel(new FlowLayout(0,0,0));
		JPanel leftSide_r3_elem[] = {
				new JPanel(new FlowLayout(0,0,0)),
				new JPanel(new FlowLayout(0,0,0)),
				new JPanel(new FlowLayout(0,0,0))
		};
		
		leftSide_r3_elem[0].setPreferredSize(new Dimension(175, 200));
		JButton buttonBottomRight = new JButton();
		buttonBottomRight.setPreferredSize(new Dimension(175,200));
		leftSide_r3_elem[0].add(buttonBottomRight);
		

		
		
		// Rear View Camera
		leftSide_r3_elem[1].setBackground(Color.BLUE);
		leftSide_r3_elem[1].setPreferredSize(new Dimension(300, 200));
		ImageIcon rearViewImage = new ImageIcon(MainMenu.class.getResource("rearview.jpg"));
		leftSide_r3_elem[1].add(new JLabel(rearViewImage));
		
		
		
		
		leftSide_r3_elem[2].setPreferredSize(new Dimension(175, 200));
		JButton buttonBottomLeft = new JButton();
		buttonBottomLeft.setPreferredSize(new Dimension(175,200));
		leftSide_r3_elem[2].add(buttonBottomLeft);
		
		
		
		
		for(JPanel i : leftSide_r3_elem){
			leftSide_r3.add(i,FlowLayout.LEFT);
		}
		
		JPanel leftSide_r4 = new JPanel(new FlowLayout(0,0,0));
		
		JButton leftSideButtons[] = {
				new JButton("TOGGLE EMERGENCY MODE"),
				new JButton("LOGOUT"),
				new JButton("TOGGLE MANUAL DRIVING")
		};
		
		for(int i=0, length = leftSideButtons.length; i<length; i++){
			leftSideButtons[i].setPreferredSize(new Dimension(650/length , 77));
			leftSide_r4.add(leftSideButtons[i]);
		}
		
		
		
		leftSideButtons[1] .addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Logout?",  JOptionPane.YES_NO_OPTION);
				if(selection == JOptionPane.YES_OPTION){
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
					cardLayout.invalidateLayout(contentPane);
					cardLayout.show(contentPane, "Login");	
				}
			}
		});
		
		

		

		
		// add each row to the left side of the menu (GPS + Buttons)
		leftSide.add(leftSide_r1);
		leftSide.add(leftSide_r2);
		leftSide.add(leftSide_r3);
		leftSide.add(leftSide_r4);
		
		

		
		/*
		 *Button Listeners 
		 */

		
		buttonTopRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "buttonTopRight");	
			}
		});
		
		buttonBottomLeft.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "buttonBottomLeft");	
			}
		});
		
		buttonBottomRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "buttonBottomRight");	
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		

		return leftSide;
		
	}
	
	public JPanel getRightSide(){
		final JPanel rightSide = new JPanel(new CardLayout());
		
		
		rightSide.add(new RouteManagement(rightSide),  "Add Route");
		rightSide.add(new michaelcommit(rightSide),  "test");
		
		
		buttonTopLeft.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout cardLayout = (CardLayout) rightSide.getLayout();
				cardLayout.invalidateLayout(contentPane);
				cardLayout.show(rightSide, "test");	
				topMenu.setDestinationText(new JLabel("New Destination st, city, 3232"));

			}
		});
		
		/*
		buttonTopLeft.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
				cardLayout.invalidateLayout(contentPane);
				cardLayout.show(contentPane, "Login");	
				JOptionPane.showMessageDialog(null, "buttonTopLeft");	
			}
		});*/
		
		
		return rightSide;
	}
	
	
	
	
	
	
	
	
	
	
}
