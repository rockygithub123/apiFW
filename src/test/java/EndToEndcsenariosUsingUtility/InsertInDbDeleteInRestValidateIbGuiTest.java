package EndToEndcsenariosUsingUtility;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.DataBaseUtlity;
import GenericUtility.EndPointsLibrary;
import GenericUtility.JavaUtility;
import ObjectRepository.AppDashBoard;
import ObjectRepository.HomepageClass;

import static  io.restassured.RestAssured.*;

public class InsertInDbDeleteInRestValidateIbGuiTest extends BaseClass {
	@Test
	public void validationTest() throws SQLException {
	//add project in database
	String pId="ty_proj_00"+jLib.randomNumber();
	String query="insert into project values('"+pId+"','rock','15/09/2022','p222','Active',30);";
    dLib.con.createStatement().executeUpdate(query);
    //delete using api
    rLib.preConditions();
    when().delete(EndPointsLibrary.deleteProject+pId);
    //check in GUI
     wLib.browserLauch();
     WebDriver driver = wLib.driver;
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    HomepageClass hp=new HomepageClass(driver);
    hp.defaultLogin();
    AppDashBoard ap=new AppDashBoard(driver);
    WebElement ele = ap.getProjectsBtn();
    WebDriverWait wb=new WebDriverWait(driver, 20);
    wb.until(ExpectedConditions.elementToBeClickable(ele));
    
  //  ap.getCreateProjectsBtn().click();
    try{driver.findElement(By.xpath("//td[contains(.,'"+pId+"')]")).getText();
    }
    catch (Exception e) {
		// TODO: handle exception
    	System.out.println("verified");
	}
    }
    // ap.projectValidate(driver, pId);
    
    
    
    
	


}
