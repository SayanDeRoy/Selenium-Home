import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.ie.driver", "C:\\SHARON\\STUDIES\\Selenium\\SetUp\\Driver 3 beta 3\\IEDriverServer.exe");
		WebDriver driver =new InternetExplorerDriver();
		
		driver.get("www.google.com");
		
		System.out.println(driver.getTitle());
		
	}

}
