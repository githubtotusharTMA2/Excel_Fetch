package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExpTest
{
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		Object[][] data = new Object[3][3];
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				data[i][j] = i + j;
			}
		}
		return data;
	}
	
    @Test (dataProvider = "data-provider")
    public void myTest (String a, float b, float c) {
    	System.out.println("a = " + a + " b = " + b + " c = " + c);
    }
}