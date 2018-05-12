package dropDown;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDown2 {
WebDriver driver;
WebElement sort;
Select sortByValues;

	@BeforeMethod
	@BeforeTest
	public void setUp() throws Exception{
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
	}
	@Test(priority = 1)
	public void dropDownVisible() throws Exception{
		
		//driver.findElement(By.xpath("//i[@class='dropdown icon']")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[1]/div[2]/div[3]/div[1]/div[8]/div")).click();
		
		List<WebElement> actList = driver.findElements(By.xpath("//div[@class='menu transition visible']"
				+ "//div[@class='item']"));
		
		System.out.println("List Size: "+actList.size());
		
		for(WebElement ele:actList)
		//for(int i = 0; i<actList.size(); i++)
		{
			//WebElement ele = actList.get(i);
			String values = ele.getText();
			
			System.out.println("All Values are: "+values);
			if(values.equalsIgnoreCase("Angular"))
			{
				ele.click();
			}
			else if(values.equalsIgnoreCase("Ruby"))
			{
				ele.click();
			}	
			else if(values.equalsIgnoreCase("Information Architecture"))
			{
				ele.click();
			}
			else if(values.equalsIgnoreCase("Graphic Design"))
			{
				ele.click();
			}
		}
	}
	
}


