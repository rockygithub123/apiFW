package EndToEndcsenariosUsingUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.DataBaseUtlity;
import GenericUtility.EndPointsLibrary;
import ObjectRepository.AppDashBoard;
import ObjectRepository.HomepageClass;

import static  io.restassured.RestAssured.*;

public class InsertInDbDeleteInRestValidateIbGuiTest extends BaseClass {
	@Test
	public void validationTest() throws SQLException {
	//add project in database
	String pId="ty_proj_00";
	String query="insert into project values('+pid+','rock','15/09/2022','p222','Active',30)";
    dLib.con.createStatement().executeUpdate(query);
    //delete using api
    rLib.preConditions();
    when().delete(EndPointsLibrary.deleteProject+pId);
    //check in GUI
     wLib.browserLauch();
     WebDriver driver = wLib.driver;
    HomepageClass hp=new HomepageClass(driver);
    hp.defaultLogin();
    AppDashBoard ap=new AppDashBoard(driver);
    ap.getCreateProjectsBtn().click();
    String result = ap.projectValidate(driver, pId);
    System.out.println(result);
    
    
    
	


}}
