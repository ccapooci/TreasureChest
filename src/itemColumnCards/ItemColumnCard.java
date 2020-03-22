package itemColumnCards;

import java.awt.event.MouseListener;

import interfaces.GuiComponent;
import parentClasses.SavTrackPanel;
import windows.SavingsTracker;

public abstract class ItemColumnCard extends SavTrackPanel implements GuiComponent {
	/**
	 * Create the panel.
	 */
	public ItemColumnCard(SavingsTracker savTrack) {
		super(savTrack);
	}

	public abstract String getItemName();
	public abstract double getInitAmount();
	public abstract double getIntAmount();
	public abstract double getTotalAmount();
	public abstract void saveData();
	public abstract void addToItem(double value);

	public void refresh()
	{
		return;
	}
}
