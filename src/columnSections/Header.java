package columnSections;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import interfaces.GuiComponent;
import parentClasses.SavTrackPanel;
import windows.SavingsTracker;

/*   Header 
 *   Holds the information that is located at the top of the
 *   item columns such as the name.
 */
public class Header extends SavTrackPanel implements GuiComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1286909155078222090L;
	private JTextField textField;  // holds the name of the item.
		
	/*   Constructor
	 *   Creates and arranges the components that make up the Header
	 *   	savTrack:  The top level component of the entire application
	 *   	name:      The initial value for the name.
	 */		
	public Header(SavingsTracker savTrack,
				  String         name) {
		super(savTrack);
		
		// labels the item columns as Items
		JLabel lblItem = new JLabel("Item");

		// set the layout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// alignment the label
		lblItem.setAlignmentX(CENTER_ALIGNMENT);
		add(lblItem);
		
		// add the text field and set the passed name
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		textField.setText(name);

	}

	/*    getItemName
	 *    Returns a string value of the name of the item.
	 */
	public String getItemName()
	{
		return textField.getText();
	}
	
	/*   refresh
	 *   Ensure the UI is updated to the most current values
	 */
	public void refresh() {
		// TODO
	}
}
