package autoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUpload2 {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Selenium%20Drivers/attachment.html");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name = 'attachment']")).click();
		Thread.sleep(5000);
		
		Runtime.getRuntime().exec("C:\\Selenium Drivers\\AutoIT Script\\FileUpload.exe");
		
		System.out.println("Attachment Added Successfully");
	}

}
