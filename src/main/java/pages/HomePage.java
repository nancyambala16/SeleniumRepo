package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tests.BaseClass;

public class HomePage extends BaseClass{

	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement password;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterEmail(String emailid)
	{
		email.clear();
		email.sendKeys(emailid);
	}
	
	public void enterPassword(String pass)
	{
		password.clear();
		password.sendKeys(pass);		
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}

}
