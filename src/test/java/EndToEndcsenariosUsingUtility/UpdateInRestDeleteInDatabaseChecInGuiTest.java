package EndToEndcsenariosUsingUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.EndPointsLibrary;
import ObjectRepository.HomepageClass;
import PojoClassGenericUtility.AddProjectPojoClass;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class UpdateInRestDeleteInDatabaseChecInGuiTest extends BaseClass {
	@Test
	public void validationTest()
	{
		//update in rest
		String pID="TY_PROJ_009";
		
		String pName="prj2022";
		AddProjectPojoClass pj=new AddProjectPojoClass("rock", pName, "active", 10);
		rLib.preConditions();
		given()
		
		.body(pj)
		.when()
		 .put(EndPointsLibrary.updateProject+pID)
		 .then().extract().response();
		// to delete in database
		String query="delete project_id from project where project_id='"+pID+"';";
		//to validate in front end
		wLib.browserLauch();		WebDriver driver = wLib.driver;
		HomepageClass hp=new HomepageClass(driver);
		//project validation
		try { driver.findElement(By.xpath("//td[contains(.,'"+pID+"')]")).getText();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
