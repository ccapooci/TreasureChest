package itemColumns;

import interfaces.GuiComponent;
import parentClasses.SavTrackPanel;
import windows.SavingsTracker;

public abstract class ItemColumn extends SavTrackPanel implements GuiComponent{
	/**
	 * Create the panel.
	 */
	public ItemColumn(SavingsTracker savTrack) {
		super(savTrack);
	}

	
	public abstract void saveData();
	
	public abstract void addToItem(double value);
	
	public void refresh()
	{
		
	}


	public double getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}


}
