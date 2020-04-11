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
		String valStr = Double.toString(valueToSet);
		
		if(!valStr.contains("."))
		{
			valStr = valStr + ".00";
		}
		else
		{
			String[] splits = null;
			splits = valStr.split("\\.");
			
			if(splits[1].length() == 1)
			{
				valStr = valStr + "0";
			}
			else 
			{
				valStr = splits[0] + '.' + splits[1].substring(0, 2);
			}
			
		}
		
		dollarValue.setText(valStr);
	}
}
