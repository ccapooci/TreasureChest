package bars;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import barSections.AccountInfoBarSection;
import interfaces.GuiComponent;
import utilities.Database;
import windows.SavingsTracker;

public class OverviewBar extends JPanel implements MouseListener, GuiComponent {
	private AccountInfoBarSection acntInfoBarSect = null;
	private SavingsTracker masterTracker = null;
	/**
	 * Create the panel.
	 */
	public OverviewBar(SavingsTracker savingsTracker,
					   Database       db,
					   int            dbId,
					   double         amountUsed) 
	{
		acntInfoBarSect = new AccountInfoBarSection(savingsTracker, db, dbId, amountUsed);
		add(acntInfoBarSect);
	}

	public void saveData()
	{
		acntInfoBarSect.saveData();
	}
	
	public void refresh() {
		// TODO Auto-generated method stub
		acntInfoBarSect.refresh();
	}
	
	public void setUsed(double used)
	{
		acntInfoBarSect.setUsed(used);
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
