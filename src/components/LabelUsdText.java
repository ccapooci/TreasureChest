package components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import components.UsdFormattedTextField;
import windows.SavingsTracker;

public class LabelUsdText extends JPanel {
	private UsdFormattedTextField text = null;
	private JLabel label = null;
	private SavingsTracker savTrack = null;
	/**
	 * Create the panel.
	 */
	public LabelUsdText(SavingsTracker savings,
			            String         labelString) {
		text = new UsdFormattedTextField(savings);
		savTrack = savings;
		label = new JLabel(labelString);
		
		GridBagLayout gridBagLayout = new GridBagLayout();  // layout of the column
		GridBagConstraints gbc = new GridBagConstraints();  // constraints of the layout
		setLayout(gridBagLayout);
		
	    gbc.gridheight = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.NONE;//GridBagConstraints.HORIZONTAL;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    add(label, gbc);
	    
	    gbc.gridheight = 1;
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.NONE;//GridBagConstraints.HORIZONTAL;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    add(text, gbc);
	}

	public void setLabel(String labelStr)
	{
		label.setText(labelStr);
	}
	
	public double getValue()
	{
		return text.getValue();
	}
	
}
