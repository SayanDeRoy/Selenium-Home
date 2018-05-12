package dataDriven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import readWriteLib.ReadWriteConfig;

public class Login {
	
		WebDriver driver;
		String url = "http://live.guru99.com/index.php/";
		String expectedTitle;
		String actualTitle;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		WebElement myAccountLink = driver.findElement(By.xpath("//div[@class = 'footer']"
				+ "//following::a[@title='My Account']"));
		myAccountLink.click();
		Thread.sleep(3000);
	}
	@Test(dataProvider="Guru99")
	public void loginGuru99(String userName, String passWord) throws InterruptedException{
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id = 'pass']")).sendKeys(passWord);
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//button[@id= 'send2']")).click();
		Thread.sleep(3000);	
		expectedTitle = "My Account";
		actualTitle = driver.getTitle();
		
		AssertJUnit.assertEquals(expectedTitle, actualTitle);
	}
	@AfterMethod
	public void shutDown(){
		driver.quit();
	}
	@DataProvider(name = "Guru99")
	public Object[][] getTestData(){
		ReadWriteConfig rwc = new ReadWriteConfig("C:\\Selenium Drivers\\Excel\\LoginGuru99.xlsx");
		rwc.getData(0, 0, 0);
		int row = rwc.rowCount+1;
		
		Object[][] data = new Object[row][2];
		for(int i = 0; i<row; i++)
		{
			data[i][0]= rwc.getData(0, i, 0);
			data[i][1]= rwc.getData(0, i, 1);
		}
		return data;
	}
}
