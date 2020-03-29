package windows;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import java.awt.GridBagLayout;
import bars.OverviewBar;
import interfaces.GuiComponent;
import itemColumns.ItemColumn;
import itemColumns.PercentageItemColumn;
import parentClasses.SavTrackPanel;
import threads.RefreshThread;
import utilities.Database;
import tabs.CreateDepositTab;
import tabs.DepositTableTab;
import tabs.ItemTab;

public class SavingsTracker implements GuiComponent {
	private JFrame frame;
	private static Database db = null;
	private static ItemTab itemTab = null;
	private JTabbedPane tabPane = null;
	private static DepositTableTab depTableTab = null;
	private static CreateDepositTab createDepTab = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		db = new Database();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SavingsTracker window = new SavingsTracker();
					window.frame.setVisible(true);
					
					window.frame.addWindowListener(new WindowAdapter()
					{    
						public void windowClosing(WindowEvent e)
					    {
							itemTab.saveData();
					    }
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public SavingsTracker(){
		/*long tempId = 0;
		System.out.println(Long.toString(tempId));
		tempId = Long.parseLong(db.queryString("SELECT NUMDEP FROM DEPOSITSINFO WHERE ID=0", 1));
		System.out.println(Long.toString(tempId));
		tempId = Long.parseLong(db.queryString("SELECT ID FROM DEPOSITS", 1));
		System.out.println(Long.toString(tempId));
		tempId = Long.parseLong(db.queryString("SELECT ID FROM DEPOSITS", 1));
		System.out.println(Long.toString(tempId));
		tempId = Long.parseLong(db.queryString("SELECT ID FROM DEPOSITS", 1));
		System.out.println(Long.toString(tempId));
		tempId = Long.parseLong(db.queryString("SELECT ID FROM DEPOSITS", 1));
		System.out.println(Long.toString(tempId));
			*/	
		initialize();
		initializeInterface();
		RefreshThread refreshThread = new RefreshThread(this);
		refreshThread.start();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());
	}

	private void createTabs()
	{
		itemTab      = new ItemTab(this, db);
		depTableTab  = new DepositTableTab(this, db);
		createDepTab = new CreateDepositTab(this);
	}

	
	
	private void initializeInterface()
	{
		tabPane = new JTabbedPane();
		
		createTabs();
		tabPane.addTab("Item List", itemTab);
		tabPane.addTab("Current Deposits", depTableTab);
		tabPane.addTab("Create New Deposit", createDepTab);
		
		frame.add(tabPane);
	}

	public void refresh() {
		itemTab.refresh();
		depTableTab.refresh();
		createDepTab.refresh();
	}

	
	public void addToItems(double[] items, int numItems)
	{
		itemTab.addFunds(items,numItems);
	}

	public void addDeposit(String text, double value, double[] itDeps, int i, String selectedItem, String date) 
	{
		depTableTab.addDeposit(text, value, itDeps, i , selectedItem, date);	
	}
	
}
