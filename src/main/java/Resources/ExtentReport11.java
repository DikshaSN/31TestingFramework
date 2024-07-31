package Resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport11 {

	public static ExtentReports getReportObject() {
		String file = "D:\\Selenium\\Scripts\\31TestFramework\\Report\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(file);
		reporter.config().setDocumentTitle("Testing 31 July");
		reporter.config().setReportName("Testing 31 July");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Diksha Kamdi");
		
		return extent;
	}
}
