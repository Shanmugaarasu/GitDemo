package Shanmugaarasu.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtenReporterNG {

	
	public static ExtentReports getreportobject()
{
	String path = System.getProperty("user.dir")+"//reports//index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web automation results");
	reporter.config().setDocumentTitle("Test Results");
		
	ExtentReports extent = new ExtentReports();	
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Shanmugaarasu");
	extent.createTest(path);
	return extent;
}
}
