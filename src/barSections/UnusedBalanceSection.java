package barSections;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

import components.UsdFormattedLabel;
import interfaces.GuiComponent;
import parentClasses.SavTrackPanel;
import windows.SavingsTracker;

/*   UnusedBalanceSection
 *   Section that contains the amount of funds that are unused
 *   out of the total funds.
 */
public class UnusedBalanceSection extends SavTrackPanel implements GuiComponent {
	private UsdFormattedLabel unusedAccountBalance;  // contains the value of unused funds
	private double unusedBalance;                    // the amount of money not used from the total
	private SavingsTracker masterTracker;            // the master component that communicates all of the data
	
	
	/*  Constructor 
	 *  Creates and organizes the components of this section.
	 *  	tracker:   The high level component that manages the data and components
	 *  	unusedBal: The initial unused balance. 
	 */
	public UnusedBalanceSection(SavingsTracker tracker,
								double         unusedBal) {
		super(tracker);
		JLabel lblTotal = new JLabel("Unused Amount");
		
		// save the class variables
		unusedBalance = unusedBal;
		masterTracker = tracker;
		
		// set the layout 
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// set the alignment of the label and add it  
		lblTotal.setAlignmentX(LEFT_ALIGNMENT);
		add(lblTotal);
		
		// create the label and set the unused value
		unusedAccountBalance = new UsdFormattedLabel(tracker);
		unusedAccountBalance.setValue(unusedBalance);
		add(unusedAccountBalance);
		
	}

	/*  setUnusedBalance
	 *  Set the unused balance in the section. Save the value in a class 
	 *  variable.
	 *     unusedBal: The value to set as the unused balance.
	 */
	public void setUnusedBalance(double unusedBal)
	{
		unusedBalance = unusedBal;
		unusedAccountBalance.setValue(unusedBalance);
	}
	
	/*   getUnusedBalance
	 *   Return the unused balance saved in the section. 
	 */
	public double getUnusedBalance()
	{
		return unusedBalance;
	}
	
	/*  refresh
	 *  Set the value of the unused balance to the current value. 
	 */
	public void refresh()
	{
		unusedAccountBalance.setValue(unusedBalance);
	}
}
