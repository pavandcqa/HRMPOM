package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testcases.TestBase;

public class TestNGListener extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + "==> Test Execution Stared");
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println(result.getName() + "==> Test Case PASSED");
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println(result.getName() + "==> Test Case FAILED");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("Screenshots", result.getName() + ".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println(result.getName() + "==> Test Case SKIPPED");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("==> Test Case Execution Started");
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("==> Test Case Execution Finished");
		
	}

}
