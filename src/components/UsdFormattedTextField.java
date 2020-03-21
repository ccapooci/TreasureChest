package components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import parentClasses.SavTrackPanel;
import windows.SavingsTracker;
import javax.swing.JLabel;

/*   UsdFormattedTextField
 * 	 TextField formatted for the USD.
 */
public class UsdFormattedTextField extends SavTrackPanel{
	private JTextField textField; // the text field that holds the usd value
	private JLabel dollarSign;    // a dollar positioned next to the value
	private SavingsTracker masterTracker; // highest level component

	/*  Constructor
	 *  Creates the components in the UsdFormattedTextField and 
	 *  arranges them.  Puts the dollar sign to the left of the
	 *  USD formatted numerical value.
	 */
	public UsdFormattedTextField(SavingsTracker savTrack) {
		super(savTrack);
		// constraints used to lay out the components
		GridBagConstraints gbc = new GridBagConstraints();
		
		// the layout of the components
		setLayout(new GridBagLayout());
		// save the tracker
		masterTracker = savTrack;
		
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.1;
        gbc.weighty = 0.5;

		dollarSign = new JLabel();
		dollarSign.setText("$");
		add(dollarSign,gbc);
		
		
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.9;
        gbc.weighty = 0.5;
		
		// create the formatted text field
        textField = new JTextField();
        textField.setText("0.00");
		add(textField, gbc);
		textField.setColumns(25);

	}
	
	public void set(double totalValue)
	{
		String valStr = Double.toString(totalValue);
		
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
		}
		
		textField.setText(valStr);
	}
	
	public double getValue()
	{
		String amountText = textField.getText();
		double amountReturn = 0;
		
		if(amountText != "")
		{
			String numbers[] = amountText.split(",");
			String valueNoCommas = "";
			
		
		
			for(String val : numbers)
			{
				valueNoCommas = valueNoCommas + val;
			}
			
			try
			{
				amountReturn = Double.parseDouble(valueNoCommas);
			}
			catch(Exception e)
			{
				System.out.println("Could not parse " + valueNoCommas);
				amountReturn = 0;
			}
		}
		
		return amountReturn;
	}
}
