package tabs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import bars.OverviewBar;
import itemColumns.ItemColumn;
import itemColumns.PercentageItemColumn;
import parentClasses.SavTrackPanel;
import utilities.Database;
import windows.SavingsTracker;

public class ItemTab extends SavTrackPanel
{
	private JLabel debugLabel;
	private static int numCols;
	private static ItemColumn[] itemColumns;
	private static OverviewBar ovrvwBar;
	private final int ACCNT_INFO_DB_ID = 1;
	private static Database db = null;
	
	public ItemTab(SavingsTracker savTrack, Database db) {
		super(savTrack, new GridBagLayout());
		this.db = db;
		createItemTab();
	}
	
	private void createItemTab()
	{
		GridBagConstraints gbc = new GridBagConstraints();
		double amountUsed = 0;
		
		numCols = 6;
		
		debugLabel = new JLabel();
		gbc.gridy = 5;
		this.add(debugLabel, gbc);
		debugLabel.setText("Debug Info");

		itemColumns = new ItemColumn[numCols];
		itemColumns[0] = new PercentageItemColumn(this.savsTrack, db, 1);
		itemColumns[1] = new PercentageItemColumn(this.savsTrack, db, 2);
		itemColumns[2] = new PercentageItemColumn(this.savsTrack, db, 3);
		itemColumns[3] = new PercentageItemColumn(this.savsTrack, db, 4);
		itemColumns[4] = new PercentageItemColumn(this.savsTrack, db, 5);
		itemColumns[5] = new PercentageItemColumn(this.savsTrack, db, 6);

		int gridx = 0;
		for(ItemColumn column : itemColumns)
		{
			amountUsed += column.getAmount();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridheight = 4;
			gbc.gridwidth = 1;
			gbc.gridx = gridx;
			gbc.gridy = 0;
			gridx++;
			gbc.weightx = 0.5;
			gbc.weighty = 0.9;
			this.add(column, gbc);
		}	
		
		
		ovrvwBar = new OverviewBar(this.savsTrack, db, ACCNT_INFO_DB_ID, amountUsed);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = 6;
		gbc.weightx = 0.5;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.SOUTH;
		this.add(ovrvwBar, gbc);
		
	}

	public void saveData() {
		int i = 0;
		
		for(i = 0; i < numCols; i++) 
		{
			itemColumns[i].saveData();
		}
		ovrvwBar.saveData();
	}

	public void refresh() {
		double amountUsed = 0;
		for(ItemColumn column : itemColumns)
		{
			amountUsed += column.getAmount();
			column.refresh();
		}
		ovrvwBar.setUsed(amountUsed);
		ovrvwBar.refresh();
	}

	public void addFunds(double[] itemDeps, int numItems) {
		// TODO Auto-generated method stub
		for(int i = 0; i < numItems; i++)
		{
			itemColumns[i].addToItem(itemDeps[i]);
			ovrvwBar.addFunds(itemDeps[i]);
		}
		
	}

	
}