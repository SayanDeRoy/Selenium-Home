package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public static WebDriver driver;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	Logger log = LogManager.getLogger(Base.class.getName());
	Properties pro = new Properties();
	
	/**
	 * Get Current Date
	 * @return
	 */
	public String getCurrentDate()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("d/MMM/yyyy");
		Date date = new Date();
		String currentDate = sdf.format(date);
		return currentDate;
	}
	
	/**
	 * Get Future Date
	 * @return
	 */
	public String getFutureDate()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("d/MMM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 7);
		String futureDate = sdf.format(cal.getTime());
		return futureDate;
	}
	
	/**
	 * Read Property File
	 * @param key
	 * @return
	 */
	private String readProperty(String key)
	{
		try {
			FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\environment.properties");
			pro.load(fis);
			
		} catch (FileNotFoundException e) {
			
			log.error("Property File not found");
			System.exit(0);
		}
		catch (IOException e) {
			
			log.error("IO Exception");
			System.exit(0);
		}
		return pro.getProperty(key);
	}
	
	/**
	 * Perform Browser Initialization
	 * @return
	 */
	public WebDriver openBrowser()
	{
		//DesiredCapabilities sc = new DesiredCapabilities();
		String browser = readProperty("browser");
		switch(browser.toLowerCase())
		{
			case "ff":
			case "firefox":
				System.setProperty("webdriver.gecko.driver", ".\\src\\main\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
			
			case "ie":
			case "internetexplorer":
				System.setProperty("webdriver.ie.driver", ".\\src\\main\\resources\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				break;
				
			case "chrome":
				System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
				
			default:
				log.error("Invalid Browser Details");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	/**
	 * Perform Open URL
	 * @param url
	 */
	public void openURL(String url)
	{
		driver.get(readProperty(url));
	}
	
	/**
	 * Switch to Parent Window
	 * @param driver
	 */
	public void switchToParent(WebDriver driver)
	{
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while(itr.hasNext())
		{
			String childWindow =  itr.next();
			if(parentWindow.equals(childWindow))
			{
				driver.switchTo().window(parentWindow);
			}
		}
	}
	
	/**
	 * Switch to Child Window
	 * @param driver
	 */
	public void switchToChild()
	{
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while(itr.hasNext())
		{
			String childWindow =  itr.next();
			if(!parentWindow.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
			}
		}
	}
	
	/**
	 * Perform Close Browser
	 */
	public void closeBrowser()
	{
		driver.quit();
		driver = null;
	}
	
	/**
	 * Write Data in Excel
	 * @param sheetName
	 * @param rowNum
	 * @param columnNum
	 * @param value
	 */
	public void writeExcel(String sheetName, int rowNum, int columnNum, String value)
	{
		try {
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
			
			try
			{
				sheet.getRow(rowNum).createCell(columnNum).setCellValue(value);
			}
			catch(NullPointerException e)
			{
				row = sheet.createRow(rowNum);
				row.createCell(columnNum).setCellValue(value);
			}
			fis.close();
			FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
			wb.write(fos);
			fos.close();
			
		} catch (Exception e) {
			log.error(e.getMessage());
			System.exit(0);
		}
	}
	
	/**
	 * Take Screenshot
	 * @param name
	 */
	public static String getScreenShot(String name)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = "C:\\CodeJava\\workspace\\com.general.practice\\screenShot\\"+name+".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(src, destination);
			return dest;
		} catch (IOException e) {
			return e.getMessage();
		}
	}
}
