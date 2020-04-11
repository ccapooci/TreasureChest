package columnSections;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import components.UsdFormattedTextField;
import interfaces.GuiComponent;
import parentClasses.SavTrackPanel;
import windows.SavingsTracker;

/*   DepositSection
 *   Holds the amount funds that the item contains.
 */
public class DepositSection extends SavTrackPanel implements GuiComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = -629244649309049524L;
	private UsdFormattedTextField txtDeposit; // holds the value of the item
	
	/*   DepositSection
	 *   Creates and arranges the components of the section.
	 *   	savTrack:  the highest level component
	 *   	initValue: the initial funds for this deposit section.
	 */
	public DepositSection(SavingsTracker savTrack,
					      double         initValue) {
		super(savTrack);
		
		// used to arrange the components
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel lblDeposit = new JLabel("Deposit");
		
		setLayout(new GridBagLayout());
		
		// create the layout of the pieces on this panel
        // place the label on the section 
		gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
    	lblDeposit.setAlignmentX(CENTER_ALIGNMENT);
		add(lblDeposit, gbc);
		
	    // place the text field on the right
		// and set it up
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
   		txtDeposit = new UsdFormattedTextField(savTrack);
		txtDeposit.setAlignmentX(CENTER_ALIGNMENT);
		add(txtDeposit, gbc);
		txtDeposit.set(initValue);
	}

	/*   getAmount
	 *   Return the amount of funds that is in the deposit section.
	 */
	public double getAmount()
	{
		return txtDeposit.getValue();
	}
	
	/*   addValue
	 *   Add additional funds to the section. 
	 */
	public void addValue(double value)
	{
		txtDeposit.set(txtDeposit.getValue() + value);
	}
	
	/*   refresh
	 *   Set the value of the section again.
	 */
	public void refresh()
	{
		txtDeposit.refresh();
	}
}
