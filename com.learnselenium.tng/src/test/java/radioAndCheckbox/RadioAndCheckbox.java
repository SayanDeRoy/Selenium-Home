package radioAndCheckbox;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioAndCheckbox {
	
	WebDriver driver;
	
	@BeforeMethod
	@BeforeTest
	public void setUp() throws Exception{
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-automate-radio-button-in.html");
		Thread.sleep(5000);
	}
	@Test(priority = 0)
	public void radioButton(){
		
		List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio' and @name='lang']"));
		
		for(int i = 0; i<radio.size(); i++)
		{
			WebElement radioElement = radio.get(i);
			String radioValue = radioElement.getAttribute("value");
			System.out.println("RadioButton Values are:  "+radioValue);
			
			if(radioValue.equalsIgnoreCase("c#"))
			{
				radioElement.click();
			}
		}
		
	}
	@Test(priority = 1)
	public void checkBox(){
		
		List<WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox' and @name='lang']"));
		
		for(WebElement checkElement : checkBox)
		{
			String checkBoxValue = checkElement.getAttribute("id");
			System.out.println("Checkbox ids are:  "+checkBoxValue);
			
			if(checkBoxValue.equalsIgnoreCase("sinG"))
			{
				checkElement.click();
			}
		}
	}
	@AfterTest
	public void close(){
		driver.quit();
	}
}
