package ieBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser2 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.ie.driver", "C:\\Selenium Drivers\\IEDriverServer_Win32_3.3.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("www.google.com");
		//driver.wait(3000);
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Sayan");;
		System.out.println("Clicked");
		
		//Thread.sleep(3000);
		
		//Runtime.getRuntime().exec("C:/Selenium Drivers/AutoIT Script/Script02.exe");
		//System.out.println("Added");
		

	}

}
