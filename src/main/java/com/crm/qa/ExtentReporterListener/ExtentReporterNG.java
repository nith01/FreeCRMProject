package com.crm.qa.ExtentReporterListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    static ExtentReports extent;
    public static ExtentReports getReportObject(){

        //this method helps in configuring the report(name of the report,title,author, where to create report)
        String path = System.getProperty("user.dir")+"\\reports\\Extent.html";   //location for the ExtentReport
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);    //creating object for ExtentSparkReporter
        reporter.config().setReportName("Web Automation results");    //we can configure ExtentReport page using reporter.config()method
        reporter.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Nitha");//C:\Users\nitha\IdeaFrameworkProjects\reports\Extent.html
        return extent;

    }
}
