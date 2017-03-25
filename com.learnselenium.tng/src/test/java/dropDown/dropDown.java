package dropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dropDown {
WebDriver driver;
WebElement sort;
Select sortByValues;

	@BeforeTest
	public void setUp() throws Exception{
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://live.guru99.com/index.php/mobile.html");
		Thread.sleep(5000);
	}
	
	@Test(priority = 0)
	public void dropDownIndex() throws Exception{
		sort=driver.findElement(By.xpath("//select[@title='Sort By']"
			+ "/following::select[@title='Sort By']"));
		sortByValues=new Select(sort);
		sortByValues.selectByIndex(2);
		Thread.sleep(3000);
	}
	@Test(priority = 1)
	public void dropDownVisible() throws Exception{
		sort=driver.findElement(By.xpath("//select[@title='Sort By']"
			+ "/following::select[@title='Sort By']"));
		sortByValues=new Select(sort);
		sortByValues.selectByVisibleText("Position");
		Thread.sleep(3000);
	}
	@Test(priority = 2)
	public void dropDownValue() throws Exception{
		sort=driver.findElement(By.xpath("//select[@title='Sort By']"
				+ "/following::select[@title='Sort By']"));
		sortByValues=new Select(sort);
		sortByValues.selectByValue("http://live.guru99.com/index.php/mobile.html?dir=asc&order=name");
		Thread.sleep(3000);
	}
	@AfterTest
	public void close(){
		driver.quit();
	}
}


