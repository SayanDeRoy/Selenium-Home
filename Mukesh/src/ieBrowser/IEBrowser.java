package ieBrowser;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.ie.driver", "C:\\Selenium Drivers\\IEDriverServer_Win32_3.3.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("file:///C:/Users/sayan/Desktop/attachment.html");
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			driver.findElement(By.name("attachment")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:/Selenium Drivers/AutoIT Script/Script02.exe");
		System.out.println("Added");
		

	}

}
