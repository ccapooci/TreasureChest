package barSections;

import barSections.TotalAccountBalanceSection;
import barSections.UnusedBalanceSection;
import interfaces.GuiComponent;
import utilities.Database;
import windows.SavingsTracker;
import barSections.InterestSection;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;


public class AccountInfoBarSection extends JPanel implements MouseListener, GuiComponent{
	private TotalAccountBalanceSection acntBalSect = null;
	private UnusedBalanceSection unusedBalSect = null;
	private InterestSection intSect = null;
	private SavingsTracker masterTracker = null;
	private Database db = null;
	private int dbId = 0;
	private String totBalStr = null;
	private double totBal=0;
	private double intVal = 0;
	private String intValStr = null;
	private String intType = null;
	private final int DEFAULT_INDEX = 1;
	/**
	 * Create the panel.
	 */
	public AccountInfoBarSection(SavingsTracker savingsTracker,
								 Database       data,
								 int            dataId,
								 double         amountUsed) {
		db = data;
		dbId = dataId;
		
		totBalStr = db.queryString("select totbalance from accountinfo where id="+dataId, DEFAULT_INDEX);
		totBal = Double.parseDouble(totBalStr);
		
		intValStr = db.queryString("select intrate from accountinfo where id="+dataId, DEFAULT_INDEX);
        intVal = Double.parseDouble(intValStr);
		
		intType = db.queryString("select inttype from accountinfo where id="+dataId, DEFAULT_INDEX);
		
		// create the sections of the bar
		acntBalSect = new TotalAccountBalanceSection(savingsTracker, totBal);
		unusedBalSect = new UnusedBalanceSection(savingsTracker, totBal-amountUsed);
		intSect = new InterestSection(savingsTracker, intType, intVal);
		
		// add the sections to the bar
		add(acntBalSect);
		add(unusedBalSect);
		add(intSect);
	}
	
	public void refresh()
	{	
		acntBalSect.refresh();
		unusedBalSect.refresh();
		intSect.refresh();
	}
	
	public void saveData() {
		db.update("update accountinfo set inttype = '" + intSect.getIntType() 
				  + "' where id=" + dbId);
		
		// save interest into database
		db.update("update accountinfo set intrate = " + intSect.getInterest() 
				  + " where id=" + dbId);
		
		// save total value into database
		db.update("update accountinfo set totbalance = " + acntBalSect.getTotalAccountValue() 
				  + " where id=" + dbId);
	}
	public void setUsed(double used)
	{
		unusedBalSect.setUnusedBalance(acntBalSect.getTotalAccountValue() - used);
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
