package components;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DateSelector extends JPanel {
	JComboBox monthCb = null;
	JComboBox dateCb = null;
	JComboBox yearCb = null;
	String monthList[] = {"January", "Februrary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	String yearList[] = {"2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029"};
	String day31List[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	String day30List[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
	String day29List[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"};
	String day28List[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"};
	String month31[] = {"January", "March", "May", "July", "August", "October", "December"};
	String month30[] = {"April", "June", "September", "November"};
	/**
	 * Create the panel.
	 */
	public DateSelector() 
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		monthCb = new JComboBox<String>(monthList);
		dateCb = new JComboBox<String>(day31List);
		yearCb = new JComboBox<String>(yearList);

		gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.NONE;//GridBagConstraints.HORIZONTAL;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    add(monthCb, gbc);
	    
		gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.NONE;//GridBagConstraints.HORIZONTAL;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    add(dateCb, gbc);
	    
		gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.gridx = 2;
	    gbc.gridy = 0;
	    gbc.fill = GridBagConstraints.NONE;//GridBagConstraints.HORIZONTAL;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    add(yearCb, gbc);
	    
	    monthCb.addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	        	adjustDateComboBox();
	        }
	    });
	}

	void adjustDateComboBox()
	{
		String selectedMonth = monthCb.getSelectedItem().toString();
		boolean set29 = false;
		boolean set28 = false;
		dateCb.removeAllItems();
		for(String mnt : month31)
		{
			if(selectedMonth.equals(mnt))
			{
				for(String date: day31List)
				{
					dateCb.addItem(date);
				}
			}
		}
		for(String mnt : month30)
		{
			if(selectedMonth.equals(mnt))
			{
				for(String date: day30List)
				{
					dateCb.addItem(date);
				}
			}
		}
		if(selectedMonth.equals("February"))
		{
			int year = Integer.parseInt(yearCb.getSelectedItem().toString());
			if(year % 4 == 0)
			{
			   if(year % 100 == 0)
			   {
				   if(year % 400 == 0)
				   {
					   set29 = true;
				   }
				   else
				   {
					   set28 = true;;
				   }
			   }
			   else
			   {
				   set29 = true;
			   }
			}
			else
			{
				set28 = true;
			}
		}
		if(set28)
		{
			for(String date: day28List)
			{
				dateCb.addItem(date);
			}
		}
		if(set29)
		{
			for(String date: day29List)
			{
				dateCb.addItem(date);
			}
		}		
	}
	
	public String getDate()
	{
		int mon = monthCb.getSelectedIndex() + 1;
		int d = (Integer.parseInt((String)dateCb.getSelectedItem()));
		int y = (Integer.parseInt((String)yearCb.getSelectedItem()));
		String sMon;
		String sD;
		if(mon < 10)
		{
			sMon = "0" + mon;
		}
		else
		{
			sMon = Integer.toString(mon);
		}
		
		if(d < 10)
		{
			sD = "0" + d;
		}
		else
		{
			sD = Integer.toString(d);
		}
		
		return sMon + "-" + sD + "-" + y;
	}
	
}
