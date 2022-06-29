package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Groups;

public class LoginPageTests extends TestBase{
	
	@Test(groups = {Groups.SMOKE})
	public void Admin_Login_VerifyLoginWithValidCredentials() {
		
		Assert.assertTrue(dashboardPageObject.getPageTitle().getText().equals("Dashboard"), "Login Not successful!");
		Assert.assertTrue(false);
	}

}
