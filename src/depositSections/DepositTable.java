package depositSections;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import parentClasses.SavTrackPanel;
import utilities.CalendarDate;
import utilities.Database;
import windows.SavingsTracker;

public class DepositTable extends SavTrackPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4934696423038674260L;
	JScrollPane scroll = null;
	JTable depTable = null;
	String[] colNames = {"ID", "Deposit Name", "Total Deposit", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Next Deposit", "Delete?"};
	JButton delete = null;
	DefaultTableModel model = null;
	long id;
	int numDep;
	Database db = null;
	LocalDate currentDate = null;
	String occ = null;
	/**
	 * Create the panel.
	 */
	public DepositTable(SavingsTracker savTrack,
						Database data) {
		super(savTrack, new GridBagLayout());
		
		int numDeps =0;
		GridBagConstraints gbc = new GridBagConstraints();
		db = data;
		model = new DefaultTableModel();
		String idVal = data.queryString("SELECT NUMID FROM DEPOSITSINFO WHERE ID=0", 1);
		String numDepStr = data.queryString("SELECT NUMDEP FROM DEPOSITSINFO WHERE ID=0", 1);
		id = Long.parseLong(idVal);
		numDep = Integer.parseInt(numDepStr);
		CalendarDate depDate = null;
		ResultSet ids = null;
		String newDate = null;
		
		depTable = new JTable(model) {
			

            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5:
                        return String.class;
                    case 6:
                        return String.class;
                    case 7:
                        return String.class;
                    case 8:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        }; 
        depTable.setFillsViewportHeight(true);
                
        scroll = new JScrollPane(depTable);
        
        delete = new JButton("Delete Deposit");	
        delete.setSize(50, 10);
			
		model.addColumn("ID");
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
		
		
		depTable.removeColumn(depTable.getColumn("ID"));
		numDeps = Integer.parseInt(db.queryString("SELECT NUMDEP FROM DEPOSITSINFO", 1));
		
		long tempId =0;
		String tempName = null;
		double tempDep = 0;
		double itemVal[] = new double[6];
		String nxtDep = null;
		if(numDeps > 0)
		{
			boolean first = true;
			ids = db.queryMult("SELECT ID FROM DEPOSITS");
			for(int i=0; i<numDeps; i++)
			{
				if(!first)
				{
					try {
						ids.next();
					}catch (SQLException e) {
						System.out.println("Failure on next in DepTable.");
						e.printStackTrace();
						// TODO Auto-generated catch block
					}
					
					
				}
				first = false;
				try {
					tempId = ids.getLong(1);
				}
				catch(SQLException e)
				{
					System.out.println("Failure on getLong in DepTable.");
					e.printStackTrace();
				}
				
				tempName = db.queryString("SELECT NAME FROM DEPOSITS WHERE ID="+tempId, 1);
				tempDep = Double.parseDouble(db.queryString("SELECT TOTDEP FROM DEPOSITS WHERE ID="+tempId, 1));
				itemVal[0] = Double.parseDouble(db.queryString("SELECT ITEM1 FROM DEPOSITS WHERE ID="+tempId, 1));
				itemVal[1] = Double.parseDouble(db.queryString("SELECT ITEM2 FROM DEPOSITS WHERE ID="+tempId, 1));
				itemVal[2] = Double.parseDouble(db.queryString("SELECT ITEM3 FROM DEPOSITS WHERE ID="+tempId, 1));
				itemVal[3] = Double.parseDouble(db.queryString("SELECT ITEM4 FROM DEPOSITS WHERE ID="+tempId, 1));
				itemVal[4] = Double.parseDouble(db.queryString("SELECT ITEM5 FROM DEPOSITS WHERE ID="+tempId, 1));
				itemVal[5] = Double.parseDouble(db.queryString("SELECT ITEM6 FROM DEPOSITS WHERE ID="+tempId, 1));
				nxtDep = db.queryString("SELECT NEXTOCC FROM DEPOSITS WHERE ID="+tempId, 1);
				occ = db.queryString("SELECT DURATION FROM DEPOSITS WHERE ID=" + tempId, 1);
				
				
				newDate = adjustItems(nxtDep, itemVal, tempId);
				Object[] row = {tempId, tempName, tempDep, itemVal[0],itemVal[1],itemVal[2],itemVal[3],itemVal[4],itemVal[5],newDate, false};
				model.addRow(row);
			}
		}		
		

		
		gbc.gridheight = 2;
		gbc.gridwidth = 5;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.BOTH;//GridBagConstraints.HORIZONTAL;
	    gbc.weightx = 1;
	    gbc.weighty = 0.8;
	    gbc.insets.bottom = 10;
	    gbc.insets.left   = 10;
	    gbc.insets.right  = 10;
	    gbc.insets.top    = 10;
	    gbc.anchor = GridBagConstraints.CENTER;
		add(scroll, gbc);
		
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    gbc.fill = GridBagConstraints.NONE;//GridBagConstraints.HORIZONTAL;
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    add(delete, gbc);
	    
	    
	    
	    delete.addActionListener(new ActionListener() {
	    	@Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < model.getRowCount(); i++)
                {
                	// column indicates if the user wants to delete it
                	if((boolean)(model.getValueAt(i, 10)))
                	{
                		removeDeposit(i);
                	}
                }
            }
	    });
	    
	    
	}
	
	public void addDeposit(String depName, double totDep, double[] itemDep, int numItems, String duration, String nextOcc)
	{
		numDep++;
		Object[] row = {id, depName, totDep, itemDep[0],itemDep[1],itemDep[2],itemDep[3],itemDep[4],itemDep[5],nextOcc, false};
		model.addRow(row);
		
		db.update("INSERT INTO DEPOSITS VALUES (" + id + ", '" + depName + "',"+ totDep + ", " + itemDep[0] + ", " + itemDep[1] + ", " + itemDep[2] + ", " + itemDep[3] + ", " + itemDep[4] + ", " + itemDep[5] + ", '"+ duration +"', '" + nextOcc + "')");
		db.update("UPDATE DEPOSITSINFO SET NUMDEP=" + numDep);
		id++;
		db.update("UPDATE DEPOSITSINFO SET NUMID=" + id);
	}
	
	private void removeDeposit(int row)
	{
		numDep--;
		db.update("DELETE FROM DEPOSITS WHERE ID="+model.getValueAt(row, 0));
		model.removeRow(row);
		db.update("UPDATE DEPOSITSINFO SET NUMDEP=" + numDep);
	}
	
	private int getLocalDateMonth(String date)
	{
		String[] parts;
		parts = date.split("-");
		return Integer.parseInt(parts[1]);
	}
	
	private int getLocalDateDay(String date)
	{
		String[] parts;
		parts = date.split("-");
		return Integer.parseInt(parts[2]);
	}
	
	private int getLocalDateYear(String date)
	{
		String[] parts;
		parts = date.split("-");
		return Integer.parseInt(parts[0]);
	}

	private int getCalendarDateMonth(String date)
	{
		String[] parts;
		parts = date.split("-");
		return Integer.parseInt(parts[0]);
	}
	
	private int getCalendarDateDay(String date)
	{
		String[] parts;
		parts = date.split("-");
		return Integer.parseInt(parts[1]);
	}
	
	private int getCalendarDateYear(String date)
	{
		String[] parts;
		parts = date.split("-");
		return Integer.parseInt(parts[2]);
	}

	/*
	 * Given the deposit date from the repository,
	 * this function calculates the number of missed deposits
	 * and adds them to the appropriate columns.
	 * 
	 * Returns the next deposit date.
	 */
	private String adjustItems(String nextDepositDate, double[] itemVal, long tempId)
	{
		CalendarDate today = null;
    	CalendarDate depDate = null;
		LocalDate localDate = LocalDate.now();
		int missedDeps = 0;
		double[] addDepositData = new double[6];
		String newDate = nextDepositDate;
		

    	today = new CalendarDate(getLocalDateMonth(localDate.toString()),
    			                 getLocalDateDay(localDate.toString()),
				                 getLocalDateYear(localDate.toString()));

    	depDate = new CalendarDate(getCalendarDateMonth(nextDepositDate),
    							   getCalendarDateDay(nextDepositDate), 
    							   getCalendarDateYear(nextDepositDate));
    	
		missedDeps = today.howGreater(depDate, occ);
		
		if(missedDeps > 0)
		{
			int j = 0;
			for(double val : itemVal)
			{
				addDepositData[j] = val * missedDeps;
				j++;
			}
		
			this.savsTrack.addToItems(addDepositData, 6);
			// Plus one because we want to go to the next deposit.
			depDate.add(missedDeps, occ);

			newDate = depDate.getString();

			db.update("UPDATE DEPOSITS SET NEXTOCC='" + newDate +"' WHERE ID=" + tempId);
		}

		return newDate;
	}
	
}
