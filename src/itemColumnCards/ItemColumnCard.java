package itemColumnCards;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import interfaces.GuiComponent;
import windows.SavingsTracker;

public abstract class ItemColumnCard extends JPanel implements MouseListener, GuiComponent {
	SavingsTracker masterTracker;
	/**
	 * Create the panel.
	 */
	public ItemColumnCard(SavingsTracker savTrack) {
		masterTracker = savTrack;
	}

	public abstract String getItemName();
	public abstract double getInitAmount();
	public abstract double getIntAmount();
	public abstract double getTotalAmount();
	public abstract void saveData();

	public void refresh()
	{
		return;
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
