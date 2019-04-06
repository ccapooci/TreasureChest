package components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import interfaces.GuiComponent;
import windows.SavingsTracker;
import javax.swing.JLabel;

public class UsdFormattedTextField extends JPanel implements MouseListener, GuiComponent{
	private Currency currency;
	private NumberFormat dollarValueFormat;
	private JFormattedTextField txtTotalAccountBalance;
	private JLabel dollarSign;
	private boolean firstPress;
	private SavingsTracker masterTracker;
	/**
	 * Create the panel.
	 */
	public UsdFormattedTextField(SavingsTracker savTrack) {
		GridBagConstraints gbc = new GridBagConstraints();
		
		setLayout(new GridBagLayout());
		
		masterTracker = savTrack;
		
		firstPress = true;
		
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.1;
        gbc.weighty = 0.5;

		dollarSign = new JLabel();
		dollarSign.setText("$");
		add(dollarSign,gbc);
		
		// use the set the text field layout
		currency = Currency.getInstance(new Locale("en", "US"));
		
		// formatting for the text field
		// 2 values after the decimal
		dollarValueFormat = NumberFormat.getNumberInstance();
		dollarValueFormat.setMaximumFractionDigits(2);
		dollarValueFormat.setMinimumFractionDigits(2);
		dollarValueFormat.setCurrency(currency);
		
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.9;
        gbc.weighty = 0.5;
		
		// create the formatted text field
		txtTotalAccountBalance = new JFormattedTextField(dollarValueFormat);
		txtTotalAccountBalance.setText("0.00");
		add(txtTotalAccountBalance, gbc);
		txtTotalAccountBalance.setColumns(25);

		txtTotalAccountBalance.addMouseListener(this);
		addMouseListener(this);
	}
	
	public void refresh()
	{
	}
	
	public void set(double totalValue)
	{
		txtTotalAccountBalance.setText(Double.toString(totalValue));
	}
	
	public double getValue()
	{
		String amountText = txtTotalAccountBalance.getText();
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		masterTracker.refresh();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
