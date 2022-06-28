package Tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentManager;
import utils.Utils;

public class BaseClass {

	Utils utils = new Utils();

	public static WebDriver driver;
	Properties prop;
	
	public BaseClass() throws IOException {
		 prop = utils.loadConfig();
		}

	@BeforeSuite
	public void beforeSuite() throws IOException {
		ExtentManager.setExtent();
      
	}

	@BeforeMethod
	public void setup()  {
		if (prop.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		}
		driver.get(prop.getProperty("url"));
	}



	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

	@AfterSuite
	public void publishReports()
	{
		ExtentManager.endReport();
	}
}
