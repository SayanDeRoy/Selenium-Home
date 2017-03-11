package com.learnselenium.tng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Firefox {
	@Test
	public void start(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.quit();
	}

}
