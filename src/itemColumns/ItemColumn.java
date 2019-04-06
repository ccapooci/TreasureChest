package itemColumns;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import interfaces.GuiComponent;
import windows.SavingsTracker;

public abstract class ItemColumn extends JPanel implements MouseListener, GuiComponent{
	SavingsTracker masterTracker = null;
	/**
	 * Create the panel.
	 */
	public ItemColumn(SavingsTracker savTrack) {
		masterTracker = savTrack;
	}

	
	public abstract void saveData();
	
	public void refresh()
	{
		
	}


	public double getAmount() {
		// TODO Auto-generated method stub
		return 0;
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
