package ieBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.ie.driver", "D:\\Selenium Drivers\\IEDriverServer_Win32_3.3.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("www.google.com");
		//driver.wait(3000);
		System.out.println(driver.getTitle());

	}

}
