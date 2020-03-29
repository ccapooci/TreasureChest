package tabs;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import depositSections.CreateDepositSection;
import depositSections.DepositTable;
import parentClasses.SavTrackPanel;
import utilities.Database;
import windows.SavingsTracker;

public class DepositTableTab extends SavTrackPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -738097677564985378L;
	private DepositTable table = null;
	private static Database db = null;

	public DepositTableTab(SavingsTracker savTrack, Database db) {
		super(savTrack, new GridBagLayout());
		this.db = db;
		createDepositTableTab();
	}
	
	private void createDepositTableTab()
	{
		GridBagConstraints gbc = new GridBagConstraints();
		table = new DepositTable(this.savsTrack, db);
		
        // create the layout of the pieces on this panel
        // then ask for the name of the deposit
        gbc.gridheight = 1;
        gbc.gridwidth = 5;
        gbc.gridx = 7;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;
        gbc.weighty = 0.5;
        this.add(table, gbc);
        
        // need to add all of the deposits from the database
		
	}

	public void addDeposit(String   depName,
                           double   totDep,
			               double[] itemDep,
			               int      numItems,
			               String   duration,
			               String   nextOcc) 
   {
      table.addDeposit(depName, totDep, itemDep, numItems, duration, nextOcc);
   }

	public void refresh() {
		// needs to go through all of the entries in the and 
		// see if any of the dates have passed
	}
	

	
}