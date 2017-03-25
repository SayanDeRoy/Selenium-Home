package wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ImplicitWait1 {
	
	@Test
	public void implicitWait1(){
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
		
		try {
			driver.findElement(By.xpath("//button[text()='Click me to star timer']")).click();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		WebElement element = driver.findElement(By.xpath("//p[text()='QTP']"));
		
		boolean status = element.isDisplayed();
		
		if(status)
		{
			System.out.println("Element Displayed");
		}
		else
		{
			System.out.println("Element is not displayed");
		}
		
		
	}
}
