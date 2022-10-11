package ObjectRepository;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class HomepageClass {
	public HomepageClass(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="usernmae")
	
	private WebElement userName;
	@FindBy(id="inputPassword")
	private WebElement password;
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement lgnButton;
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLgnButton() {
		return lgnButton;
	}
	public void defaultLogin()
	{
		
		userName.sendKeys("rmgyantra");
		password.sendKeys("rmgy@9999");
		lgnButton.click();
	}
	

}
