package components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import components.UsdFormattedTextField;
import parentClasses.SavTrackPanel;
import windows.SavingsTracker;

/*  LabelUsdText
 *  A JLabel/JTextbox combo.  The textbox is formatted for United States dollars. 
 *  The string for the JLabel is displayed to the left of the JTextbox.
 */
public class LabelUsdText extends SavTrackPanel {
	private UsdFormattedTextField text = null;  // The USD formatted text field
	private JLabel label = null;                // The label placed to the left of the textbox
	private SavingsTracker savTrack = null;     // The highest level component
	
	/*  Constructor
	 *  Create all of the components. Then arranges them on the panel.
	 */
	public LabelUsdText(SavingsTracker savings,
			            String         labelString) {
		super(savings);
		// local variables
		GridBagLayout gridBagLayout = new GridBagLayout();  // layout of the column
		GridBagConstraints gbc = new GridBagConstraints();  // constraints of the layout
		
		// save/create the class variables
		text = new UsdFormattedTextField(savings);
		savTrack = savings;
		label = new JLabel(labelString);

		// set the layout
		setLayout(gridBagLayout);
		
		// put the label on the left
	    gbc.gridheight = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    add(label, gbc);
	    
	    // put the text box on the right
	    gbc.gridheight = 1;
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    add(text, gbc);
	}

	/*   setLabel
	 *   Set the string in the textbox to a new value.
	 *   	labelStr: The new string to be shown in the textbox
	 */
	public void setLabel(String labelStr)
	{
		label.setText(labelStr);
	}
	
	/*    getValue
	 *    Returns the value in the textbox.
	 *    
	 *     returns:
	 *     double: the value in the textbox
	 */
	public double getValue()
	{
		return text.getValue();
	}
	
	public void refresh()
	{
		text.refresh();
	}
}
