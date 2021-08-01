package experiment;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Experiment
{
	public static void main(String gsar[])
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
			
			XSSFSheet sheet = wb.getSheet("sheet1");
			
			int number_of_rows = sheet.getLastRowNum() + 1;
			int number_of_col = sheet.getRow(0).getLastCellNum();

			System.out.println("number_of_rows = " + number_of_rows);
			System.out.println("number_of_col = " + number_of_col);
			
			
			Object[][] data = new Object[number_of_rows][number_of_col];
			
			for(int i = 0; i < number_of_rows; i++)
			{
				for(int j = 0; j < number_of_col; j++)
				{
					data[i][j] = sheet.getRow(i).getCell(j);
					System.out.print(data[i][j] + " 	");
				}
				System.out.println();
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
