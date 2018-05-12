package priority3;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import library.Base;
import pageObjectClasses.BSEMainPO;
import pageObjectClasses.ResultCalendarPO;
import pageObjectClasses.StockPricePO;

public class VerifyActualSecurityCode {
	
	WebDriver driver;
	Base base = new Base();
	ResultCalendarPO rcp;
	String expectedSecurityCode = "532953";
	
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
	public void clickOnSecurityCodeOnResultCalendarPage()
	{
		rcp = new ResultCalendarPO(driver);
		String resultCalendarPageTitle = driver.getTitle();
		Assert.assertEquals(resultCalendarPageTitle, rcp.expectedTitle);
		rcp.getResultDateAndClick(532953);
	}
	@Test(dependsOnMethods = {"clickOnSecurityCodeOnResultCalendarPage"})
	public void verifySecurityCode()
	{
		StockPricePO spp = new StockPricePO(driver);
		base.switchToChild();
		
		String actualSecurityCode = spp.getSecurityCode();
		Assert.assertEquals(actualSecurityCode, expectedSecurityCode);
		
		spp.storeStockDetailsInExcel(1);
	}
	@AfterClass
	public void closeBrowser()
	{
		base.closeBrowser();
	}
}
