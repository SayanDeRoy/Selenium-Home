package library;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Listeners implements ITestListener{
	
	ExtentReports report = new ExtentReports(".\\test-output\\ExtentReports.html");
	ExtentTest logger;
	
	@Override
	public void onTestStart(ITestResult result) {
		logger = report.startTest("Test "+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.log(LogStatus.PASS, result.getName()+" Passed");
		report.endTest(logger);
		report.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String screenShotPath = Base.getScreenShot(result.getTestClass().getName()+"_"+result.getName());
		String image = logger.addScreenCapture(screenShotPath);
		logger.log(LogStatus.FAIL, result.getName()+" Failed", image);
		report.endTest(logger);
		report.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

}
