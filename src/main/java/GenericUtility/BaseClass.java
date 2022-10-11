package GenericUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * 
 * @author GOWTHAM
 *
 */

public class BaseClass {
	public DataBaseUtlity dLib=new DataBaseUtlity();
	public JavaUtility jLib=new JavaUtility();
	public RestLibrary rLib=new RestLibrary();
	public WebDriverUtility wLib=new WebDriverUtility();
	public Spec_Builder_api sLib=new Spec_Builder_api();
	
	/**
	 * this method will connect to database
	 * @throws SQLException
	 */
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		dLib.connectToDB();
	}
	/**
	 * this method will close the database connection
	 * @throws SQLException 
	 */
	@AfterSuite
	public void asConfig() throws SQLException
	{
		dLib.closeDB();
		wLib.driver.close();
		
	}
	

}
