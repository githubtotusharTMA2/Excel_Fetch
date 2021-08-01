package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.Test_Base;
import pages.FormFilling;
import utils.TestUtils;

public class FormFillingTest extends Test_Base
{
	FormFilling ff;
	String sheetName = "sheet1";
	
	public FormFillingTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		ff = new FormFilling();
	}
	
	@DataProvider(name = "getExcelData")
	public Object[][] getExcelData()
	{
		Object[][] data = TestUtils.excelFetchData(sheetName);
		return data;
	}

	
	@Test(dataProvider = "getExcelData")
	public void formFillTest(String firstName, String lastName, String number, String password, String day, String month, String year, String gender)
	{
		ff.formFillingMethod(firstName, lastName, number, password, day, month, year, gender);
		System.out.println("SUCCESS TMA");
	}
	
	
	
	@AfterMethod
	public void tearDown() throws Exception
	{
		driver.quit();
	}
	
}
