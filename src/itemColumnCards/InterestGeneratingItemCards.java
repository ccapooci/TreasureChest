package itemColumnCards;

import java.awt.Dimension;
import java.awt.GridLayout;
import columnSections.Header;
import utilities.Database;
import windows.SavingsTracker;
import columnSections.FundsAccumulatedSection;
import columnSections.DepositSection;

public class InterestGeneratingItemCards extends ItemColumnCard {
	DepositSection depSect;
	FundsAccumulatedSection faSect;
	SavingsTracker masterTracker;
	Database db = null;
	Header h = null;
	private final int DEFAULT_INDEX = 1;
	private int dataIndex = 0;
	/**
	 * Create the panel.
	 */
	public InterestGeneratingItemCards(SavingsTracker savTrack,
									   Database       data,
									   int            dbId) {
		super(savTrack);
		String name = "";
		double initDep = 0;
		double addInt = 0;
		db = data;
		dataIndex = dbId;
		setLayout(new GridLayout(3, 1, 0, 0));
		setSize(250, 500);
		Dimension dim = new Dimension();
		dim.setSize(250, 500);
		setMaximumSize(dim);
		setMinimumSize(dim);
		
		name = db.queryString("SELECT NAME FROM INTCOLUMNS where id=" + dbId, DEFAULT_INDEX);
		initDep = Double.parseDouble(db.queryString("SELECT initvalue FROM INTCOLUMNS where id=" + dbId, DEFAULT_INDEX));
		
		addInt = Double.parseDouble(db.queryString("SELECT addint FROM INTCOLUMNS where id=" + dbId, DEFAULT_INDEX));
		
		h = new Header(savTrack, name);
		add(h);
				
		depSect = new DepositSection(savTrack, initDep);
		add(depSect);
		
		faSect = new FundsAccumulatedSection(savTrack, addInt);
		add(faSect);
	}

	public void refresh()
	{
		depSect.refresh();
		faSect.refresh();
	}

	@Override
	public String getItemName() {
		return h.getItemName();
	}

	public double getInitAmount()
	{
		return depSect.getAmount();
	}
	
	@Override
	public double getIntAmount() {
		return faSect.getAmount();
	}

	@Override
	public double getTotalAmount() {
		// TODO Auto-generated method stub
		return faSect.getAmount() + depSect.getAmount();
	}

	public void saveData()
	{
		// update with the current item name
		db.update("update intcolumns set name='" + h.getItemName() + "' where id=" + dataIndex);
		// update with the current item name
		db.update("update intcolumns set initvalue=" + depSect.getAmount() + " where id=" + dataIndex);
		// update with the current interest added to the initial value
		db.update("update intcolumns set addint=" + faSect.getAmount() + " where id=" + dataIndex);
	}

	
}
