import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Screens.JobManagement;
import Screens.RouteManagement;




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
	private JButton buttonTopRight;
	private JButton buttonBottomRight;
	private JButton buttonBottomLeft;
	
	private JButton buttonLogout;
	private JButton buttonEmergencyMode;
	private JButton buttonManualDriving;

	
	
	public MainMenu(JPanel panel, DriverlessCar mainLayout){
		contentPane = panel;
		setOpaque(true);
		setBackground(Color.gray.brighter());
		
		JSplitPane j = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		j.setPreferredSize(new Dimension(1270,730));
		j.setEnabled(false);
		
		JPanel leftSide = getLeftSide();
		
		rightSide = new JPanel(new CardLayout());
		rightSide = getRightSide();
		

		// GPS SIDE
		j.setLeftComponent(leftSide);
		
		// CONTENT SIDE
		j.setRightComponent(rightSide);

		// SET BUTTON LISTENERS
		addListeners();
		

		
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
		buttonTopRight = new JButton(
				"<html>" + "CURRENT JOBS<br><br>" + "3" + "</html>"
				
				);
		buttonTopRight.setPreferredSize(new Dimension(175,200));
		leftSide_r1_elem[0].add(buttonTopRight);
		
		
		// r1 Camera - Front View
		ImageIcon frontViewImage = new ImageIcon(MainMenu.class.getResource("Images/frontview.jpg"));
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
		ImageIcon leftViewImage = new ImageIcon(MainMenu.class.getResource("Images/leftview.jpg"));
		leftSide_r2_elem[0].add(new JLabel(leftViewImage));
		
		
		// MAP
		leftSide_r2_elem[1].setPreferredSize(new Dimension(300, leftSide_r2.getPreferredSize().height));
		ImageIcon gpsImage = new ImageIcon(MainMenu.class.getResource("Images/gps.jpg"));
		leftSide_r2_elem[1].add(new JLabel(gpsImage));
		
		
		// RIGHT CAMERA
		leftSide_r2_elem[2].setBackground(Color.YELLOW);
		leftSide_r2_elem[2].setPreferredSize(new Dimension(175, leftSide_r2.getPreferredSize().height));
		leftSide_r2_elem[2].setPreferredSize(new Dimension(175,leftSide_r2.getPreferredSize().height));
		ImageIcon rightViewImage = new ImageIcon(MainMenu.class.getResource("Images/rightview.jpg"));
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
		buttonBottomRight = new JButton();
		buttonBottomRight.setPreferredSize(new Dimension(175,200));
		leftSide_r3_elem[0].add(buttonBottomRight);
		

		
		
		// Rear View Camera
		leftSide_r3_elem[1].setBackground(Color.BLUE);
		leftSide_r3_elem[1].setPreferredSize(new Dimension(300, 200));
		ImageIcon rearViewImage = new ImageIcon(MainMenu.class.getResource("Images/rearview.jpg"));
		leftSide_r3_elem[1].add(new JLabel(rearViewImage));
		
		
		
		
		leftSide_r3_elem[2].setPreferredSize(new Dimension(175, 200));
		buttonBottomLeft = new JButton();
		buttonBottomLeft.setPreferredSize(new Dimension(175,200));
		leftSide_r3_elem[2].add(buttonBottomLeft);
		
		
		
		
		for(JPanel i : leftSide_r3_elem){
			leftSide_r3.add(i,FlowLayout.LEFT);
		}
		
		JPanel leftSide_r4 = new JPanel(new FlowLayout(0,0,0));
		

		
			
			
		

		buttonLogout = new JButton("LOGOUT");
		buttonEmergencyMode = new JButton("TOGGLE EMERGENCY MODE");
		buttonManualDriving = new JButton("TOGGLE MANUAL DRIVING");
		{
			Dimension size = new Dimension(650/3, 77);
			buttonEmergencyMode.setPreferredSize(size);
			buttonLogout.setPreferredSize(size);
			buttonManualDriving.setPreferredSize(size);
			leftSide_r4.add(buttonEmergencyMode);
			leftSide_r4.add(buttonLogout);
			leftSide_r4.add(buttonManualDriving);
		}
		
		
		
		// add each row to the left side of the menu (GPS + Buttons)
		leftSide.add(leftSide_r1);
		leftSide.add(leftSide_r2);
		leftSide.add(leftSide_r3);
		leftSide.add(leftSide_r4);
		

		return leftSide;
		
	}
	
	
	
	/*
	 * All Screens to be shown on the right are added here.
	 * Each one is in a separate java file, if a screen has its own separate screens
	 * then it can have its own cardlayout or tabbed navigation(preferable + easy to code)
	 * @return
	 */
	public JPanel getRightSide(){
		final JPanel rightSide = new JPanel(new CardLayout());
		
		rightSide.setMaximumSize(new Dimension(520,720));
		rightSide.setMinimumSize(new Dimension(520,720));
		
		
		rightSide.add(new RouteManagement(rightSide),  "Add Route");
		rightSide.add(new JobManagement(rightSide),  "Job Management");
		

		
		
		return rightSide;
	}
	
	/*
	 * Main menu button listeners
	 */
	public void addListeners(){
		/*
		 *Button Listeners 
		 */

		
		buttonTopRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout cardLayout = (CardLayout) rightSide.getLayout();
				cardLayout.invalidateLayout(contentPane);
				cardLayout.show(rightSide, "Job Management");	
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
		
		buttonTopLeft.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				CardLayout cardLayout = (CardLayout) rightSide.getLayout();
				cardLayout.invalidateLayout(contentPane);
				cardLayout.show(rightSide, "Add Route");	
			}
		});
	
	
		buttonLogout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Logout?",  JOptionPane.YES_NO_OPTION);
				if(selection == JOptionPane.YES_OPTION){
					
					// set default frame back to home screen
					CardLayout cardLayout = (CardLayout) rightSide.getLayout();
					cardLayout.invalidateLayout(contentPane);
					cardLayout.show(rightSide, "Add Route");	
					
					
					
					CardLayout logout = (CardLayout) contentPane.getLayout();
					logout.invalidateLayout(contentPane);
					logout.show(contentPane, "Login");	
				}
			}
		});
		
		buttonEmergencyMode.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				topMenu.changeEmergencyMode();
			}
		});
		
		buttonManualDriving.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				topMenu.changeDrivingMode();
			}
		});
	
		
	
	}
	
	
	
	
	
	
}
