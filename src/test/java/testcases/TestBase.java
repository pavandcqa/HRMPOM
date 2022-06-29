package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pages.DashboardPageObjects;
import pages.LoginPageObjects;
import utility.ConfigReader;

public class TestBase {

	protected static WebDriver driver;
	LoginPageObjects loginPageObject;
	DashboardPageObjects dashboardPageObject;
	ConfigReader reader;

	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void login(String browserOption) {
		
		System.out.println("SetUp Browser");
		
		reader = new ConfigReader();
		
		String projectPath = System.getProperty("user.dir");
		
		if(browserOption.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/BrowserDrivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserOption.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/BrowserDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browserOption.equals("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "/BrowserDrivers/internetexplorerdriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(reader.getImplicitWaitTime(), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(reader.getAppUrl());
		
		loginPageObject = new LoginPageObjects(driver);
		
		Assert.assertTrue(loginPageObject.getUserName().isDisplayed(), "User Name field not present..!");
		loginPageObject.setUserName(reader.getUserName());
		loginPageObject.setPassword(reader.getPassword());
		loginPageObject.clickLoginBtn();
		
		dashboardPageObject = new DashboardPageObjects(driver);

	}

	@AfterMethod(alwaysRun = true)
	public void logout() {
		
		dashboardPageObject.clickWelcomeMenu();
		dashboardPageObject.clickLogout();
		driver.close();
	}
	
}
