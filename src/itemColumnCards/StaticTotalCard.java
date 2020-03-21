package itemColumnCards;

import java.awt.GridLayout;
import columnSections.DepositSection;
import columnSections.Header;
import parentClasses.SavTrackPanel;
import utilities.Database;
import windows.SavingsTracker;

import java.awt.Dimension;

public class StaticTotalCard extends ItemColumnCard {
	private DepositSection depSection = null;
	private Header header =null;
	private Database db = null;
	private int dataIndex = 0;
	private final int DEF_INDEX = 1;
	/**
	 * Create the panel.
	 */
	public StaticTotalCard(SavingsTracker savTrack,
						   Database       data,
						   int            dbId) {
		super(savTrack);
		double initDep = 0;
		String name = "";
		db = data;
		dataIndex = dbId;
		
		name = db.queryString("select name from staticcolumns where id=" + dbId, DEF_INDEX);
		initDep = Double.parseDouble(db.queryString("select value from staticcolumns where id=" + dbId, DEF_INDEX));
		
		// panel numbers lowest numbers are at the top
		SavTrackPanel panel2 = new SavTrackPanel(savTrack);
		header = new Header(savTrack, name);
		depSection = new DepositSection(savTrack, initDep);
		Dimension dim = new Dimension();

		// 
		setLayout(new GridLayout(3, 1, 0, 0));
		setSize(250, 500);
		dim.setSize(250, 500);
		setMinimumSize(dim);
		setMaximumSize(dim);
		
		add(header);
		
		add(depSection);
		
		add(panel2);
		
	}

	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return header.getItemName();
	}

	@Override
	public double getInitAmount() {
		// TODO Auto-generated method stub
		return depSection.getAmount();
	}

	@Override
	public double getIntAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotalAmount() {
		// TODO Auto-generated method stub
		return depSection.getAmount();
	}
	
	public void saveData()
	{
		// update with the current item name
		db.update("update staticcolumns set name='" + header.getItemName() + "' where id=" + dataIndex);
		// update with the current item name
		db.update("update staticcolumns set value=" + depSection.getAmount() + " where id=" + dataIndex);
	}

	@Override
	public void addToItem(double value) {
		// TODO Auto-generated method stub
		depSection.addValue(value);
	}
}
