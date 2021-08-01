package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtils
{
	public static int PAGE_LOAD_TIMEOUT = 10;
	public static int IMPLICIT_WAIT = 10;

	public static Object[][] excelFetchData(String sheetName)
	{
		
		try
		{
			File src = new File("E:\\QA_Infotech\\Training_Works\\Eclipse\\Workspace_2\\Projects\\Excel_Fetch\\src\\main\\java\\test_data\\Facebook_Form.xlsx");
			
			FileInputStream fis = new FileInputStream(src);
			
			XSSFWorkbook wb = null;
			
			try
			{
				wb = new XSSFWorkbook(fis);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			XSSFSheet sheet = wb.getSheet(sheetName);
			
			int number_of_rows = sheet.getLastRowNum() + 1;
			int number_of_col = sheet.getRow(0).getLastCellNum();

			Object[][] data = new Object[number_of_rows][number_of_col];
			
			for(int i = 0; i < number_of_rows; i++)
				for(int j = 0; j < number_of_col; j++)
					data[i][j] = sheet.getRow(i).getCell(j).toString();
			
			return data;
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
			
		Object[][] data = null;
		return data;
	
	}
}
