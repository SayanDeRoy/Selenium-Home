package action;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dragDrop {
	WebDriver driver;
	
	@BeforeMethod
	@BeforeTest
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	}
	@Test
	public void dragAndDrop(){
		Actions act = new Actions(driver);
		
		WebElement dragOslo = driver.findElement(By.xpath("//div[@id = 'box1']"));
		WebElement dragStockholm = driver.findElement(By.xpath("//div[@id = 'box2']"));
		WebElement dragWashington = driver.findElement(By.xpath("//div[@id = 'box3']"));
		WebElement dragCopenhagen = driver.findElement(By.xpath("//div[@id = 'box4']"));
		WebElement dragSeoul = driver.findElement(By.xpath("//div[@id = 'box5']"));
		WebElement dragRome = driver.findElement(By.xpath("//div[@id = 'box6']"));
		WebElement dragMadrid = driver.findElement(By.xpath("//div[@id = 'box7']"));
		
		WebElement dropItaly = driver.findElement(By.xpath("//div[text()='Italy']"));
		WebElement dropSpain = driver.findElement(By.xpath("//div[text()='Spain']"));
		WebElement dropNorway = driver.findElement(By.xpath("//div[text()='Norway']"));
		WebElement dropDenmark = driver.findElement(By.xpath("//div[text()='Denmark']"));
		WebElement dropSouthKorea = driver.findElement(By.xpath("//div[text()='South Korea']"));
		WebElement dropSweden = driver.findElement(By.xpath("//div[text()='Sweden']"));
		WebElement dropUnitedStates = driver.findElement(By.xpath("//div[text()='United States']"));
		
		act.dragAndDrop(dragOslo, dropNorway).perform();
		act.dragAndDrop(dragStockholm, dropSweden).perform();
		act.dragAndDrop(dragWashington, dropUnitedStates).perform();
		act.dragAndDrop(dragCopenhagen, dropDenmark).perform();
		act.dragAndDrop(dragSeoul, dropSouthKorea).perform();
		act.dragAndDrop(dragRome, dropItaly).perform();
		act.dragAndDrop(dragMadrid, dropSpain).perform();
	}
	
}
