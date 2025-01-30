package org.example.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Test Started: " + result.getName());
        String testName = result.getMethod().getMethodName();
        ExtentReportManager.createTest(testName);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test Success: " + result.getName());
        ExtentReportManager.getTest().pass("Test: " + result.getName() + " passed!");
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test Failure: " + result.getName());
        ExtentReportManager.getTest().fail("Test Failed: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("Test Skipped: " + result.getName());
        ExtentReportManager.getTest().skip("Test: " + result.getName() + " skipped!");
    }

    @Override
    public void onStart(ITestContext context){
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context){
        System.out.println("Test Suite Finished: " + context.getName());
        ExtentReportManager.flushReports();
    }

}

