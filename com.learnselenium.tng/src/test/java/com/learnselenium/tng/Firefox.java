package com.learnselenium.tng;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {
	@Test
	public void start(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.quit();
	}

}
