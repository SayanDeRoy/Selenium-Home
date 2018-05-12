package priority2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.Base;
import pageObjectClasses.BSEMainPO;
import pageObjectClasses.ResultCalendarPO;

public class VerifyNoMatchFoundInvalidSecurityName {
	
	WebDriver driver;
	Base base = new Base();
	String invalidSecurityName = "invalid";
	
	@BeforeClass
	public void initializeBrowser()
	{
		driver = base.openBrowser();
		base.openURL("stockUrl");
	}
	@Test
	public void performLandingPageActivity()
	{
		BSEMainPO bsp = new BSEMainPO(driver);
		String landingPageTitle = driver.getTitle();
		Assert.assertEquals(landingPageTitle, bsp.expectedTitle);
		
		bsp.clickOnMainLink("Corporates");
		bsp.clickOnsubLink("Result Calendar");
	}
	@Test(dependsOnMethods = {"performLandingPageActivity"})
	public void verifyNoMatchFound() throws InterruptedException
	{
		ResultCalendarPO rcp = new ResultCalendarPO(driver);
		String resultCalendarPageTitle = driver.getTitle();
		Assert.assertEquals(resultCalendarPageTitle, rcp.expectedTitle);
		
		String actualText = rcp.enterSecurityNameAndSelect(invalidSecurityName, "");
		Assert.assertEquals(actualText, "No Match found");
	}
	@AfterClass
	public void closeBrowser()
	{
		base.closeBrowser();
	}
}
