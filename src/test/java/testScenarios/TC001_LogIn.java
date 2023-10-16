package testScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import pages.LogInPage;

public class TC001_LogIn extends BaseClass { 
	
	@Test(priority = 1)
	public void loginFeildValidation() {
		boolean validateElements = new LogInPage().verifyElements();
		Assert.assertTrue(validateElements);
	}
	
	@Test(priority = 2)
	public void loginWithValideCredentials() throws Exception {
		boolean validateLogin = new LogInPage()
		.enterUserName("userdanaan")
		.enterpassword("Kity@1517")
		.clickSubmit()
		.iAgreeButton()
		.validateLogin()
		.logout()
		.verifyElements();
		Assert.assertTrue(validateLogin);
	}
	
	@Test(priority = 3)
	public void loginWithInvalideCredentials() {
		boolean verifyInvalidLoginToHomePage = new LogInPage()
		.enterUserName("userdanaan")
		.enterpassword("Testing")
		.clickSubmit()
		.iAgreeButtonInvalid()
		.verifyElements();
		Assert.assertTrue(verifyInvalidLoginToHomePage);
	}

}
