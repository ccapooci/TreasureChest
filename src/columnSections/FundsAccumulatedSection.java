package columnSections;

import components.UsdFormattedLabel;
import interfaces.GuiComponent;
import parentClasses.SavTrackPanel;
import windows.SavingsTracker;

import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

/*   Currenlty Unused...
 *   Future use is unknown.
 */
public class FundsAccumulatedSection extends SavTrackPanel implements GuiComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsdFormattedLabel amountAddedLabel;
	private double amountAdded;
	private SavingsTracker masterTracker;
	
	/**
	 * Create the panel.
	 */
	public FundsAccumulatedSection(SavingsTracker savTrack,
								   double         addInt) {
		super(savTrack);
		masterTracker = savTrack;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(200, 150);

		JLabel lblInterestAndDeposits = new JLabel("Interest and Deposits Added");
		lblInterestAndDeposits.setAlignmentX(CENTER_ALIGNMENT);
		amountAddedLabel = new UsdFormattedLabel(savTrack);
		amountAddedLabel.setValue(addInt);
		add(lblInterestAndDeposits);
		add(amountAddedLabel);
	}
	
	public double getAmount()
	{
		return amountAdded;
	}
	
	public void refresh()
	{
		
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
