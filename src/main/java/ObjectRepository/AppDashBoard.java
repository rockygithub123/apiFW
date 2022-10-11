
package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.xml.LaunchSuite.ExistingSuite;

import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;

public class AppDashBoard {
	public AppDashBoard(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	@FindBy(xpath = "//a[text()='Projects']")
	private WebElement ProjectsBtn;
	@FindBy(xpath = "//span[text()='Create Project']")
	private WebElement createProjectsBtn;
	@FindBy(name = "projectName")
	private WebElement projectsNameTextField;
	@FindBy(name = "createdBy")
	private WebElement createdByTextField;
	@FindBy(xpath = "//input[@class='btn btn-success']")
	private WebElement projectSubmitBtn;
	public WebElement getProjectsBtn() {
		return ProjectsBtn;
	}
	public WebElement getCreateProjectsBtn() {
		return createProjectsBtn;	}
	public WebElement getProjectsNameTextField() {
		return projectsNameTextField;
	}
	public WebElement getCreatedByTextField() {
		return createdByTextField;
	}
	public WebElement getProjectSubmitBtn() {
		return projectSubmitBtn;
	}
	public String defaultProjectCreation()
	{   
		JavaUtility jLib=new JavaUtility();
		int ran = jLib.randomNumber();
		String pName="P-2022"+ran;
		ProjectsBtn.click();
		createProjectsBtn.click();
		projectsNameTextField.sendKeys(pName);
		createdByTextField.sendKeys("rock");
		projectSubmitBtn.click();
		return pName;
		
	}
	public String projectId(WebDriver driver, String projectName)
	
	{
	WebElement pId = driver.findElement(By.xpath("//td[text()='"+projectName+"']/preceding-sibling::td[1]"));
		String projectId = pId.getText();
	return projectId;
	}
	public void projectValidate(WebDriver driver,String projectID)
	{
		try{
			 driver.findElement(By.xpath("//td[contains(.,'"+projectID+"')]")).getText();
				
			System.out.println( "not deleted and vaidation fail");
		
		}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("verified and data not present");
		
	}
		
	}
	
	
	
	//driver.findElement(By.xpath("//a[text()='Projects']")).click();
	//driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	// pName="p"+ran;
	//driver.findElement(By.name("projectName")).sendKeys(pName);
	//driver.findElement(By.name("createdBy")).sendKeys("rock");
	//driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
	//Thread.sleep(5000);
	//WebElement ele = driver.findElement(By.xpath("//td[text()='"+pName+"']"));
	//  pId = driver.findElement(By.xpath("//td[text()='p2019']/preceding-sibling::td[1]")).getText();

}
