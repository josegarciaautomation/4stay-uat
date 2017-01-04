package com.fourstay.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileUtils {
	// apache poi library is used to connect to excel file
	
	public static String[][] getExcelData(String filePath, String sheetName) {
		// connects to a file
		FileInputStream fileInputStream = null;
		// create actual excel file
		XSSFWorkbook workBook = null;
		try {
			fileInputStream = new FileInputStream(filePath);
			workBook = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// create worksheet object
		XSSFSheet sheet = workBook.getSheet(sheetName);
		// number of rows
		int numberOfRows = sheet.getLastRowNum()+1;
		// get number of columns
		int numberOfColunms = sheet.getRow(0).getLastCellNum();
		
		// Create a 2D array
		String[][] array = new String[numberOfRows][numberOfColunms];
		
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColunms; j++) {
				// read data using the index
				// save the data in the corresponding index of the array
				array[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}	
		}
	
		close(fileInputStream);
		return array;
	}
	
	private static void close(FileInputStream fileInputStream) {
		try {
			fileInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
