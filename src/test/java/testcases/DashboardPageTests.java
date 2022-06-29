package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Groups;

public class DashboardPageTests extends TestBase{

	
	@Test(groups = {Groups.DASHBOARD, Groups.SMOKE})
	public void verifyAssignLeave() {
		
		Assert.assertTrue(dashboardPageObject.checkPresenceOfAssignLeave(), "Dashboard Page not available");
		System.out.println("=> Verify Assign leave");
		Assert.assertTrue(dashboardPageObject.getAssignLeave().equals("Assign Leave"), "Assing Leave section not present");
		System.out.println("=> Verified Assign leave");

	}

	@Test(groups = {Groups.DASHBOARD, Groups.SMOKE})
	public void verifyLeaveList() {

		System.out.println("=> Verify leave list ");
		Assert.assertTrue(dashboardPageObject.getLeavelist().equals("Leave List"), "Leave List section not present");
		System.out.println("=> Verified leave list ");
	}
}
