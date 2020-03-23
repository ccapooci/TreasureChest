package parentClasses;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import windows.SavingsTracker;

public class SavTrackPanel extends JPanel {
	protected SavingsTracker savsTrack = null;
	
	
	public SavTrackPanel(SavingsTracker savTrack) {
		savsTrack = savTrack;
	}

	public SavTrackPanel(SavingsTracker savTrack, GridBagLayout gridBagLayout) {
		super(gridBagLayout);
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


}
