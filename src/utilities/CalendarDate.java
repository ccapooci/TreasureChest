package utilities;
public class CalendarDate {

	int month = 0;
	int date = 0;
	int year = 0;
	int month31[] = {1, 3, 5, 7, 8, 10, 12};
	int month30[] = {4, 6, 9, 11};

	public CalendarDate(int m, int d, int y)
	{
		if(m >= 1 && m <= 12)
		{
			month = m;
		}
		else
		{
			month = 1;
		}
		
		if(checkDate(m, d, y))
		{
			date = d;
		}		
		
		year = y;
	}
	
	public void add(int value, String occ)
	{
		switch(occ)
		{
		case "Daily":
		{
			for(int i = 0; i < value; i++)
			{
				addOneDay();
			}
			break;
		}
		case "Weekly":
		{
			for(int i = 0; i < value * 7; i++)
			{
				addOneDay();
			}
			break;
		}
		case "Biweekly":
		{
			for(int i = 0; i < value * 14; i++)
			{
				addOneDay();
			}
			break;
		}
		case "Monthly":
		{
			month = month + value;
			
			while(!checkDate(date, month, year))
			{
				date = date - 1;
			}
			break;
		}
		}
	}
	
	private boolean checkDate(int m, int d, int y)
	{
		boolean viable = false;
		
		for(int mnt : month31)
		{
			if(mnt == month)
			{
				if(d > 0 && d <= 31)
				{
					viable = true;
				}
				else
				{
					viable = false;
				}
			}
		}
		for(int mnt : month30)
		{
			if(mnt == month)
			{
				if(d > 0 && d <= 30)
				{
					viable = true;
				}
				else
				{
					viable = false;
				}
			}
		}
		if(m == 2)
		{
			if(y % 4 == 0)
			{
			   if(y % 100 == 0)
			   {
				   if(y % 400 == 0)
				   {
					   if(d > 0 && d <= 29)
					   {
						   viable = true;
					   }
				   }
				   else
				   {
					   if(d > 0 && d <= 28)
					   {
						   viable = true;
					   }
				   }
			   }
			   else
			   {
				   if(d > 0 && d <= 29)
				   {
					   viable = true;
				   }
			   }
			}
			else
			{
				if(d > 0 && d <= 28)
				{
					   viable = true;
				}
			}
		}
				
		return viable;
	}
	
	private void addOneDay()
	{
		date += 1;
		if(!checkDate(date, month, year))
		{
			date = 1;
			month = month + 1;
			if(!(checkDate(date, month, year)))
			{
				month = 1;
				year = year + 1;
			}
		}
	}
	
	private void subOneDay()
	{
		date -= 1;
		if(!checkDate(date, month, year))
		{
			date = 31;
			month = month - 1;
			if(month == 0) 
			{
				month = 12;
				date = 31;
				year = year - 1;
			}
			
			while(!(checkDate(date, month, year)))
			{
				date = date - 1;
			}
		}
	}

	public int howGreater(CalendarDate depDate, String occur) {
		int magnitude =0;
		
		switch(occur) {
		case "One Time":
			magnitude = isGreater(depDate);
			break;
		case "Daily":
			magnitude = howGreaterDaily(depDate);
			break;
		case "Weekly":
			magnitude = howGreaterWeekly(depDate);
			break;
		case "Biweekly":
			magnitude = howGreaterBiweekly(depDate);
			break;
		case "Monthly":
			magnitude = howGreaterMonthly(depDate);
			break;
		default:
			break;
		}
		
		return magnitude;
	}
	
	private int howGreaterMonthly(CalendarDate depDate) {
		int magnitude = 0;
		
		magnitude = (month + (12* (year - depDate.getYear()))) - depDate.getMonth();
				
		if(date >= depDate.getDay())
		{
			magnitude += 1;
		}
		
		if(magnitude < 0)
		{
			magnitude = 0;
		}
		
		return magnitude;
	}

	private int howGreaterBiweekly(CalendarDate depDate) {
		int weekly = 0;
		weekly = howGreaterWeekly(depDate);
				
		// Get truncate the value 
		return weekly/2;
	}

	private int howGreaterWeekly(CalendarDate depDate) {
		int daily = 0;
		daily = howGreaterDaily(depDate);
				
		// Get the number of weeks truncated
		return (daily/7);
	}

	private int howGreaterDaily(CalendarDate depDate) {
		// TODO Auto-generated method stub
		int depY = depDate.getYear();
		int depM = depDate.getMonth();
		int depD = depDate.getDay();
		int savedY = 0;
		int savedD = 0;
		int savedM = 0;
		int greater = 0;
		
		if(year == depY)
		{
			if(month == depM)
			{
				if(date >= depD)
				{
					greater = 1;
				}
				else
				{
					greater = 0;
				}
			}
			else if(month < depM)
			{
				greater = 0;
			}
			else
			{
				greater = 1;
			}
		}
		else if(year < depY)
		{
			greater = 0;
		}
		else
		{
			greater = 1;
		}
		
		if(greater == 1)
		{
			savedD = date;
			savedM = month;
			savedY = year;
			
			while(date != depD || year != depY || month != depM)
			{
				greater++;
				subOneDay();
			}
			
			date = savedD;
			month = savedM;
			year = savedY;
		}
		
		return greater;
	}

	private int isGreater(CalendarDate depDate) {
		int depY = depDate.getYear();
		int depM = depDate.getMonth();
		int depD = depDate.getDay();
		int greater = 0;
		
		if(year == depY)
		{
			if(month == depM)
			{
				if(date >= depD)
				{
					greater = 0;
				}
				else
				{
					greater = 1;
				}
			}
			else if(month < depM)
			{
				greater = 0;
			}
			else
			{
				greater = 1;
			}
		}
		else if(year < depY)
		{
			greater = 0;
		}
		else
		{
			greater = 1;
		}
		
		return greater;
	}

	public int getMonth()
	{
		return month;
	}
	
	public int getDay()
	{
		return date;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String getString()
	{
		String dayStr = null;
		String monthStr = null;
		String yearStr = null;
		
		if(date < 10)
		{
			dayStr = ("0" + date);
		}
		else
		{
			dayStr = Integer.toString(date);
		}
		
		if(month < 10)
		{
			monthStr = ("0" + month);
		}
		else
		{
			monthStr = Integer.toString(month);
		}
		
		yearStr = Integer.toString(year);
		
		return monthStr + "-" + dayStr + "-" + yearStr;
	}
}
