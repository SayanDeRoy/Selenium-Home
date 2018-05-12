package priority1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectClasses.BSEMainPO;
import library.Base;

public class VerifyMultipleQuickLinksTitle {
	
	Base base = new Base();
	WebDriver driver;
	BSEMainPO bmp;
	List<String> actualTitles = new ArrayList<>();
	List<String> expectedTitles = new ArrayList<>();
	
	@BeforeClass
	public void initializeBrowser()
	{
		driver = base.openBrowser();
	}
	@Test(dataProvider = "GetData")
	public void storeMultipleQuickLinksTitle(String quickLinks)
	{
		base.openURL("stockUrl");
		bmp = new BSEMainPO(driver);
		bmp.clickOnquickLink(quickLinks);
		actualTitles.add(driver.getTitle());
	}
	@Test(dependsOnMethods = "storeMultipleQuickLinksTitle")
	public void verifyMultipleQuickLinksTitle()
	{
		expectedTitles.add("Get Stock Quotes");
		expectedTitles.add("Spider Chart Demo");
		expectedTitles.add("Trading Holidays");
		
		for(int i = 0; i<expectedTitles.size(); i++)
		{
			Assert.assertTrue(actualTitles.get(i).contains(expectedTitles.get(i)));
		}
		
	}
	@AfterClass
	public void closeBrowser()
	{
		base.closeBrowser();
	}
	@DataProvider(name = "GetData")
	public Object[] getData()
	{
		Object[] quickLinks = {"Get Quote", "Charting", "Trading Holidays"};
		return quickLinks;
	}
}
