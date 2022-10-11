package EndToEndcsenariosUsingUtility;

import GenericUtility.BaseClass;
import GenericUtility.EndPointsLibrary;
import ObjectRepository.AppDashBoard;
import ObjectRepository.HomepageClass;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.gson.annotations.Until;

public class GetInRestUpdateInGuiValidateInDBTest extends BaseClass {
	@Test
	public void validationTest() throws SQLException, InterruptedException
	{
		//get from rest
		rLib.preConditions();
		Response resp = when()
				.get(EndPointsLibrary.getAllProjects);
		String pId = resp.jsonPath().get("[5].projectId");
		String pName = resp.jsonPath().get("[5].projectName");
		String created = resp.jsonPath().get("[5].createdBy");
		System.out.println(pId);

		//edit in GUI
		wLib.browserLauch();
		WebDriver driver = wLib.driver;
		HomepageClass hp=new HomepageClass(driver);
		hp.defaultLogin();
		AppDashBoard ad=new AppDashBoard(driver);
		WebDriverWait wb=new WebDriverWait(driver, 20);
		wb.until(ExpectedConditions.visibilityOf(ad.getProjectsBtn()));
		ad.getProjectsBtn().click();
		driver.findElement(By.xpath("//td[text()='"+pId+"']/following-sibling::td[6]/a[@class='edit']")).click();

		String newPname="project100";
		String newcreated="john"+jLib.randomNumber();
		driver.findElement(By.xpath("//input[@value='"+pName+"']"));
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//input[@value='"+created+"']"));
		ele.clear();
		ele.sendKeys(newcreated);
		
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		String query="select * from project where project_id='"+pId+"';";
		
		dLib.readDataFromDBAndBValidate(query, 2, newcreated);
	}

}
