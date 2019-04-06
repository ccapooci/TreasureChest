package barSections;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.UsdFormattedLabel;
import interfaces.GuiComponent;
import windows.SavingsTracker;

public class UnusedBalanceSection extends JPanel implements GuiComponent, MouseListener {
	private UsdFormattedLabel unusedAccountBalance;
	private double unusedBalance;
	private SavingsTracker masterTracker;
	/**
	 * Create the panel.
	 */
	public UnusedBalanceSection(SavingsTracker tracker,
								double         unusedBal) {
		unusedBalance = unusedBal;
		masterTracker = tracker;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblTotal = new JLabel("Unused Amount");
		lblTotal.setAlignmentX(LEFT_ALIGNMENT);
		add(lblTotal);
		
		unusedAccountBalance = new UsdFormattedLabel(tracker);
		unusedAccountBalance.setValue(unusedBalance);
		add(unusedAccountBalance);
		
	}

	public void setUnusedBalance(double unusedBal)
	{
		unusedBalance = unusedBal;
		unusedAccountBalance.setValue(unusedBalance);
	}
	
	public void refresh()
	{
		unusedAccountBalance.setValue(unusedBalance);
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
