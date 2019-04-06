package columnSections;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import interfaces.GuiComponent;
import windows.SavingsTracker;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Header extends JPanel implements MouseListener, GuiComponent {
	private JTextField textField;
	private SavingsTracker masterTracker;
		
	/**
	 * Create the panel.
	 */
	public Header(SavingsTracker savTrack,
				  String         name) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(200, 150);
		
		masterTracker = savTrack;
		
		JLabel lblItem = new JLabel("Item");
		lblItem.setAlignmentX(CENTER_ALIGNMENT);
		add(lblItem);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		textField.setText(name);

	}

	public String getItemName()
	{
		return textField.getText();
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
