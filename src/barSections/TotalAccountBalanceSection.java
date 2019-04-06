package barSections;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import components.UsdFormattedTextField;
import interfaces.GuiComponent;
import windows.SavingsTracker;

public class TotalAccountBalanceSection extends JPanel implements GuiComponent, MouseListener{
	private UsdFormattedTextField txtTotalAccountBalance;
	private double totalAccountValue;
	private JLabel lblTotal;
	private SavingsTracker masterTracker;
	/**
	 * Create the panel.
	 */
	public TotalAccountBalanceSection(SavingsTracker savTrack,
									  double         totalBalance) {

		masterTracker = savTrack;
		
		// set the layout to box layout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Indicate the account balance field with a label
		lblTotal = new JLabel("Total Account Balance");
		lblTotal.setAlignmentX(LEFT_ALIGNMENT);
		add(lblTotal);
		
		txtTotalAccountBalance = new UsdFormattedTextField(savTrack);
		txtTotalAccountBalance.set(totalBalance);
		add(txtTotalAccountBalance);
		
		// account value starts at zero
		totalAccountValue = 0;
	}

	public double getTotalAccountValue()
	{
		return txtTotalAccountBalance.getValue();
	}
	
	public void setTotalAccountValue()
	{
		totalAccountValue = 0;
		txtTotalAccountBalance.set(totalAccountValue);
	}
	

	public void refresh() {
		// TODO Auto-generated method stub
		txtTotalAccountBalance.refresh();
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
