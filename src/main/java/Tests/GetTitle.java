package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.ExcelReaderUtility;

public class GetTitle extends BaseClass {

	public GetTitle() throws IOException {
		super();
	}

	HomePage home;
	@Test(dataProvider = "getExcelData",dataProviderClass = ExcelReaderUtility.class)
	public void launchBrowser(String email,String pass) throws InterruptedException, IOException {
        home=new HomePage();
		Assert.assertEquals(home.getTitle(), "Facebook – log in or sign up");
		home.enterEmail(email);
		home.enterPassword(pass);
		Thread.sleep(2000);
	}

}
