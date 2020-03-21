package bars;


import barSections.AccountInfoBarSection;
import interfaces.GuiComponent;
import parentClasses.SavTrackPanel;
import utilities.Database;
import windows.SavingsTracker;

/* Overview Bar
 *  The  GUI component at the bottom of the page. It displays information about the total
 *  value of the account and how much of the account value is unaccounted for in the items
 *  section. 
 * 	It displays:
 * 		Total amount of funds in the account.
 * 		The amount that is unused out of that balance.
 * 
 */
public class OverviewBar extends SavTrackPanel implements GuiComponent {
	private AccountInfoBarSection acntInfoBarSect = null;  // one of the sections of the bar
	
	/* Constructor
	 *   Creates the components of the OverviewBar and adds them.
	 *     Components include:
	 *     		account info section (includes funds in the account and unused funds in account)
	 */
	public OverviewBar(SavingsTracker savingsTracker,
					   Database       db,
					   int            dbId,
					   double         amountUsed) 
	{
		super(savingsTracker);
		
		// create the account info section of the bar and add it to the Overview bar
		acntInfoBarSect = new AccountInfoBarSection(savingsTracker, db, dbId, amountUsed);
		add(acntInfoBarSect);
	}

	/* 	saveData
	 * 		Save the data within the component into the database
	 */
	public void saveData()
	{
		// no data in this component
		
		// tell all components within this one to save their data
		acntInfoBarSect.saveData();
	}
	
	/*  addFunds 
	 * 		Add more funds into the account. 
	 * 		Parameters:
	 * 			totalAdd:  The total amount added to the account
	 * 			usedFunds: Of the total, how much of it is accounted for in the items.
	 */
	public void addFunds(double totalAdd)
	{
		// indicate to the account info bar the amount of funds to add. 
		acntInfoBarSect.addFunds(totalAdd);
	}
	
	/*	refresh
	 * 		Refresh the GUI to an appropriate condition. 
	 * 		Especially to make sure all dollar amount look correct.  
	 */
	public void refresh() {
		// refresh the components of this component
		acntInfoBarSect.refresh();
	}
	
	/*	setUsed 
	 * 		Set the amount of funds that are being used.
	 */
	public void setUsed(double used)
	{
		// tell the component below how much is being used
		acntInfoBarSect.setUsed(used);
	}
}
