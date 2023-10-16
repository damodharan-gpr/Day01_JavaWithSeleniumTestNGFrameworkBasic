package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseClass;

public class HomePage extends BaseClass{
	
	private By welcomeText = By.xpath("//div/h3[contains(text(),'Welcome')]");
	private By logOut = By.xpath("//li/a[text()= 'Logout']");
	
	public boolean verifyElementsInHomePage() {
		if (driver.findElement(welcomeText).isDisplayed() &&
				driver.findElement(logOut).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public HomePage validateLogin() throws Exception {
		Thread.sleep(3000);
		 WebElement validate = driver.findElement(welcomeText); 
		 String text = validate.getText();
		 String replaceText = text.replaceAll("[^a-zA-Z0-9]", "");
		 System.out.println(replaceText);
		 if (replaceText.equalsIgnoreCase("Welcome")) {
			 System.out.println("User Logged In to Correct Page");
		}else {
			System.out.println("User Logged In to Incorrect Page");
		}
		 return this;
	  }
	
	public LogInPage logout() {
		  driver.findElement(logOut).click();
		  System.out.println("User Logged Out Successfully");
		  return new LogInPage();
	  }
}
