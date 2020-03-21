package components;

import javax.swing.JLabel;

import parentClasses.SavTrackPanel;
import windows.SavingsTracker;

/*   UsdFormattedLabel
 *   A label that is formatted for the USD. Value is expected to be
 *   a number.
 */
public class UsdFormattedLabel extends SavTrackPanel {
	private JLabel dollarValue;   // Holds value
	private JLabel dollarSign;    // Holds the dollar sign
	private SavingsTracker masterTracker;  // the highest level component

	/*   Constructor 
	 *   Creates the components of this element. Then arranges them
	 *   with the dollar sign to the left of the value.
	 */
	public UsdFormattedLabel(SavingsTracker savTracker) {
		super(savTracker);
		// save the tracker
		masterTracker = savTracker;
		
		// add the dollar sign to the left
		dollarSign = new JLabel();
		dollarSign.setText("$");
		add(dollarSign);
		
		// create the formatted text field
		// add the text field to the right of the dollar sign
		dollarValue = new JLabel();
		dollarValue.setText("0.00");
		add(dollarValue);
	}
	
	/*   setValue
	 *   Set the value in the label to argument pass to this function.
	 *   	valueToSet: The new value held in the label.
	 */
	public void setValue(double valueToSet)
	{
		// get the decimal
		double decimal = valueToSet - (long)(valueToSet);
		// get the hundredths value
		double temp = 10*decimal;
		double hundredth = temp - (long)temp;
		
		// see if there is decimal
		// if not then put two zeros at the end
		if(decimal == 0)
		{
			dollarValue.setText(Double.toString(valueToSet) + "0");
		}
		else if(hundredth == 0)
		{
			dollarValue.setText(Double.toString(valueToSet) + "0");
		}
		else
		{
			dollarValue.setText(Double.toString(valueToSet));
		}
	}
}
