package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageObjects {


	@FindBy(tagName = "h1")
	private WebElement pageTitle;

	@FindBy(xpath = "//a[@id=\"welcome\"]")
	private WebElement welcomeMenu;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;

	@FindBy(xpath = "//span[text()='Assign Leave']")
	WebElement assignleave;

	@FindBy(xpath = "//span[text()='Leave List']")
	WebElement leaveList;

	public DashboardPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getPageTitle() {
		return pageTitle;
	}

	public void clickWelcomeMenu() {
		welcomeMenu.click();
	}

	public void clickLogout() {
		logout.click();
	}

	public boolean checkPresenceOfAssignLeave() {
		return assignleave.isDisplayed();
	}
	
	public String getAssignLeave() {

		return assignleave.getText();
	}

	public String getLeavelist() {

		return leaveList.getText();
	}

}
