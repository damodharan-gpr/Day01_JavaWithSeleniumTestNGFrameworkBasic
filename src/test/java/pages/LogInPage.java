package pages;

import org.openqa.selenium.By;

import Base.BaseClass;

public class LogInPage extends BaseClass {
	
	private By userName = By.id("username");
	private By passWord = By.id("password");
	private By submitButton = By.xpath("//button[text() = 'Sign In']");
	private By iAgreeButton = By.xpath("//button[contains(text(),'I agree to the Privacy Policy')]");
	private By getStartButton = By.xpath("//button/strong");
	
	public boolean verifyElements() {
		if (driver.findElement(userName).isDisplayed() &&
				driver.findElement(passWord).isDisplayed() &&
				driver.findElement(submitButton).isDisplayed() &&
				driver.findElement(getStartButton).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public LogInPage enterUserName(String name) {
		driver.findElement(userName).sendKeys(name);
		return this;
	}
	
	public LogInPage enterpassword(String password) {
		driver.findElement(passWord).sendKeys(password);
		return this;
	}
	
	public LogInPage clickSubmit() {
		driver.findElement(submitButton).click();
		return this;
	}
	
	public HomePage iAgreeButton() {
		driver.findElement(iAgreeButton).click();
		return new HomePage();
	}
	
	public LogInPage iAgreeButtonInvalid() {
		driver.findElement(iAgreeButton).click();
		return this;
	}
}
