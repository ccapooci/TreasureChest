package columnSections;


import javax.swing.BoxLayout;
import javax.swing.JLabel;

import interfaces.GuiComponent;
import parentClasses.SavTrackPanel;
import windows.SavingsTracker;

/*    TotalSection
 *    Currently not in use
 */
public class TotalSection extends SavTrackPanel implements GuiComponent{
	SavingsTracker masterTracker;
	/**
	 * Create the panel.
	 */
	public TotalSection(SavingsTracker savTrack) {
		super(savTrack);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(200, 150);

		masterTracker = savTrack;
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setAlignmentX(CENTER_ALIGNMENT);
		add(lblTotal);
		
		JLabel lblTotalSaved = new JLabel("$0.00");
		lblTotal.setAlignmentX(CENTER_ALIGNMENT);
		add(lblTotalSaved);

	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

}
