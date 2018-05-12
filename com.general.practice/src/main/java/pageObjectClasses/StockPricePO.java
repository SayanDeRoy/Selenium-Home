package pageObjectClasses;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.Base;


public class StockPricePO extends Base{
	
	private WebDriver driver;
	
//---------------------------------Constructor-------------------------------//	
	public StockPricePO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
//-------------------------------End of Constructor--------------------------//
	
//-----------------------------WebElements Declaration-----------------------//
	
	@FindBy(xpath = "//strong[text() = 'Security ID']//following::td[2]")
	WebElement securityName;
	
	@FindBy(xpath = "//strong[text() = 'Security Code']//following::td[2]")
	WebElement securityCode;
	
	@FindBy(xpath = "//div[@id='divStremer']//child::td[1]")
	WebElement stockValue;
	
//-----------------------------WebElements Declaration-----------------------//
	/**
	 * 
	 * @return
	 */
	public String getSecurityCode()
	{
		WebDriverWait wt = new WebDriverWait(this.driver, 5);
		wt.until(ExpectedConditions.visibilityOf(securityCode));
		return securityCode.getText();
	}
	/**
	 * 
	 * @return
	 */
	public String getSecurityName()
	{
		WebDriverWait wt = new WebDriverWait(this.driver, 5);
		wt.until(ExpectedConditions.visibilityOf(securityName));
		return securityName.getText();
	}
	/**
	 * 
	 * @param rowNum
	 */
	public void storeStockDetailsInExcel(int rowNum)
	{
		ResultCalendarPO.returnData.add(stockValue.getText());
		String color = stockValue.getCssValue("color");
		
		String[] colorPart;
		colorPart = color.replace("rgba(","").split(",");
		
		String hexCode = String.format("#%02X%02X%02X", Integer.parseInt(colorPart[0].trim()),
				Integer.parseInt(colorPart[1].trim()),Integer.parseInt(colorPart[2].trim()));
		
		if(hexCode.equals("#DE1439"))
		{
			ResultCalendarPO.returnData.add("Red");
		}
		else if(hexCode.equals("#008000"))
		{
			ResultCalendarPO.returnData.add("Green");
		}
		else
		{
			throw new RuntimeException("Invalid Color");
		}
		
		if(ResultCalendarPO.returnData.size()==5)
		{
			for(int i = 0; i<ResultCalendarPO.returnData.size(); i++)
			{
				writeExcel("StockValue", rowNum, i, ResultCalendarPO.returnData.get(i));
			}
		}
		else
		{
			throw new RuntimeException("Invalid Security Code");
		}
	}
}
