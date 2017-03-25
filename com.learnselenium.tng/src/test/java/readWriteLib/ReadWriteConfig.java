package readWriteLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteConfig {
	
	File file;
	Row row;
	Workbook wb;
	Sheet sheet1;
	public int rowCount=10;
	
	
	public ReadWriteConfig(String excelPath){
		
		file = new File(excelPath);
		try {
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
				System.out.println("Invalid Excel file");
			}
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		} 
	}
	public String getData(int sheetNumber, int row, int Col){
		sheet1 = wb.getSheetAt(sheetNumber);
		rowCount = sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		String getData = sheet1.getRow(row).getCell(Col).getStringCellValue();
		return getData;
	}
	public void getAllData(int sheetNumber){
		
		sheet1 = wb.getSheetAt(sheetNumber);
		rowCount = sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		System.out.println("Total Number of Rows: "+rowCount);
		
		for(int i = 0; i<rowCount+1; i++)
		{
			if(sheet1.getRow(i)!= null)
			{
				row = sheet1.getRow(i);
				System.out.println(row.getFirstCellNum()+"  "+row.getLastCellNum());
				
				for(int j = row.getFirstCellNum(); j<row.getLastCellNum(); j++)
				{
					System.out.print(row.getCell(j).getStringCellValue()+"     ");
				}
				System.out.println();
			}
			else
			{
				System.out.println("No Data in row: "+(i+1));
			}
		}
	}
	public void setData(int sheetNumber)
	{
		sheet1 = wb.getSheetAt(sheetNumber);
		int lastRow = sheet1.getLastRowNum();
		System.out.println(lastRow);
		
		sheet1.createRow(lastRow+1).createCell(0).setCellValue("Pass");
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 

	}
	public void setAllData(int sheetNumber)
	{
		sheet1 = wb.getSheetAt(sheetNumber);
		
		for(int i = 0; i<rowCount+1; i++)
		{
			row = sheet1.getRow(i);
			int k = row.getLastCellNum();
			for(int j = row.getLastCellNum(); j<row.getLastCellNum()+1; j++)
			//for(int j = row.getLastCellNum(); j<k+1; j++)
			{
				sheet1.getRow(i).createCell(j).setCellValue("Pass");
			}
		}
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 

	}
}
