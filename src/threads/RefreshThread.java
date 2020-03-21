package threads;

import windows.SavingsTracker;

public class RefreshThread extends Thread {

	SavingsTracker savingsTracker = null;
	
	public RefreshThread(SavingsTracker savTrack)
	{
		this.savingsTracker = savTrack;
	}
	
	public void run()
	{
		while (true)
		{
			this.savingsTracker.refresh();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
