package depositSections;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DepositTable extends JPanel {
	JScrollPane scroll = null;
	JTable depTable = null;
	String[] colNames = {"Deposit Name", "Total Deposit", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Next Deposit", "Delete?"};
	JButton delete = null;
	DefaultTableModel model = null;
	/**
	 * Create the panel.
	 */
	public DepositTable() {
		GridBagConstraints gbc = new GridBagConstraints();
		String[][] noData = {};
		model = new DefaultTableModel();
		depTable = new JTable(model); 
		scroll = new JScrollPane(depTable);
		depTable.setFillsViewportHeight(true);
		delete = new JButton("Delete Deposit");		
		
		model.addColumn("Deposit Name");
		model.addColumn("Total Deposit");
		model.addColumn("Item 1");
		model.addColumn("Item 2");
		model.addColumn("Item 3");
		model.addColumn("Item 4");
		model.addColumn("Item 5");
		model.addColumn("Item 6");
		model.addColumn("Next Deposit");
		model.addColumn("Delete?");
		
		
		GridBagLayout gbl = new GridBagLayout();
		
		setLayout(new GridBagLayout());
		
		gbc.gridheight = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.BOTH;//GridBagConstraints.HORIZONTAL;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
		add(scroll, gbc);
		
		gbc.gridheight = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.fill = GridBagConstraints.NONE;//GridBagConstraints.HORIZONTAL;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    add(delete, gbc);
	}
	
	public void addDeposit(String depName, double totDep, double[] itemDep, int numItems, String duration, String nextOcc)
	{
		Object[] row = {depName, totDep, itemDep[0],itemDep[1],itemDep[2],itemDep[3],itemDep[4],itemDep[5],nextOcc, false};
		model.addRow(row);
	}

}
