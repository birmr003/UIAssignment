import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * 
 * @author Anthony Defazio
 *
 */
public class SupplyManagement extends JPanel {
	//Create JPanel to hold items
	private JPanel contentPane;
	//Create Label to inform users of the page
	private JLabel titleLabel;
	//Create JTable to store inventory
	private static JTable table;
	//Track changes to determine if information needs to be sent to dispatch
	protected static int changesCount = 0;
	//Create Label to inform users of change notification
	private static JLabel infoText;
	//Create button to submit inventory changes
	private JButton submitRequest = new JButton();

	public SupplyManagement(JPanel content) {
		JPanel contentPane = new JPanel(new GridLayout(2,1));
		//Set elements
		titleLabel = new JLabel("Supply Management");
		titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
		//Add Label to contentPane
		contentPane.add(titleLabel);
		//Set Label to not show anything until required
		infoText = new JLabel("");
		//Add Label to contentPane
		contentPane.add(infoText);
		//Add contentPane to window
		add(contentPane);

		//Create TableModel to store table cell values  
		JPanel contentPane2 = new JPanel(new GridLayout(4,1));
		DefaultTableModel inventoryList = new DefaultTableModel();
		inventoryList.setDataVector(new Object[][] { {"Bandages", 40, "Add Stock", "Remove" },
				{"Swabs", 100, "Add Stock", "Remove" },
				{"Prep Razors", 10, "Add Stock", "Remove" },
				{"BVM Kit", 10, "Add Stock", "Remove" },
				{"Sterile Water", 10, "Add Stock", "Remove" },
				{"Burn Sheets", 2, "Add Stock", "Remove" },
				{"Oxygen Cylinder", 3, "Add Stock", "Remove" },
				{"Nasal Cannula", 5, "Add Stock", "Remove" },
				{"Emesis Basins", 4, "Add Stock", "Remove" },
				{"Vomit Bags", 10, "Add Stock", "Remove" },
				{"Water Soluble Lubricant", 10, "Add Stock", "Remove" },
				{"Cold Packs", 10, "Add Stock", "Remove" },
				{"Gauze - Large Roll", 6, "Add Stock", "Remove" }, 
				{"Gauze - Small Roll", 6, "Add Stock", "Remove" },
				{"Gauze Pads", 50, "Add Stock", "Remove" }, 
				{"Hot Packs", 4, "Add Stock", "Remove" }, 
				{"Adhesive Elastic Strips", 20, "Add Stock", "Remove" }, 
				{"Alcohol Prep Pads", 30, "Add Stock", "Remove" }, 
				{"Gloves Large", 4, "Add Stock", "Remove" }, 
				{"IV Catheter 14 Gauge", 6, "Add Stock", "Remove" },
				{"Needles 18/22 Gauge", 6, "Add Stock", "Remove" },
				{"Syringes 1,3,5,10cc", 10, "Add Stock", "Remove" },
				{"Syringes 20cc", 3, "Add Stock", "Remove" },
				{"Vaccutainers Tubes", 6, "Add Stock", "Remove" },
				{"Biohazard Bags", 5, "Add Stock", "Remove" },
				{"HEPA Mask", 5, "Add Stock", "Remove" },
				{"Immobilization Kit", 1, "Add Stock", "Remove" },
				{"IV Pump", 1, "Add Stock", "Remove" },
				{"Drug Kit", 2, "Add Stock", "Remove" },

		}, 
		new Object[] {"Item", "Inventory", "Add", "Remove" });

		//Assign TableModel to JTable
		table = new JTable(inventoryList);

		//Set table column sizes and row height
		table.getColumnModel().getColumn(0).setPreferredWidth(125);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.setRowHeight(20);

		//Center column
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);

		//Set custom CellRender to display Add & Remove button 
		table.getColumn("Add").setCellRenderer(new ButtonRenderer());
		table.getColumn("Remove").setCellRenderer(new ButtonRenderer());
		//Set custom CellEditor to edit cell contents to display JButtons
		table.getColumn("Add").setCellEditor(new ButtonEditor(new JCheckBox()));
		table.getColumn("Remove").setCellEditor(new ButtonEditor(new JCheckBox()));

		//Creates a scrollable component of the inventory table
		JScrollPane scroll = new JScrollPane(table);
		//Add scrollable table to pane
		contentPane2.add(scroll, BorderLayout.CENTER);
		//Add pane to window
		add(contentPane2);

		//Create additional pane for submit button
		JPanel contentPane3 = new JPanel(new GridLayout(8,1));
		//Create submit button
		JButton submitRequest = new JButton("Submit Request");
		//Set the size of the button
		submitRequest.setSize(50, 20);
		//Attach actionListener to button to action upon user press
		submitRequest.addActionListener(new SubmitActionAdapter(this));
		//Add button to pane
		contentPane3.add(submitRequest, BorderLayout.CENTER);
		//Add pane to previous pane
		contentPane2.add(contentPane3);
		add(contentPane2);


	}

	protected static void modifyStock() {
		//Determine which button was pressed - add or remove
		int selButton = table.getSelectedColumn();
		if(selButton == 2)
		{
			//If column 2 was pressed, user selected add stock
			int newValue = (Integer) table.getModel().getValueAt(table.getSelectedRow(), 1);
			newValue = newValue + 1;
			//Increase stock count for that item and update table
			table.setValueAt(newValue, table.getSelectedRow(), 1);
			changesCount = changesCount + 1;
		}
		else
		{
			//If column 3 was pressed, user selected deplete stock
			int newValue = (Integer) table.getModel().getValueAt(table.getSelectedRow(), 1);
			//If there is stock remaining
			if(newValue > 0)
			{
				newValue = newValue - 1;	
				//Deplete stock count of that item and update table
				table.setValueAt(newValue, table.getSelectedRow(), 1);
				changesCount = changesCount +1;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "You must order more stock before continuing");
				setInfoText(table.getValueAt(table.getSelectedRow(), 0) + " - Out of stock", Color.RED);
				System.out.println(table.getValueAt(table.getSelectedRow(),1));
			}
		}

	}

	public static void setInfoText(String newText,Color color) {
		//Set Label to inform users of changes
		infoText.setText(newText);
		infoText.setForeground(color);
	}



}

class SubmitActionAdapter implements ActionListener
{
	//ActionListener for when user's press submit button 
	SupplyManagement adaptee;
	SubmitActionAdapter(SupplyManagement adaptee){
		this.adaptee = adaptee;
	}


	public void actionPerformed(ActionEvent e) {
		if(SupplyManagement.changesCount ==0)
		{
			//If tracking indicates no changes to inventory list, show dialog and call setter to update Label
			JOptionPane.showMessageDialog(null, "No modifications made!");
			SupplyManagement.setInfoText("No Inventory Changes Made", Color.RED);
		}
		else
		{
			//If tracking indicates changes were made, show dialog to ask user to confirm and call setter to update Label
			int selection = JOptionPane.showConfirmDialog(null, "Please confirm the request to modify or request additional stock.", "Stock Adjustment",  JOptionPane.YES_NO_OPTION);
			if(selection == JOptionPane.YES_OPTION){
				SupplyManagement.changesCount = 0;
				SupplyManagement.setInfoText("Inventory Update Sucessfully Sent to Dispatch",Color.GREEN);
			}
			else
			{
				//If user chose not to confirm, call setter to update text
				SupplyManagement.setInfoText("No Inventory Changes Made",Color.RED);
			}
		}
	}
}

/**
 * @Author Crionics Incorporated
 * @version 1.0 11/09/98
 * Sourced from - http://www.java2s.com/Code/Java/Swing-Components/ButtonTableExample.htm
 * Approval granted for use within assignment from Ross Smith 
 */

//Custom button renderer 
class ButtonRenderer extends JButton implements TableCellRenderer {

	public ButtonRenderer() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
		} else {
			setForeground(table.getForeground());
			setBackground(UIManager.getColor("Button.background"));
		}
		setText((value == null) ? "" : value.toString());
		return this;
	}
}

/**
 * @Author Crionics Incorporated
 * @version 1.0 11/09/98
 * Sourced from - http://www.java2s.com/Code/Java/Swing-Components/ButtonTableExample.htm
 * Approval granted for use within assignment from Ross Smith 
 */
//Custom button editor  
class ButtonEditor extends DefaultCellEditor {
	protected JButton button;

	private String label;
	private boolean isPushed;

	public ButtonEditor(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}


		});


	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		} else {
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		label = (value == null) ? "" : value.toString();
		button.setText(label);
		isPushed = true;
		return button;
	}

	public Object getCellEditorValue() {
		if (isPushed) {
			SupplyManagement.modifyStock();
		}
		isPushed = false;
		return new String(label);
	}



	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}
}


