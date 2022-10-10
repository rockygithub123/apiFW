package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;
/**
 * This library consists of database connection
 * @author Rakesh
 *
 */

public class DataBaseUtlity {
	
	Connection con;
	Driver driref;
	
	/**
	 * This method will connect to database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		
		try{ driref=new Driver();
		DriverManager.registerDriver(driref);
		Connection con = DriverManager.getConnection(Iconstants.jdbc_Path,Iconstants.db_UserName,Iconstants.db_Password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void closeDB() throws SQLException
	{
		con.close();
	}
	public String readDataFromDBAndBValidate(String query,int columnIndex,String expData) throws SQLException
	{
		boolean flag=false;
		  ResultSet result = con.createStatement().executeQuery(query);
		  while(result.next())
		  {
			  if(result.getString(columnIndex).equalsIgnoreCase(expData))
			  {
				  flag=true;
				  break;
			  }
		  }
		  if(flag)
		  {
			  System.out.println("verified");
			  return expData;
		  }
		  else
		  {
			  System.out.println("data is not present");
			  return " ";
		  }
		
	
		
		
	}

}
