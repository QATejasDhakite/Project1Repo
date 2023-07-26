package Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
	
	public static ExtentReports report;
	
	public static ExtentReports getReportInstance()
	{ 
		if(report==null)
		{
			String d = new SimpleDateFormat("dd-MM-yyyy ss-mm-HH").format(new Date());
			String reportName = d.toString();
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\tejas\\eclipse-workspace3\\ChannelProject\\ExtentReports\\"+ reportName + ".html");
            report = new ExtentReports();
            report.attachReporter(htmlReporter);
     
            report.setSystemInfo("OS", "Win");
            report.setSystemInfo("Enviornment", "Production");
            report.setSystemInfo("Build Number", "7.11");
             report.setSystemInfo("Browser", "Chrome");
     
     htmlReporter.config().setDocumentTitle("UI Automation");
     htmlReporter.config().setDocumentTitle("UI Test Report");
		}
		return report;
		
		}

}
