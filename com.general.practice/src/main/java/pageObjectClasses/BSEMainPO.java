package pageObjectClasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BSEMainPO {
	
	WebDriver driver;
	Logger log = LogManager.getLogger(BSEMainPO.class.getName());
	public String expectedTitle = "BSE Ltd. (Bombay Stock Exchange) | Live Stock Market Updates for S&P BSE SENSEX,Stock Quotes & Corporate Information";

//-----------------------------Constructor Initialization---------------------------//	
	public BSEMainPO(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
//-----------------------------End of Constructor---------------------------//
	
//-----------------------------Elements Declaration---------------------------------//	
	@FindAll({ 
		@FindBy(xpath="//a[@id]") 
	})
	private List<WebElement> mainLink;
	
	@FindAll({ 
		@FindBy(xpath="//a[@class='navsubpoints']") 
	})
	private List<WebElement> subLink;
	
	@FindAll({ 
		@FindBy(xpath="//a[@class='quicklink']") 
	})
	private List<WebElement> quickLink;
	
//-----------------------------End of Elements Declaration---------------------------------//
	
	/**
	 * Click on Main Link
	 * @param mainLinkValue
	 */
	public void clickOnMainLink(String mainLinkValue)
	{
		int count = 0;
		for(WebElement ele : mainLink)
		{
			if(ele.getText().toLowerCase().contains(mainLinkValue.toLowerCase()))
			{
				ele.click();
				count++;
				break;
			}
		}
		if(count == 0)
		{
			log.error(mainLinkValue+ " Element Not Found");
			throw new RuntimeException("Invalid Main Link");
			
		}
	}
	
	/**
	 * Click on Sub Link
	 * @param subLinkValue
	 */
	public void clickOnsubLink(String subLinkValue)
	{
		int count = 0;
		for(WebElement ele : subLink)
		{
			if(ele.getText().toLowerCase().contains(subLinkValue.toLowerCase()))
			{
				ele.click();
				count++;
				break;
			}
		}
		if(count == 0)
		{
			log.error(subLinkValue+ " Element Not Found");
			throw new RuntimeException("Invalid Sub Link");
		}
	}
	/**
	 * Click on Quick Link
	 * @param quickLinkValue
	 */
	public void clickOnquickLink(String quickLinkValue)
	{
		int count = 0;
		for(WebElement ele : quickLink)
		{
			if(ele.getText().toLowerCase().contains(quickLinkValue.toLowerCase()))
			{
				ele.click();
				count++;
				break;
			}
		}
		if(count == 0)
		{
			log.error(quickLinkValue+ " Element Not Found");
			throw new RuntimeException("Invalid Quick Link");
		}
	}
}
