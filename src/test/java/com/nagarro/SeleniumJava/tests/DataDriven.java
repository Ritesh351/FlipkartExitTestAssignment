package com.nagarro.SeleniumJava.tests;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	private static Map<String, String> testCaseMap = null;
	
	public static String isExecuteCase(String key) {
		if(testCaseMap == null)
		{
			try {
				main(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return "No";
			}
		}
		String value = testCaseMap.get(key);
		if(value == null)
			return "No";
		return value;
		
	}
	//C://Users//riteshgupta03//Documents//TestData.xlsx
	public static void main(String args[]) throws IOException {
		FileInputStream fis = new FileInputStream(".//TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator();

		testCaseMap = new HashMap<>();
		while (rows.hasNext()) {
			Row row = rows.next();
			testCaseMap.put(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue());

		}
		workbook.close();
	}
}
