import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleOpen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		System.setProperty("webdriver.gecko.driver", "C:\\SHARON\\STUDIES\\Selenium\\SetUp\\2.5\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get("https://google.co.in");
		
		
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("sharonmsam");
		
		driver.findElement(By.name("btnG")).click();
		
		
		
	}

}
