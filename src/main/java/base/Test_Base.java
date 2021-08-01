package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.TestUtils;

public class Test_Base
{
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Test_Base()
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("E:\\QA_Infotech\\Training_Works\\Eclipse\\Workspace_2\\Projects\\Excel_Fetch\\src\\main\\java\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\QA_Infotech\\Training_Works\\Eclipse\\Utils\\Selenium_browser_drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName == "Firefox")
		{
			System.setProperty("webdriver.gecko.driver", "E:\\QA_Infotech\\Training_Works\\Eclipse\\Utils\\Selenium_browser_drivers\\geckodriver\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
}
