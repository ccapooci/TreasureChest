package barSections;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import components.UsdFormattedTextField;
import interfaces.GuiComponent;
import parentClasses.SavTrackPanel;
import windows.SavingsTracker;

/*   TotalAccountBalanceSection
 *   Contains the data for the account balance.
 */
public class TotalAccountBalanceSection extends SavTrackPanel implements GuiComponent{
	private UsdFormattedTextField txtTotalAccountBalance;  // textfield that holds the account value
	private JLabel lblTotal;                               
	private SavingsTracker masterTracker;                  // highest level component that tracks data

	/*   Constructor 
	 * 	 Creates the elements of the section and places them in the
	 *   appropriate locations on the screen.
	 *   	savTrack:     The highest level component that has access to other components
	 *      totalBalance: The initial total balance in the account
	 */	
	public TotalAccountBalanceSection(SavingsTracker savTrack,
									  double         totalBalance) {
		super(savTrack);
		// save the class variables
		masterTracker = savTrack;
		
		// set the layout to box layout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Indicate the account balance field with a label
		lblTotal = new JLabel("Total Account Balance");
		lblTotal.setAlignmentX(LEFT_ALIGNMENT);
		add(lblTotal);
		
		// set the text field that will contain the balance information
		txtTotalAccountBalance = new UsdFormattedTextField(savTrack);
		txtTotalAccountBalance.set(totalBalance);
		add(txtTotalAccountBalance);
	}

	/*   getTotalAccountValue
	 *   Return the account value stored in this sections text field
	 */
	public double getTotalAccountValue()
	{
		return txtTotalAccountBalance.getValue();
	}
	
	/*  setTotalAccountValue
	 *  Set the total account value to the value here.
	 *  	value: The new account value
	 */
	public void setTotalAccountValue(double value)
	{
		txtTotalAccountBalance.set(value);
	}
	
	/*   refresh
	 *   Refreshes the value in the account balance text field 
	 */
	public void refresh() {
	}
}
