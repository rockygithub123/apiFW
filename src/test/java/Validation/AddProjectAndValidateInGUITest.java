package Validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;

public class AddProjectAndValidateInGUITest {
	String pName;
	@Test
	public void createProjectAndValidate()
	{
		
		int ran=new Random().nextInt(500);
		JSONObject js=new JSONObject();
		js.put("createdBy", "rock");
		 pName="rock50"+ran;
		 js.put("projectName",pName );
		js.put("status", "active");
		js.put("teamSize", 10);
		baseURI="http://localhost";
		port=8084;
		given()
		  .body(js)
		  .contentType(ContentType.JSON)
		.when()
		  .post("/addProject")
		 .then()
		    .statusCode(201);
		
		
	}
	@Test
	public void valiDationInGUI() throws InterruptedException
	{
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8084/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	System.out.println(pName);
	Thread.sleep(5000);
	WebElement ele = driver.findElement(By.xpath("//td[text()='"+pName+"']"));
	String expected=pName;
	String actual = ele.getText();
	System.out.println(actual+">>>"+pName);
	Assert.assertEquals(actual, expected);
	driver.quit();
	}
	@Test
	public void validatiionInDataBase() throws SQLException
	{
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = con.createStatement();
		String query="select * from project where project_name='"+pName+"'";   
		ResultSet result = statement.executeQuery(query);
		
		boolean flag=false;
		while(result.next())
		{
			if(result.getString(2).equals(pName))
			{
				flag=true;
			}
		}
		if(flag)
		{
			System.out.println(pName+">>>tc is pass");
			
		}
		else
		{
			System.out.println(pName+">>>tc is fail");
		}
	}
	

}
