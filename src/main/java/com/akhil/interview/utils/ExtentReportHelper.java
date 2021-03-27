package com.akhil.interview.utils;

import com.akhil.interview.pages.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;



public class ExtentReportHelper
{

    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentSparkReporter spark;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String testName;

    /* method will instantiate the Extent report for reporting  */
    public  static void initReport(){
        if(Objects.isNull(extent)){
            extent = new ExtentReports();
            spark = new ExtentSparkReporter("./report/auto-report.html");
            extent.attachReporter(spark);
        }
    }

    public void flushReport(){
        if(Objects.nonNull(extent)){
            extent.flush();
        }
    }

    public static void createTest(String testInfo){
        test = extent.createTest(testInfo.replace("(","").replace(")",""),("TEST EXECUTION STARTED"));
    }

    public void stepPass(String message,Boolean screenShotReq){
        test = screenShotReq ? test.pass(message , MediaEntityBuilder.createScreenCaptureFromPath("."+captureScreenShot("Screenshot")).build()) :
                test.pass(message);
    }

    public void stepFail(Throwable e){
        test = test.fail(e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath("."+captureScreenShot("Screenshot")).build());
    }

    public void stepFail(String e){
        test = test.fail("STEP_FAIL "+e, MediaEntityBuilder.createScreenCaptureFromPath("."+captureScreenShot("Screenshot")).build());
    }

    public void logInfo(String message){
        test = test.info(message);
    }

    /* method will capture screen shot of the current page
    *  @param fileName - Screenshot file name
    *  @return         - Absolute path of the screenshot
    *   */
    public String captureScreenShot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot)BasePage.driver;
        File source = (File)ts.getScreenshotAs(OutputType.FILE);
        fileName += UUID.randomUUID().toString();
        String dest = ".\\img\\" + fileName + ".png";
        File targetFile = new File(dest);
        try {
            FileUtils.copyFile(source, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dest;
    }

}
