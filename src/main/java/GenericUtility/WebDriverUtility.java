package GenericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * this class will consists of all web driver utility
 * @author GOWTHAM
 *
 */

public class WebDriverUtility {
	public WebDriver driver;
	
	
	/**
	 * this method will launch the browser
	 * 
	 */
	
	public void browserLauch()
	{
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		 driver.get("http://localhost:8084/");
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
