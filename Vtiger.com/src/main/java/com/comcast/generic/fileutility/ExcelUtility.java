package com.comcast.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Throwable {
		FileInputStream fis1= new FileInputStream("./testdata/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}

	public int getRowcount(String sheetName) throws Throwable {
		FileInputStream fis1= new FileInputStream("./testdata/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
		
	}
	
	public void setDataIntoexcel(String sheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis1= new FileInputStream("./testdata/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		
		FileOutputStream fos= new FileOutputStream("./testdata/Book2.xlsx");
		wb.close();
	}

}