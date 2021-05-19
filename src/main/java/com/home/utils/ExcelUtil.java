package com.home.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Objects;

public class ExcelUtil {

	private ExcelUtil() {}

	public static List<Map<String, String>> getTestDetails(String sheetName)
	{
		Map<String,String> testcases = null;
		List<Map<String, String>> list = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/Tests/TestCases.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);

			int cols=sheet.getRow(0).getLastCellNum();
			int rows=sheet.getLastRowNum();

			list = new ArrayList<>();
			for(int i=1;i<=rows;i++)
			{
				testcases = new HashMap<>();
				for(int j=0;j<cols;j++)
				{				
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					testcases.put(key, value);

				}
				list.add(testcases);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(Objects.nonNull(fis))
				{
					fis.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}


		return list;


	}

}
