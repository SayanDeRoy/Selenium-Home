package dropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDown1 {
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
	@Test(priority = 1)
	public void dropDownVisible() throws Exception{
		
		String[] expValues= {"Position","Name","Price"};
		
		WebElement actValues = driver.findElement(By.xpath("//select[@title='Sort By']"
				+ "/following::select[@title='Sort By']"));
		
		Select sortByValues=new Select(actValues);
		
		List<WebElement> actList = sortByValues.getOptions();
		System.out.println("List Size: "+actList.size());
		System.out.println("Array Size: "+expValues.length);
		for(int i = 0; i<actList.size(); i++)
		{
			WebElement ele = actList.get(i);
			System.out.println("All Values are: "+ele.getText());
			Assert.assertEquals(ele.getText(), expValues[i]);
		}
	}
	@AfterTest
	public void close(){
		driver.quit();
	}
}


