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

public class VerifyActualSecurityName {
	
	WebDriver driver;
	Base base = new Base();
	ResultCalendarPO rcp;
	String expectedSecurityName = "VENLONENT";
	
	@BeforeClass
	public void initializeBrowser()
	{
		driver = base.openBrowser();
		base.openURL("stockUrl");
	}
	@Test(priority = 0)
	public void performLandingPageActivity()
	{
		BSEMainPO bsp = new BSEMainPO(driver);
		String landingPageTitle = driver.getTitle();
		Assert.assertEquals(landingPageTitle, bsp.expectedTitle);
		
		bsp.clickOnMainLink("Corporates");
		bsp.clickOnsubLink("Result Calendar");
	}
	@Test(dependsOnMethods = {"performLandingPageActivity"})
	public void clickOnSecurityCodeOnResultCalendarPage() throws InterruptedException
	{
		rcp = new ResultCalendarPO(driver);
		String resultCalendarPageTitle = driver.getTitle();
		Assert.assertEquals(resultCalendarPageTitle, rcp.expectedTitle);
		rcp.enterSecurityCodeAndSelect(524038, expectedSecurityName);
		rcp.getResultDateAndClick(524038);
	}
	@Test(dependsOnMethods = {"clickOnSecurityCodeOnResultCalendarPage"})
	public void verifySecurityName()
	{
		StockPricePO spp = new StockPricePO(driver);
		base.switchToChild();
		
		String actualSecurityName = spp.getSecurityName();
		
		Assert.assertEquals(actualSecurityName, expectedSecurityName);
		
		spp.storeStockDetailsInExcel(2);
	}
	@AfterClass
	public void closeBrowser()
	{
		base.closeBrowser();
	}
}
