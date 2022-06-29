package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {


	@FindBy(id = "txtUsername")
	private WebElement userNameInputBox;

	@FindBy(name = "txtPassword")
	private WebElement passwordInputBox;

	@FindBy(xpath = "//input[@value=\"LOGIN\"]")
	private WebElement loginBtn;

	public LoginPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserName() {

		return userNameInputBox;
	}

	public boolean verifyUserName() {

		return userNameInputBox.isDisplayed();
	}

	public void setUserName(String uname) {
		userNameInputBox.clear();
		userNameInputBox.sendKeys(uname);
	}

	public WebElement getPassword() {

		return passwordInputBox;
	}

	public boolean verifyPasswordInputbox() {

		return passwordInputBox.isDisplayed();
	}

	public void setPassword(String pwd) {
		passwordInputBox.clear();
		passwordInputBox.sendKeys(pwd);
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}
}
