package com.resuable.utility;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

/**
 *	@author : Vaibhav Nagvekar
 *	@Date : 06 Feb 2022
 **/

public class ExtentManager {

	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public static ExtentReports setExtent() {
		
		extent = new ExtentReports();
		
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReport/"+"AutomationReport.html")
				.viewConfigurer()
				.viewOrder()
				.as(new ViewName[] { 
						ViewName.DASHBOARD, 
						ViewName.TEST, 
						ViewName.CATEGORY, 
						ViewName.AUTHOR, 
						ViewName.DEVICE, 
						ViewName.EXCEPTION, 
						ViewName.LOG })
				.apply();
		spark.config().setEncoding("utf-8");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Automation Report");

		extent = new ExtentReports();
		extent.attachReporter(spark);

		extent.setSystemInfo("ProjectName", "Facebook");
		extent.setSystemInfo("Tester", "QA Team");
		extent.setSystemInfo("OS", "Win11");
		extent.setSystemInfo("Browser", "Chrome");
		return extent;
	}

	@AfterTest
	public static void endReport() {
		extent.removeTest(test);
		extent.flush();
	}
}
