import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Searcg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		System.setProperty("webdriver.gecko.driver", "C:\\SHARON\\STUDIES\\Selenium\\SetUp\\2.5\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get("https://login.naukri.com/nLogin/Login.php?msg=0&URL=http%3A%2F%2Fmy.naukri.com");
		
		
		driver.findElement(By.id("emailTxt")).clear();
		driver.findElement(By.id("emailTxt")).sendKeys("sharonmsam21@gmail.com");
		
		driver.findElement(By.id("pwd1")).sendKeys("Xtrac@123");
		//driver.findElement(By.id("sbtLog")).click();
		
		WebElement element = driver.findElement(By.name("Login"));
		JavascriptExecutor exec = (JavascriptExecutor)driver;
		exec.executeScript("arguments[0],click", element);
		
		
	}

}
