package Validation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddInWebDltInRestChechInDBTest {
	
	String pName;
	String pId;
	int ran=new Random().nextInt(500);
	@Test(priority = 1)
	public void createInGUI() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8084/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		 pName="p"+ran;
		driver.findElement(By.name("projectName")).sendKeys(pName);
		driver.findElement(By.name("createdBy")).sendKeys("rock");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//td[text()='"+pName+"']"));
		  pId = driver.findElement(By.xpath("//td[text()='p2019']/preceding-sibling::td[1]")).getText();
		
		String expected=pName;
		String actual = ele.getText();
		System.out.println(actual+">>>"+pName);
		Assert.assertEquals(actual, expected);
		
		driver.quit();
	}
	@Test(priority = 2)
	public void deleteInRest()
	{
		baseURI="http://localhost";
		port=8084;
		
		
		
		when()
		  .delete("/projects/"+pId)
		 .then()
		    .assertThat()
		    .statusCode(204);
	}
	@Test(priority = 3)
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
			System.out.println(pName+">>>tc is fail");
			
		}
		else
		{
			System.out.println(pName+">>>tc is pass");
		}
	}

}
