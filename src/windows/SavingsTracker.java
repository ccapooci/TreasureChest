package windows;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridBagConstraints;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import java.awt.GridBagLayout;
import bars.OverviewBar;
import depositSections.CreateDepositSection;
import depositSections.DepositTable;
import interfaces.GuiComponent;
import itemColumns.ItemColumn;
import itemColumns.PercentageItemColumn;
import parentClasses.SavTrackPanel;
import threads.RefreshThread;
import utilities.Database;

public class SavingsTracker implements GuiComponent {
	private JLabel debugLabel;
	private JFrame frame;
	private static ItemColumn[] itemColumns;
	private static OverviewBar ovrvwBar;
	private static int numCols;
	private static Database db = null;
	private final int ACCNT_INFO_DB_ID = 1;
	private SavTrackPanel itemPanel = null;
	private SavTrackPanel depositPanel = null;
	private JTabbedPane tabPane = null;
	private CreateDepositSection depSection = null;
	private DepositTable table = null;
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
							// TODO Auto-generated method stub
							int i = 0;
							
							for(i = 0; i < numCols; i++) 
							{
								itemColumns[i].saveData();
							}
							ovrvwBar.saveData();
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
		createItemTab();
		createDepositTab();
	}

	private void createItemTab()
	{
		GridBagConstraints gbc = new GridBagConstraints();
		double amountUsed = 0;
		
		numCols = 6;
		
		debugLabel = new JLabel();
		gbc.gridy = 5;
		itemPanel.add(debugLabel, gbc);
		debugLabel.setText("Debug Info");

		itemColumns = new ItemColumn[numCols];
		itemColumns[0] = new PercentageItemColumn(this, db, 1);
		itemColumns[1] = new PercentageItemColumn(this, db, 2);
		itemColumns[2] = new PercentageItemColumn(this, db, 3);
		itemColumns[3] = new PercentageItemColumn(this, db, 4);
		itemColumns[4] = new PercentageItemColumn(this, db, 5);
		itemColumns[5] = new PercentageItemColumn(this, db, 6);

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
			itemPanel.add(column, gbc);
		}	
		
		ovrvwBar = new OverviewBar(this, db, ACCNT_INFO_DB_ID, amountUsed);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = 6;
		gbc.weightx = 0.5;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.SOUTH;
		itemPanel.add(ovrvwBar, gbc);
		
	}
	
	private void createDepositTab()
	{
		depositPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		depSection = new CreateDepositSection(this);
		table = new DepositTable(this, db);
		
		// create the layout of the pieces on this panel
        // then ask for the name of the deposit
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.weighty = 0.5;
        depositPanel.add(depSection, gbc);
		
     // create the layout of the pieces on this panel
        // then ask for the name of the deposit
        gbc.gridheight = 1;
        gbc.gridwidth = 5;
        gbc.gridx = 7;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;
        gbc.weighty = 0.5;
        depositPanel.add(table, gbc);
		
	}
	
	private void initializeInterface()
	{
		tabPane = new JTabbedPane();
		itemPanel = new SavTrackPanel(new GridBagLayout());
		depositPanel = new SavTrackPanel(new GridBagLayout()); 
		
		createTabs();
		tabPane.addTab("Item List", itemPanel);
		tabPane.addTab("Deposits", depositPanel);
		
		
		frame.add(tabPane);
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
		depSection.refresh();
	}

	public void addDeposit(String   depName,
			               double   totDep,
						   double[] itemDep,
						   int      numItems,
						   String   duration,
						   String   nextOcc) 
	{
		table.addDeposit(depName, totDep, itemDep, numItems, duration, nextOcc);
	}
	
	public void addToItems(double totalAdd, double[] items, int numItems)
	{
//		double valueUsed = 0;
//		for(int i = 0; i < numItems; i++)
//		{
//			itemColumns[i].addToItem(items[i]);
//			valueUsed += items[i];
//		}
		
		ovrvwBar.addFunds(totalAdd);
	}
	
}
