package com.learnselenium.tng;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IETestNG {
	
	@Test
	public void ieTestNG(){
		System.setProperty("webdriver.ie.driver", 
				"D:\\Selenium Drivers\\IEDriverServer_Win32_3.3.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("www.flipkart.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
