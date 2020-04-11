package components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import parentClasses.SavTrackPanel;
import windows.SavingsTracker;
import javax.swing.JLabel;

/*   UsdFormattedTextField
 * 	 TextField formatted for the USD.
 */
public class UsdFormattedTextField extends SavTrackPanel {
	private JTextField textField; // the text field that holds the usd value
	private JLabel dollarSign;    // a dollar positioned next to the value
	private SavingsTracker masterTracker; // highest level component
	private boolean focused = false;
	
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
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				focused = true;
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				focused = false;
			}
			
		});

	}
	
	public void set(double totalValue)
	{
	
		if (totalValue >= 0)
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
				else 
				{
					valStr = splits[0] + '.' + splits[1].substring(0, 2);
				}
			
			}
		
			textField.setText(valStr);
		}
		else 
		{
			textField.setText("0.00");
		}

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
			
			if(!valueNoCommas.equals(""))
			{
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
		}
		
		return amountReturn;
	}
	
	public void refresh()
	{
		if (!focused)
		{
			set(getValue());
		}
	}
}
