package tabs;

import java.awt.BorderLayout;
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
		super(savTrack);
		this.db = db;
		createDepositTableTab();
	}
	
	private void createDepositTableTab()
	{
		table = new DepositTable(this.savsTrack, db);

        this.add(table, BorderLayout.CENTER);
        
  		
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

	public void refresh() 
	{
		// needs to go through all of the entries in the and 
		// see if any of the dates have passed
	}
	

	
}