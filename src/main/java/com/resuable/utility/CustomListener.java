package com.resuable.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.resuable.actionDriver.Action;
import com.resuable.base.BaseClass;

/**
 *	@author : Vaibhav Nagvekar
 *	@Date : 06 Feb 2022
 **/

public class CustomListener extends BaseClass implements ITestListener {

	Action action= new Action();

	public void onStart(ITestContext context) {
		test = exprep.createTest(context.getName());
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onTestStart(ITestResult result) {
		test = exprep.createTest(result.getName());
		test.createNode(result.getName());
		BaseClass.extentInfoLog(result.getMethod().getDescription(), " : Test is Started");
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is : " + result.getName());
			exprep.flush();
		}
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Failed Test case is : "+result.getName(), ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Test Case Failed : "+result.getThrowable(), ExtentColor.RED));

			String imgPath = action.screenShot(BaseClass.driver, result.getName());
			test.addScreenCaptureFromPath(imgPath);
			exprep.flush();
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is : " + result.getName());
			exprep.flush();
		}
	}

	public void onFinish(ITestContext context) {
		if (exprep != null) {
			exprep.flush();
		}
	}
}
