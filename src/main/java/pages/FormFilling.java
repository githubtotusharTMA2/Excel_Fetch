package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Test_Base;

public class FormFilling extends Test_Base
{
	@FindBy(xpath = "//a[contains(text(), 'English (UK)')]")
	WebElement englishButton;
	
	@FindBy(xpath = "//a[@data-testid = 'open-registration-form-button'and @role = 'button']")
	WebElement createAccButton;
	
	@FindBy(name = "firstname")
	WebElement firstName;
	
	@FindBy(name = "lastname")
	WebElement surname;
	
	@FindBy(name = "reg_email__")
	WebElement phnNo;
	
	@FindBy(name = "reg_passwd__")
	WebElement password;
	
	@FindBy(xpath = "//select[@id = 'day']")
	WebElement day;
	
	@FindBy(id = "month")
	WebElement month;
	
	@FindBy(id = "year")
	WebElement year;
	
	@FindBy(xpath = "//input[@type = 'radio' and @value = '1']")
	WebElement women;
	
	@FindBy(xpath = "//input[@type = 'radio' and @value = '2']")
	WebElement man;
	
	@FindBy(xpath = "//input[@type = 'radio' and @value = '-1']")
	WebElement custom;
	
	public FormFilling()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void formFillingMethod(String firstN, String lastN, String no, String pwd, String daY, String montH, String yeaR, String gender)
	{
		float d = Float.parseFloat(daY);
		float y = Float.parseFloat(yeaR);
		int dd = (int)d;
		int yy = (int)y;
		String ddd = Integer.toString(dd);
		String yyy = Integer.toString(yy);
		
		englishButton.click();
		createAccButton.click();
		firstName.sendKeys(firstN);
		surname.sendKeys(lastN);
		phnNo.sendKeys(no);
		password.sendKeys(pwd);
		new Select(day).selectByVisibleText(ddd);
		new Select(month).selectByVisibleText(montH);
		new Select(year).selectByVisibleText(yyy);
		
		switch(gender)
		{
		case "women" 	: 	women.click(); 		break;
		case "male" 	: 	man.click(); 		break;
		case "custom" 	: 	custom.click(); 	break;
		}
		
	}
	
	
	
}
