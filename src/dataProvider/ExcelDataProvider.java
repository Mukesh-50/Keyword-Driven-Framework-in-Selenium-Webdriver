package dataProvider;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	XSSFWorkbook wb;

	public ExcelDataProvider()
	{
		
		try 
		{
			wb=new XSSFWorkbook(new FileInputStream(new File("./TestCases/InputSheet.xlsx")));
		} 
		catch (Exception e) {
			
			System.out.println("Unable to load excel sheet");
			System.out.println(e.getMessage());
		} 
		
	}
	
	
	public String getData(String sheetname,int row,int column){
		
	 String data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	 
		
	 return data;
	}
	
	public int rowCount(String sheetname){
		
		return wb.getSheet(sheetname).getLastRowNum();
	}
	
	
}
