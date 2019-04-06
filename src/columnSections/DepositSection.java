package columnSections;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import components.UsdFormattedTextField;
import interfaces.GuiComponent;
import windows.SavingsTracker;

public class DepositSection extends JPanel implements MouseListener, GuiComponent{
	private UsdFormattedTextField txtDeposit;
	private SavingsTracker masterTracker;
	/**
	 * Create the panel.
	 */
	public DepositSection(SavingsTracker savTrack,
					      Double         initValue) {
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		masterTracker = savTrack;
        // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
    	
		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setAlignmentX(CENTER_ALIGNMENT);
		add(lblDeposit, gbc);
		
	    // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
   		
		txtDeposit = new UsdFormattedTextField(savTrack);
		txtDeposit.setAlignmentX(CENTER_ALIGNMENT);
		add(txtDeposit, gbc);
		txtDeposit.set(initValue);
	}

	public double getAmount()
	{
		return txtDeposit.getValue();
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
