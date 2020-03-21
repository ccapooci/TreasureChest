package parentClasses;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import windows.SavingsTracker;

public class SavTrackPanel extends JPanel implements MouseListener{
	SavingsTracker savsTrack = null;
	
	public SavTrackPanel(SavingsTracker savTrack) {
		savsTrack = savTrack;
	}

	public SavTrackPanel(CardLayout cardLayout) {
		// TODO Auto-generated constructor stub
		super(cardLayout);
	}

	public SavTrackPanel(GridBagLayout gridBagLayout) {
		// TODO Auto-generated constructor stub
		super(gridBagLayout);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		savsTrack.refresh();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		savsTrack.refresh();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		savsTrack.refresh();
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
