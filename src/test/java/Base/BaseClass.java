package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public static WebDriver driver;
	public int browser = 1;
	public String url = "https://uibank.uipath.com/";
	
  @BeforeClass
  public void invokeBrowser() {
	  switch (browser) {
	case 1:
		driver = new ChromeDriver();
		System.out.println("Invoking Chrome Browser");
		break;
		
	case 2:
		driver = new EdgeDriver();
		System.out.println("Invoking Edge Browser");
		break;
		
	case 3:
		driver = new FirefoxDriver();
		System.out.println("Invoking Firefox Browser");
		break;

	default:
		System.out.println("Due to invalid Selection Invoking Chrome Browser");
		break;
	}
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  
	  driver.navigate().to(url);
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }
  
  @AfterClass
  public void closeBrowser() {
	  driver.quit();
  }

}
