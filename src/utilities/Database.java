package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private static Connection conn = null;
	final String JBDC_URL = "jdbc:derby:/db/SavingsTrackerDb;";
	
	private static ResultSet executeQuery(String query)
	{
		Statement sql = null;
		ResultSet result = null;
		try {
			sql = conn.createStatement();
			result = sql.executeQuery(query);
			result.next();
			
			System.out.println("executed: " + query);
		} catch (SQLException e) {
			System.out.println("Query " + query + " failed.");
			e.printStackTrace();
			// TODO Auto-generated catch block
		}

		return result;
	}
	
	public Database()
	{
		// use the connection to create the sql statement
		// call execute on the statement to execute the sql statement
		try
		{
            //Get a connection
			conn = DriverManager.getConnection(JBDC_URL);
						
			// this is how you check to make sure connection happened
			if(conn != null)
			{
				System.out.println("The connection did open");
			}
		}catch (Exception e)
		{
			System.out.println("The connection did not open");
			e.printStackTrace();
		}

	}
	
	public String queryString(String query, int colIndex)
	{
		String output = null;
		ResultSet result = null;
		// query the db to find which card should be showing
		result = executeQuery(query);
		
		if(result != null)
		{
		// extract the data in a usable format
			try {
				output = result.getString(colIndex);
			} catch (SQLException e) {
				System.out.println("Query \"" + query + "\" failed.");
				System.out.println(e.getStackTrace());
				// TODO Auto-generated catch block
			}
		}
		System.out.println("received: " + output);
		return output;
	}
	
	public void query(String query)
	{
		executeQuery(query);
	}
	
	public void update(String query)
	{
		Statement sql = null;
;
		try {
			sql = conn.createStatement();
			sql.executeUpdate(query);
			System.out.println("executed: "+ query);
		} catch (SQLException e) {
			System.out.println("Query " + query + " failed.");
			e.printStackTrace();
			// TODO Auto-generated catch block
		}
	}
}
