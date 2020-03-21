package components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

import parentClasses.SavTrackPanel;
import windows.SavingsTracker;

/*    DateSelector
 *    Creates a GUI component with 3 combo boxes that create a day. One
 *    combo box for the month, another combo box for the day, and the
 *    last combo box for the year.  
 */
public class DateSelector extends SavTrackPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6065575547071724985L;
	JComboBox<String> monthCb = null;  // holds the months
	JComboBox<String> dateCb = null;   // holds the possible days in associated with the year and month
	JComboBox<String> yearCb = null;   // holds a select number of years
	String monthList[] = {"January", "Februrary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	String yearList[] = {"2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029"};
	String day31List[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	String day30List[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
	String day29List[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"};
	String day28List[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"};
	String month31[] = {"January", "March", "May", "July", "August", "October", "December"};
	String month30[] = {"April", "June", "September", "November"};
	
	/*   Constructor 
	 *   Creates and arranges the components in the Date Selector. Also, instantiates 
	 *   an action method for the modifications of any of the combo boxes.
	 */
	public DateSelector(SavingsTracker savTrack) 
	{
		super(savTrack);
		// the constraints of the components in the selector
		GridBagConstraints gbc = new GridBagConstraints();
		// set the layout
		setLayout(new GridBagLayout());
		
		// create the combo boxes
		monthCb = new JComboBox<String>(monthList);
		dateCb = new JComboBox<String>(day31List);
		yearCb = new JComboBox<String>(yearList);

		// layout the location and characteristics of the 
		// month combo box
		gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    add(monthCb, gbc);
	    
		// layout the location and characteristics of the 
		// date combo box
		gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    add(dateCb, gbc);
	    
		// layout the location and characteristics of the 
		// year combo box
		gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.gridx = 2;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.NONE;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    add(yearCb, gbc);
	    
	    // if the month or year combo boxes are changed
	    // adjust the date combo box
	    monthCb.addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	        	adjustDateComboBox();
	        }
	    });
	    
	    yearCb.addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	        	adjustDateComboBox();
	        }
	    });
	}

	/*   adjustDateComboBox
	 *   Modifies the dates in the date combo box based
	 *   on the current month and year selected.
	 */
	void adjustDateComboBox()
	{
		// get the selected month
		String selectedMonth = monthCb.getSelectedItem().toString();
		// booleans used if the month is February
		boolean set29 = false;
		boolean set28 = false;
		
		// remove all of the items in the date combo box
		dateCb.removeAllItems();
		
		// check through all of the months with 31 days
		for(String mnt : month31)
		{
			// is it one of these months
			if(selectedMonth.equals(mnt))
			{
				// add 31 days to the combo box
				for(String date: day31List)
				{
					dateCb.addItem(date);
				}
			}
		}
		
		// check through all of the months with 30 days
		for(String mnt : month30)
		{
			// is it one of these months
			if(selectedMonth.equals(mnt))
			{
				// add 30 days to the combo box
				for(String date: day30List)
				{
					dateCb.addItem(date);
				}
			}
		}
		
		// if the month is february
		if(selectedMonth.equals("February"))
		{
			// get the year
			int year = Integer.parseInt(yearCb.getSelectedItem().toString());
			
			// find out if the year is a leap year or not
			if(year % 4 == 0)
			{
			   if(year % 100 == 0)
			   {
				   if(year % 400 == 0)
				   {
					   // it is a leap year
					   set29 = true;
				   }
				   else
				   {
					   // it is not a leap year
					   set28 = true;
				   }
			   }
			   else
			   {
				   // it is a leap year
				   set29 = true;
			   }
			}
			else
			{
				// it is not a leap year
				set28 = true;
			}
		}
		
		// if it is not leap year
		if(set28)
		{
			// add 28 days to the combo box
			for(String date: day28List)
			{
				dateCb.addItem(date);
			}
		}
		// if it is not a leap year
		if(set29)
		{
			// add 29 days to the combo box
			for(String date: day29List)
			{
				dateCb.addItem(date);
			}
		}		
	}
	
	/*   getDate
	 *   Returns a value of the date in the format of
	 *   MM-DD-YYYY
	 */
	public String getDate()
	{
		// get the integer values of the month day and year
		int mon = monthCb.getSelectedIndex() + 1;
		int d = (Integer.parseInt((String)dateCb.getSelectedItem()));
		int y = (Integer.parseInt((String)yearCb.getSelectedItem()));
		String sMon;
		String sD;
		
		// add a zero to the month if it is only one digit
		if(mon < 10)
		{
			sMon = "0" + mon;
		}
		else
		{
			sMon = Integer.toString(mon);
		}
		
		// add a zero to the date if it is only one digit
		if(d < 10)
		{
			sD = "0" + d;
		}
		else
		{
			sD = Integer.toString(d);
		}
		
		// return in MM-DD-YYYY format
		return sMon + "-" + sD + "-" + y;
	}

}
