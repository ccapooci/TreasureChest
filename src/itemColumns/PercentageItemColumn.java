package itemColumns;

import javax.swing.JComboBox;
import java.awt.CardLayout;
import itemColumnCards.InterestGeneratingItemCards;
import itemColumnCards.ItemColumnCard;
import itemColumnCards.StaticTotalCard;
import parentClasses.SavTrackPanel;

import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.GridBagConstraints;

import windows.SavingsTracker;
import utilities.Database;

public class PercentageItemColumn extends ItemColumn implements ItemListener {
	private SavTrackPanel cards;
	private JComboBox<String> colTypeComboBox;
	private ItemColumnCard[] itemLayouts;
	private int currentItem;
	private int key;
	private final int DB_COL_INDEX = 1;
	private static Database db = null;
	String[] comboBoxStrings = null;
	
	public enum CardTypes{
		NORMAL (0),
		STATIC (1);
		
		private final int value; // index into array
		CardTypes(int value){
			this.value = value;
		}
		
		public int value() {return value;}
	};
	/**
	 * Create the panel.
	 */
	public PercentageItemColumn(SavingsTracker savingsTrack, 
								Database       data,
								int            primaryKey) {
		super(savingsTrack);
		// local variables
		GridBagLayout gridBagLayout = new GridBagLayout();  // layout of the column
		GridBagConstraints gbc = new GridBagConstraints();  // constraints of the layout
        String currentCard = "";
        
        key = primaryKey;
        
		comboBoxStrings = new String[2];
		comboBoxStrings[CardTypes.NORMAL.value()] = "Normal";  // the strings used for the combo box
		comboBoxStrings[CardTypes.STATIC.value()] = "Static";
        //EditSection edit = new EditSection(comboBoxStrings, savingsTrack); // the edit section of the column

        db = data;
        //colTypeComboBox = edit.getColTypeComboBox(); // get the combo box from the edit section
        
		setLayout(gridBagLayout);
		
		// we are going to add a card layout
		// two column cards (static card and interest gen card)
		itemLayouts = new ItemColumnCard[2];
		itemLayouts[CardTypes.NORMAL.value()] = new InterestGeneratingItemCards(savingsTrack,db,primaryKey);
		itemLayouts[CardTypes.STATIC.value()] = new StaticTotalCard(savingsTrack,db,primaryKey);
		
		currentCard = db.queryString("SELECT STATE FROM ITEMCOLUMNS WHERE ID=" + key, DB_COL_INDEX);
		
		
		 //Create the panel that contains the "cards".
        cards = new SavTrackPanel(new CardLayout());
        cards.add(itemLayouts[CardTypes.NORMAL.value()], comboBoxStrings[CardTypes.NORMAL.value()]);
        cards.add(itemLayouts[CardTypes.STATIC.value()], comboBoxStrings[CardTypes.STATIC.value()]);
        
        // show the correct card depending on the sql results
        /*
        if(currentCard.equals("NORMAL"))
        {
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, comboBoxStrings[CardTypes.NORMAL.value()]);
            colTypeComboBox.setSelectedIndex(CardTypes.NORMAL.value());
            currentItem = CardTypes.NORMAL.value();

        }
        else
        {
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.show(cards, comboBoxStrings[CardTypes.STATIC.value()]);
            colTypeComboBox.setSelectedIndex(CardTypes.STATIC.value());
            currentItem = CardTypes.STATIC.value();
        }
        */
        
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, "Static");
        currentItem = CardTypes.STATIC.value();
        
        // create the layout of the pieces on this panel
        // top panel containing the cards
        gbc.gridheight = 3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(cards, gbc);
        
        
        // the edit section
        /*
        colTypeComboBox.addItemListener(this);
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        add(edit, gbc);
        */
	}

	public void itemStateChanged(ItemEvent evt) {
		String compString = (String)evt.getItem();
		
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, compString);
        currentItem = colTypeComboBox.getSelectedIndex();
	}

	public double getAmount()
	{
		return itemLayouts[currentItem].getTotalAmount();
	}
	
	public void saveData()
	{
		String sqlStatement = null;

        // find out which card is now being displayed
        if( CardTypes.NORMAL.value() == currentItem )
        {
        	sqlStatement = "UPDATE itemcolumns SET STATE = 'NORMAL' WHERE ID=" + key;
        }        
        else
        {
        	sqlStatement = "UPDATE itemcolumns SET STATE = 'STATIC' WHERE ID=" + key;
        }
        // update the database
     	db.update(sqlStatement);
     	
		itemLayouts[currentItem].saveData();
	}

	@Override
	public void addToItem(double value) {
		// TODO Auto-generated method stub
		itemLayouts[currentItem].addToItem(value);
	}
	
}
