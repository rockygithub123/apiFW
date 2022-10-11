package EndToEndcsenariosUsingUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointsLibrary;
import GenericUtility.WebDriverUtility;
import ObjectRepository.AppDashBoard;
import ObjectRepository.HomepageClass;
import static io.restassured.RestAssured.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class AddInGuiDeleteInRestVAlidateInDB extends BaseClass {
	//create a project in GUI
	@Test
	public void validationTest() throws SQLException
	{   
		//to launch the browser
		wLib.browserLauch();
		WebDriver driver=wLib.driver;

		//login to application
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		HomepageClass hp=new HomepageClass(driver);
		hp.defaultLogin();

		//create a project using default method
		AppDashBoard ab=new AppDashBoard(driver);
		String pName = ab.defaultProjectCreation();
		//Get project name and validate 
		String actual=pName;
		String pId = ab.projectId(driver,pName);
		//delete project using rest
		rLib.preConditions();
		when()
		.delete(EndPointsLibrary.deleteProject+pId);
		//validate in database
		String query="select * from project where project_name='"+pName+"'";   

		String result = dLib.readDataFromDBAndBValidate(query, 2, pName);
		System.out.println(result);



	}





}
