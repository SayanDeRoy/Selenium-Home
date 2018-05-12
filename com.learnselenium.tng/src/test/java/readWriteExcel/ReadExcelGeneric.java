package readWriteExcel;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import readWriteLib.ReadConfig;

public class ReadExcelGeneric {
	
	@Test
	public void read(){
	ReadConfig obj = new ReadConfig("C:\\Selenium Drivers\\Excel\\Selenium.xlsx");
	obj.getData(0);
	}
}
