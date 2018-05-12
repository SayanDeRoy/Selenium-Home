package autoIT;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FileUpload {
	
	@Test
	public void upload() throws Exception{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("file:///C:/Users/sayan/Desktop/attachment.html");
		
		driver.findElement(By.xpath("//input[@name='attachment']")).click();
		//System.out.println("click");
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:/Selenium Drivers/AutoIT Script/Script01.exe");
		
		System.out.println("Added");
	}

}
