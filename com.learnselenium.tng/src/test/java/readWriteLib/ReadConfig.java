package readWriteLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadConfig 
{
	Workbook wb;
	Sheet sheet1;
	int rowCount;
	public ReadConfig(String excelPath)
	{
		try {
			File file = new File(excelPath);
			FileInputStream fis = new FileInputStream(file);
			
			String fileExName = excelPath;
			fileExName = fileExName.substring(fileExName.indexOf("."));
			
			if(fileExName.equals(".xlsx"))
			{
				wb = new XSSFWorkbook(fis);
			}
			else if(fileExName.equals(".xls"))
			{
				wb = new HSSFWorkbook(fis);
			}
			else
			{
				System.out.println("Not a valid Excel sheet");
			}
			}
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
	}
	public void getData(int sheetNumber)
		{
		sheet1 = wb.getSheetAt(sheetNumber);
		rowCount = sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		System.out.println(rowCount);
		System.out.println(sheet1.getFirstRowNum()+" and "+sheet1.getLastRowNum());
		
		for(int i = sheet1.getFirstRowNum(); i<rowCount+1; i++)
		{
			if(sheet1.getRow(i)!= null)
			{
				Row row = sheet1.getRow(i);
				System.out.println(row.getFirstCellNum()+"   "+row.getLastCellNum());
			
				for(int j = row.getFirstCellNum(); j<row.getLastCellNum(); j++)
				{
					System.out.print(row.getCell(j).getStringCellValue()+" || ");
				}
				System.out.println();
			}
			else
				System.out.println("No Data");
		}
		try {
			wb.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
