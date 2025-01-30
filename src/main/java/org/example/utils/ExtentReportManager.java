package org.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getExtentReports(){
        if (extent==null){
//            Place where will created report generate
            String reportPath = System.getProperty("user.dir") + "/report/ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

//            Report Name
            sparkReporter.config().setReportName("Automation Test Report");
//            Report Title
            sparkReporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
//            Env
            extent.setSystemInfo("Environment","QA");
//            Tester Name ( Better way is if we take username from computer system
            extent.setSystemInfo("QA Engineer", "Aleksandre Soselia");
        }
        return extent;
    }

    //  Create a test
    public static ExtentTest createTest(String testName){
        ExtentTest extentTest = getExtentReports().createTest(testName);
        test.set(extentTest);
        return extentTest;
    }

    //    Get the current test
    public static ExtentTest getTest(){return test.get();}


    public static void flushReports(){
        if (extent != null){
            extent.flush();
        }
    }
}
