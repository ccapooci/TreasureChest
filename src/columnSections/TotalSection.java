package columnSections;

import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import interfaces.GuiComponent;
import windows.SavingsTracker;

public class TotalSection extends JPanel implements GuiComponent, MouseListener{
	SavingsTracker masterTracker;
	/**
	 * Create the panel.
	 */
	public TotalSection(SavingsTracker savTrack) {
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

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

}
