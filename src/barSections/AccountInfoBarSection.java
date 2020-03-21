package barSections;

import barSections.TotalAccountBalanceSection;
import barSections.UnusedBalanceSection;
import interfaces.GuiComponent;
import parentClasses.SavTrackPanel;
import utilities.Database;
import windows.SavingsTracker;

/*  AccountInfoBarSection
 *  
 *  A portion of the Overview Bar that holds the data for the 
 *  total amount of funds in the account. It also holds the amount 
 *  of funds that are unused. It holds the TotalAccountBalanceSection
 *  and UnusedBalanceSection.  
 */
public class AccountInfoBarSection extends SavTrackPanel implements GuiComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4453730560859606181L;
	
	private TotalAccountBalanceSection acntBalSect = null; // section of the bar
	private UnusedBalanceSection unusedBalSect = null;     // section of the bar
	//private InterestSection intSect = null;              // future section hopefully
	private Database db = null;                            // the database
	private int dbId = 0;                                  // ID where the account data is stored
	private String totBalStr = null;                       // the total balance as a String
	private double totBal=0;                               // the total balance as double
	private final int DEFAULT_INDEX = 1;                   // value that the database takes that doesn't change
	
	/*  Constructor
	 *  Takes all of the components in the AccountInfoBar and organize
	 *  them.
	 *  	savingsTracker: top level component that handles all data transfer.
	 *  	Database:       interacts with the database to retrieve data
	 *  	dataId:         id used to retrieve data from the database
	 *  	amountUsed:     the initial amount that funds accounted for
	 */
	public AccountInfoBarSection(SavingsTracker savingsTracker,
								 Database       data,
								 int            dataId,
								 double         amountUsed) {
		super(savingsTracker);
		// save class data
		db = data;
		dbId = dataId;
		
		// retrieve total account balance data
		totBalStr = db.queryString("select totbalance from accountinfo where id="+dataId, DEFAULT_INDEX);
		totBal = Double.parseDouble(totBalStr);
				
		// create the sections of the bar
		acntBalSect = new TotalAccountBalanceSection(savingsTracker, totBal);
		unusedBalSect = new UnusedBalanceSection(savingsTracker, totBal-amountUsed);
		
		// add the sections to the bar
		add(acntBalSect);
		add(unusedBalSect);
	}
	
	/*  refresh
	 *  Refreshes the data and displays of the account info section.
	 */
	public void refresh()
	{	
		// refresh the account balance info displays and information
		acntBalSect.refresh();
		unusedBalSect.refresh();
	}
	
	/*   saveData 
	 *   Save the data that is stored in this section of the 
	 *   user interface. 
	 */
	public void saveData() {
		// save total account value into the database
		db.update("update accountinfo set totbalance = " + acntBalSect.getTotalAccountValue() 
				  + " where id=" + dbId);
	}
	
	/*   setUsed
	 *   Set the value amount data that is considered "used" by
	 *   all of the item in the item section.
	 *   	used: the amount of funds in use by all the items
	 */
	public void setUsed(double used)
	{
		// calculate how much of the funds were used
		// set it in the unused balance section.
		unusedBalSect.setUnusedBalance(acntBalSect.getTotalAccountValue() - used);
	}
	
	/*   addFunds
	 *   Add funds to the total account balance. 
	 *   	additionalFunds: the additional funds to be added into the account
	 */
	public void addFunds(double additionalFunds)
	{
		acntBalSect.setTotalAccountValue(acntBalSect.getTotalAccountValue() + additionalFunds);
	}
}