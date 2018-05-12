package wait;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ImplicitWait {

	@Test
	public void tryCatch() {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			driver.findElement(By.xpath("//input[@name='emai']")).click();
		} catch (NoSuchElementException e) {
			
			System.out.println(e.getMessage());
		}
	}
}

