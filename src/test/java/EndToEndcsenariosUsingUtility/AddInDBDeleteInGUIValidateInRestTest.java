package EndToEndcsenariosUsingUtility;

import static io.restassured.RestAssured.when;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointsLibrary;
import ObjectRepository.AppDashBoard;
import ObjectRepository.HomepageClass;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

public class AddInDBDeleteInGUIValidateInRestTest extends BaseClass {
	@Test
	public void validationTest() throws SQLException, InterruptedException
	{

		//add project in database
		String pId="TY_PROJ_00"+jLib.randomNumber();
		System.out.println(pId);
		String query="insert into project values('"+pId+"','rock','15/09/2022','p222','Active',30)";
		dLib.con.createStatement().executeUpdate(query);
		//delete in gui
		wLib.browserLauch();
		WebDriver driver = wLib.driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		HomepageClass hp=new HomepageClass(driver);
		hp.defaultLogin();
		AppDashBoard ap=new AppDashBoard(driver);
		WebElement ele = ap.getProjectsBtn();
		ele.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[text()='"+pId+"']/following-sibling::td[6]/a[@class='delete']")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//p[contains(.,'Are you sure you want to delete ')]")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		
		//validate in rest
		rLib.preConditions();
		Response resp = when()
		  .get(EndPointsLibrary.getSingleProject+pId);
		String actual=resp.getStatusLine();
		System.out.println(actual);
		
		  String expected="HTTP/1.1 500 ";
		  Assert.assertEquals(expected, actual);




		

	}


}
