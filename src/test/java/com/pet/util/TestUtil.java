package com.pet.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class TestUtil {
	
	public static String TESTDATA_SHEEET_PATH = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx";
	
	public static String[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException{
		File f = new File(TESTDATA_SHEEET_PATH);
		FileInputStream fis = new FileInputStream(f);
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int totalRows = sheet.getLastRowNum();
		Row rowCells = sheet.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		
		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRows][totalCols];
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				testData[i-1][j]=format.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		 for(int i=1;i<=totalRows;i++) 	         
				for (int j=0;j<totalCols;j++) 
					System.out.println(testData[i-1][j]);
				
		return testData;
	}

}
