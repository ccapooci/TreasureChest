package components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import windows.SavingsTracker;

public class UsdFormattedLabel extends JPanel implements MouseListener {
	private JLabel dollarValue;
	private JLabel dollarSign;
	private SavingsTracker masterTracker;

	/**
	 * Create the panel.
	 */
	public UsdFormattedLabel(SavingsTracker savTracker) {
		masterTracker = savTracker;
		
		dollarSign = new JLabel();
		dollarSign.setText("$");
		add(dollarSign);
		
		// create the formatted text field
		dollarValue = new JLabel();
		dollarValue.setText("0.00");
		add(dollarValue);
	}
	
	public void setValue(double valueToSet)
	{
		double decimal = valueToSet - (long)(valueToSet);
		double tenths = decimal - (long)decimal;
		// see if there is decimal
		// if not then put two zeros at the end
		if(decimal == 0)
		{
			dollarValue.setText(Double.toString(valueToSet) + "0");
		}
		if(tenths == 0)
		{
			dollarValue.setText(Double.toString(valueToSet) + "0");
		}
		else
		{
			dollarValue.setText(Double.toString(valueToSet));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		masterTracker.refresh();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
