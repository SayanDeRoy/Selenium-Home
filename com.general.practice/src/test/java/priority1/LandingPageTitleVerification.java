package priority1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Base;
import pageObjectClasses.BSEMainPO;

@Test(groups={"Smoke"})
public class LandingPageTitleVerification {
	
	WebDriver driver;
	BSEMainPO bmp;
	Base base = new Base();
	String expectedTitle = "BSE Ltd. (Bombay Stock Exchange)";
	
	@BeforeClass
	public void initializeBrowser()
	{
		driver = base.openBrowser();
		base.openURL("stockUrl");
	}
	@Test
	public void landingPageTitleVerification()
	{
		bmp = new BSEMainPO(driver);
		String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}
	@AfterClass
	public void closeBrowser()
	{
		base.closeBrowser();
		driver = null;
	}
}
