package pageObjectClasses;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import library.Base;

public class ResultCalendarPO extends Base{
	
	private WebDriver driver;
	private Logger log = LogManager.getLogger(ResultCalendarPO.class.getName());
	private Select sel;
	private List<WebElement> matchingValues;
	private List<WebElement> noOfTable;
	public static String securityName;
	public static String resultDate;
	public static List<String> returnData;
	String securityCode1;
	public String expectedTitle = "Results Calendar | Company Results Calendar | BSE";
	
	//private WebElement noMatch;

//-----------------------------Constructor Initialization---------------------------//	
	public ResultCalendarPO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
//-----------------------------End of Constructor---------------------------//

//-----------------------------Elements Declaration---------------------------------//
	@FindBy(xpath = "//img[@id = 'img2']")
	private WebElement fromDateCal;
	
	@FindBy(xpath = "//img[@id = 'img3']")
	private WebElement toDateCal;
	
	@FindBy(xpath = "//select[@name = 'ddlCalMonthDiv3']")
	private WebElement monthFrom;
	
	@FindBy(xpath = "//select[@name = 'ddlCalMonthDiv4']")
	private WebElement monthTo;
	
	@FindBy(xpath = "//select[@name = 'ddlCalYearDiv3']")
	private WebElement yearFrom;
	
	@FindBy(xpath = "//select[@name = 'ddlCalYearDiv4']")
	private WebElement yearTo;
	
	@FindBy(xpath = "//div[@id='Div3']//child::img[@alt='Prev. Year']")
	private WebElement prevYearFrom;
	
	@FindBy(xpath = "//div[@id='Div4']//child::img[@alt='Prev. Year']")
	private WebElement prevYearTo;
	
	@FindBy(xpath = "//div[@id='Div3']//child::img[@alt='Next Year']")
	private WebElement NextYearFrom;
	
	@FindBy(xpath = "//div[@id='Div4']//child::img[@alt='Next Year']")
	private WebElement NextYearTo;
	
	@FindBy(xpath = "//div[@id='Div3']//child::img[@alt='Prev. Month']")
	private WebElement prevMonthFrom;
	
	@FindBy(xpath = "//div[@id='Div4']//child::img[@alt='Prev. Month']")
	private WebElement prevMonthTo;
	
	@FindBy(xpath = "//div[@id='Div3']//child::img[@alt='Next Month']")
	private WebElement nextMonthFrom;
	
	@FindBy(xpath = "//div[@id='Div4']//child::img[@alt='Next Month']")
	private WebElement nextMonthTo;
	
	@FindBy(xpath = "//div[@id='Div3']//child::a[text()='Clear']")
	private WebElement clearFrom;
	
	@FindBy(xpath = "//div[@id='Div4']//child::a[text()='Clear']")
	private WebElement clearTo;
	
	@FindBy(xpath = "//div[@id='Div3']//child::a[text()='Close']")
	private WebElement closeFrom;
	
	@FindBy(xpath = "//div[@id='Div4']//child::a[text()='Close']")
	private WebElement closeTo;
	
	@FindBy(xpath = "//div[@id='Div3']//child::a[contains(@href,'gotoTodaysDate')]")
	private WebElement todaysDateFrom;
	
	@FindBy(xpath = "//div[@id='Div4']//child::a[contains(@href,'gotoTodaysDate')]")
	private WebElement todaysDateTo;
	
	@FindBy(xpath = "//input[@id = 'ctl00_ContentPlaceHolder1_txtDate']")
	private WebElement fromDate;
	
	@FindBy(xpath = "//input[contains(@id, 'Todate')]")
	private WebElement toDate;
	
	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_GetQuote1_smartSearch']")
	private WebElement enterSecurityID;
	
	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder1_btnSubmit']")
	private WebElement submit;

	@FindAll({
		@FindBy(xpath = "//div[@id='Div3']//child::a[contains(@href,'setCalendarControlDate')]")
		})
	private List<WebElement> daysFrom;
	
	@FindAll({
		@FindBy(xpath = "//div[@id='Div4']//child::a[contains(@href,'setCalendarControlDate')]")
		})
	private List<WebElement> daysTo;
	
	@FindBy(xpath = "//ul[@id='listtest']//child::strong")
	WebElement noMatch;
		
//-----------------------------End of Elements Declaration---------------------------------//
	
	/**
	 * Click on Form Calendar Image
	 * @param img
	 */
	public void clickOnFromCalendar(String img)
	{
		fromDateCal.click();
	}
	
	/**
	 * Click on To Calendar Image
	 * @param img
	 */
	public void clickOnToCalendar(String img)
	{
		toDateCal.click();
	}
	
	/**
	 * Click on From Calendar Text 
	 */
	public void clickOnFromCalendar()
	{
		fromDate.click();
	}
	
	/**
	 * Click on To Calendar Text 
	 */
	public void clickOnToCalendar()
	{
		toDate.click();
	}
	
	/**
	 * Enter From Date
	 * @param date
	 * @throws Exception
	 */
	public void enterFromDate(String date)
	{
		try
		{
			DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
			df.setLenient(false);
			df.parse(date);
			
			String [] dateParts = date.split("/");
			String day = dateParts[0];
			String month = dateParts[1];
			String year = dateParts[2];
			
			int yr = Integer.parseInt(dateParts[2]);
			int currentYear = Year.now().getValue();
			
			sel = new Select(monthFrom);
			sel.selectByVisibleText(month);

			if(yr<=currentYear)
			{
				sel = new Select(yearFrom);
				sel.selectByVisibleText(year);
			}
			else
			{
				throw new RuntimeException("Invalid Year");
			}
			for(WebElement ele : daysFrom)
			{
				if(ele.getText().equals(day))
				{
					ele.click();
					break;
				}
			}
		}
		catch(ParseException e)
		{
			log.error("Date Issue");
			throw new RuntimeException("Date Parse Issue");
		}
	}
	
	/**
	 * Enter To Date
	 * @param date
	 * @throws Exception
	 */
	public void enterToDate(String date)
	{
		try
		{
			DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
			df.setLenient(false);
			df.parse(date);
			
			String [] dateParts = date.split("/");
			String day = dateParts[0];
			String month = dateParts[1];
			String year = dateParts[2];
			
			int yr = Integer.parseInt(dateParts[2]);
			int currentYear = Year.now().getValue();
			
			sel = new Select(monthTo);
			sel.selectByVisibleText(month);
			
			if(yr<=currentYear)
			{
				sel = new Select(yearTo);
				sel.selectByVisibleText(year);
			}
			else
			{
				throw new RuntimeException("Invalid Year");
			}
			for(WebElement ele : daysTo)
			{
				if(ele.getText().equals(day))
				{
					ele.click();
					break;
				}
			}
		}
		catch(ParseException e)
		{
			log.error("Date Issue");
			throw new RuntimeException("Date Parse Issue");
		}
	} 
	
	/**
	 * Enter Security Code and Select Value from drop down
	 * @param securityCode
	 * @param selectSecurityName
	 * @return
	 * @throws InterruptedException 
	 */
	public String enterSecurityCodeAndSelect(int securityCode, String selectSecurityName) throws InterruptedException
	{
		enterSecurityID.clear();
		enterSecurityID.sendKeys(String.valueOf(securityCode));
		
		try
		{
			driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
			return noMatch.getText();
		}
		catch(Exception e)
		{
			e.getMessage();
			matchingValues = driver.findElements(By.xpath("//ul[@id='listEQ']//child::span[@class='rightspan']"));
			for(WebElement ele : matchingValues)
			{
				if(ele.getText().equalsIgnoreCase(selectSecurityName))
				{
					ele.click();
					return "Value Selected";
				}
			}
			return "Not able to select Value";
		}
	}
	
	/**
	 * Enter Security Name and Select Value from drop down
	 * @param securityName
	 * @param selectSecurityName
	 * @return
	 * @throws InterruptedException 
	 */
	public String enterSecurityNameAndSelect(String securityName, String selectSecurityName) throws InterruptedException
	{
		WebElement actualValue = null;
		enterSecurityID.clear();
		enterSecurityID.sendKeys(securityName);
		
		try
		{
			driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
			return noMatch.getText();
		}
		catch(Exception e)
		{
			e.getMessage();
			matchingValues = driver.findElements(By.xpath("//ul[@id='listEQ']//child::span[@class='rightspan']"));
			if(matchingValues.size()==1)
			{
				if(matchingValues.get(0).getText().equalsIgnoreCase(selectSecurityName))
				{
					matchingValues.get(0).click();
					return "Value Selected";
				}
				else
				{
					return matchingValues.get(0).getText()+" Doesn't match with "+selectSecurityName;
				}
			}
			else if(matchingValues.size()>1)
			{
				for(WebElement ele : matchingValues)
				{
					if(ele.getText().toLowerCase().contains(securityName.toLowerCase()))
					{
						if(ele.getText().equalsIgnoreCase(selectSecurityName))
						{
							actualValue = ele;
						}
					}
					else
					{
						return ele.getText()+" Doesn't match with "+securityName;
					}
				}
			}
			try
			{
				actualValue.click();
				return "Value Selected";
			}
			catch(Exception e1)
			{
				return "Security drop down value Doesn't match with "+selectSecurityName;
			}
		}
	}
	public void clickSubmitButton()
	{
		submit.click();
	}
	
	/**
	 * Get Result Date using Security Code
	 * @param securityCode
	 * @return
	 * @throws InterruptedException 
	 */
	public void getResultDateAndClick(int securityCode)
	{
		returnData = new ArrayList<>();
		securityCode1 = String.valueOf(securityCode);
		returnData.add(securityCode1);
		noOfTable = driver.findElements(By.xpath("(//table[@id='ctl00_ContentPlaceHolder1_gvData']//table[@border='0'])[1]//td"));
		boolean counter = false;
		
		for(int i = 0; i<noOfTable.size(); i++)
		{
			if(noOfTable.get(i).getText().equals("..."))
			{
				String preValue = noOfTable.get(i-1).getText();
				Integer preValueInt = Integer.parseInt(preValue);
				preValue = Integer.toString(preValueInt+1);
				noOfTable.get(i).click();
				noOfTable = driver.findElements(By.xpath("(//table[@id='ctl00_ContentPlaceHolder1_gvData']//table[@border='0'])[1]//td"));
				for(int k = 0; k<noOfTable.size(); k++)
				{
					if(noOfTable.get(k).getText().equals(preValue))
					{
						i = k;
					}
				}
				//noOfTable.get(i).click();
				//noOfTable = driver.findElements(By.xpath("(//table[@id='ctl00_ContentPlaceHolder1_gvData']//table[@border='0'])[1]//td"));
				List<WebElement> noOfRows = driver.findElements(By.xpath("//tr[@class='TTRow']//a[@class='tablebluelink']"));
				for(int j = 0; j<noOfRows.size(); j++)
				{
					if(noOfRows.get(j).getText().equals(securityCode1))
					{
						securityName = driver.findElement(By.xpath("((//tr[@class='TTRow']"
								+ "//a[@class='tablebluelink'])["+(j+1)+"]"
								+ "//following::td[@class='TTRow_left'])[1]")).getText();
						
						returnData.add(securityName);
						resultDate = driver.findElement(By.xpath("((//tr[@class='TTRow']"
								+ "//a[@class='tablebluelink'])["+(j+1)+"]//following::td[2])[1]")).getText();
						
						returnData.add(resultDate);
						noOfRows.get(j).click();
						counter = true;
					}
				}
			}
			else
			{
				noOfTable.get(i).click();
				noOfTable = driver.findElements(By.xpath("(//table[@id='ctl00_ContentPlaceHolder1_gvData']//table[@border='0'])[1]//td"));
				List<WebElement> noOfRows = driver.findElements(By.xpath("//tr[@class='TTRow']//a[@class='tablebluelink']"));
				for(int j = 0; j<noOfRows.size(); j++)
				{
					if(noOfRows.get(j).getText().equals(securityCode1))
					{
						securityName = driver.findElement(By.xpath("((//tr[@class='TTRow']"
								+ "//a[@class='tablebluelink'])["+(j+1)+"]"
								+ "//following::td[@class='TTRow_left'])[1]")).getText();
						
						returnData.add(securityName);
						resultDate = driver.findElement(By.xpath("((//tr[@class='TTRow']"
								+ "//a[@class='tablebluelink'])["+(j+1)+"]//following::td[2])[1]")).getText();
						
						returnData.add(resultDate);
						noOfRows.get(j).click();
						counter = true;
					}
				}
			}
			if(counter)
			{
				break;
			}
			
		}
		if(counter==false)
		{
			throw new RuntimeException("Invalid Security Code To Click");
		}
	}
	public void verifyResultDate(String fromDate, String toDate)
	{
		noOfTable = driver.findElements(By.xpath("(//table[@id='ctl00_ContentPlaceHolder1_gvData']//table[@border='0'])[1]//td"));
		for(int i = 0; i<noOfTable.size(); i++)
		{
			try {
				Date fDate = new SimpleDateFormat("dd/MMM/yyyy").parse(fromDate);
				Date tDate = new SimpleDateFormat("dd/MMM/yyyy").parse(toDate);
				noOfTable.get(i).click();
				noOfTable = driver.findElements(By.xpath("(//table[@id='ctl00_ContentPlaceHolder1_gvData']//table[@border='0'])[1]//td"));
				List<WebElement> noOfRows = driver.findElements(By.xpath("//tr[@class='TTRow']//a[@class='tablebluelink']"));
				for(int j = 0; j<noOfRows.size(); j++)
				{
					resultDate = driver.findElement(By.xpath("((//tr[@class='TTRow']"
							+ "//a[@class='tablebluelink'])["+(j+1)+"]//following::td[2])[1]")).getText();
					String modifiedResultDate = resultDate.replace(" ", "/");
					Date rDate = new SimpleDateFormat("dd/MMM/yyyy").parse(modifiedResultDate);
					
					if(rDate.compareTo(fDate) >= 0 && rDate.compareTo(tDate) <= 0)
					{
						
					}
					else
					{
						throw new RuntimeException("Date is not in range");
					}
				}
			} catch (ParseException e) {
				throw new RuntimeException("Date Parse Exception");
			}
		}
	}
	public String getSecurityName()
	{
		return driver.findElement(By.xpath("((//tr[@class='TTRow']"
				+ "//a[@class='tablebluelink'])[1]"
				+ "//following::td[@class='TTRow_left'])[1]")).getText();
	}
}
