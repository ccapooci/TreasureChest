package barSections;

import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import interfaces.GuiComponent;
import windows.SavingsTracker;

public class InterestSection extends JPanel implements GuiComponent, MouseListener{
	private JTextField txtEnterInterestRate;
	private SavingsTracker masterTracker;
	private JRadioButton[] buttons;
	private final int NUM_BUTTONS = 2;
	private final int APY = 0;
	private final int APR = 1;
	ButtonGroup interestBtnGrp = null;
	/**
	 * Create the panel.
	 */
	public InterestSection(SavingsTracker track,
						   String         intType,
						   double         intRate) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		buttons = new JRadioButton[NUM_BUTTONS];
		buttons[APY] = new JRadioButton("APY"); 
		buttons[APR] = new JRadioButton("APR");

		interestBtnGrp = new ButtonGroup();
		interestBtnGrp.add(buttons[APY]);
		interestBtnGrp.add(buttons[APR]);
		buttons[APY].setAlignmentX(CENTER_ALIGNMENT);
		buttons[APR].setAlignmentX(CENTER_ALIGNMENT);
		
		add(buttons[APY]);
		add(buttons[APR]);
		
		if(intType.equals("APR"))
		{
			buttons[APR].setSelected(true);
		}
		else
		{
			buttons[APY].setSelected(true);
		}
		
		txtEnterInterestRate = new JTextField();
		txtEnterInterestRate.setText(Double.toString(intRate));
		add(txtEnterInterestRate);
		txtEnterInterestRate.setColumns(10);	

	}
	
	public String getIntType()
	{
		String returnStr= "";
		int index = 0;
		boolean found = false;
		for(index = 0; index < NUM_BUTTONS && !found; index++)
		{
			if(buttons[index].isSelected())
			{
				found = true;
			}
		}
		// take into account the increment that occurs once more after finding the 
		// index
		index--;
		
		if(index == APR)
		{
			returnStr = "APR";
		}
		else
		{
			returnStr = "APY";
		}
		
		return returnStr;
	}
	
	public double getInterest()
	{
		String amountText = txtEnterInterestRate.getText();
		double amountReturn = 0;
		
		if(amountText != "")
		{
			String numbers[] = amountText.split(",");
			String valueNoCommas = "";
			
		
		
			for(String val : numbers)
			{
				valueNoCommas = valueNoCommas + val;
			}
			
			try
			{
				amountReturn = Double.parseDouble(valueNoCommas);
			}
			catch(Exception e)
			{
				System.out.println("Could not parse " + valueNoCommas);
				amountReturn = 0;
			}
		}
		
		return amountReturn;

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
