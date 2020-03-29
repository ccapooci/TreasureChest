package tabs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import depositSections.CreateDepositSection;
import parentClasses.SavTrackPanel;
import windows.SavingsTracker;

public class CreateDepositTab extends SavTrackPanel
{
	private CreateDepositSection depSection = null;
	
	public CreateDepositTab(SavingsTracker savTrack)
	{
		super(savTrack, new GridBagLayout());
		initializeCreateDepositTab();
	}
	
	private void initializeCreateDepositTab()
	{
		GridBagConstraints gbc = new GridBagConstraints();
		depSection = new CreateDepositSection(this.savsTrack, this);

		
		// create the layout of the pieces on this panel
	    // then ask for the name of the deposit
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.weightx = 0;
	    gbc.weighty = 0.5;
	    this.add(depSection, gbc);
	}

	public void refresh()
	{
		depSection.refresh();
	}
}