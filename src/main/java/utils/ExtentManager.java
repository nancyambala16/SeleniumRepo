package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	
	public static void setExtent()
	{
		  htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+System.currentTimeMillis()+".html");
		  htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		  extentReport = new ExtentReports();
		  extentReport.attachReporter(htmlReporter);
		  
		  extentReport.setSystemInfo("browser", "chrome");
		  extentReport.setSystemInfo("os", "mac");
		  extentReport.setSystemInfo("tester", "nancy");
	}
	
	public static void endReport()
	{
		extentReport.flush();
	}

}
