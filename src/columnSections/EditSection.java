package columnSections;

import interfaces.GuiComponent;
import parentClasses.SavTrackPanel;
import windows.SavingsTracker;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;

/*    EditSection
 *    NOT USED and probably OBE. 
 * 
 */
public class EditSection extends SavTrackPanel implements MouseListener, GuiComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = -523317939936562257L;
	private JComboBox<String> columnTypeComboBox;
	private JButton btnSetEditButton;
	private SavingsTracker masterTracker;
	
	/**
	 * Create the panel.
	 */
	public EditSection(String[] comboBoxItems, SavingsTracker savTrack) {
		super(savTrack);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(200, 150);

		masterTracker = savTrack;
		
		columnTypeComboBox = new JComboBox<String>(comboBoxItems);
		add(columnTypeComboBox);
		
		btnSetEditButton = new JButton("Set");
		btnSetEditButton.setAlignmentX(CENTER_ALIGNMENT);
		add(btnSetEditButton);

	}

	public JComboBox<String> getColTypeComboBox()
	{
		return columnTypeComboBox;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
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
