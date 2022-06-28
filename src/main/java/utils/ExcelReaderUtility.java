package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReaderUtility {

	String FilePath;
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;


	@DataProvider
	public String[][] getExcelData() throws IOException
	{
		FilePath= System.getProperty("user.dir")+File.separator+"src/main/resources"+File.separator+"TestData.xlsx";
		fis=new FileInputStream(FilePath);   
		workbook=new XSSFWorkbook(fis);
		sheet= workbook.getSheet("Sheet1");
		int rowCount=sheet.getLastRowNum();
		int colCount=sheet.getRow(0).getLastCellNum();
		String data[][]=new String[rowCount][colCount];
		System.out.println("rows are : "+rowCount);
		System.out.println("columns are : "+colCount);

		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<colCount;j++)
			{
				data[i-1][j]=row.getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
