package readWriteExcel;

import org.testng.annotations.Test;

import readWriteLib.ReadWriteConfig;

public class ReadWriteExcelGeneric {
	
	@Test
	public void readWriteData(){
		ReadWriteConfig rwc = new ReadWriteConfig("C:\\Selenium Drivers\\Excel\\LoginGuru99.xlsx");
		rwc.getAllData(0);
		rwc.setData(0);
		rwc.setAllData(0);
	}	
}

