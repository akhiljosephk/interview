package com.akhil.interview.utils;

import com.akhil.interview.steps.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.akhil.interview.pages.BasePage.getPropertyValue;
import static org.junit.jupiter.api.Assertions.fail;

public class BrowserUtils
{
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    /* This method will instantiate the requested provided in application.properties
     @param browserName - The name of the browser
     @param path        - location of browser driver
     @return            - webdriver instance
    */
    protected static WebDriver initiateBrowser(String browserName,String path)  {
        WebDriver driver = null;
        String brow = "webdriver.%s.driver";
        switch (browserName.toLowerCase()){
            case "chrome":
	        	System.setProperty(String.format(brow, "chrome"), path);
                driver = new ChromeDriver();
                break;
            default:
                fail("TO DO BROWSER IMPLEMENTATION");
        }
        return driver;
    }

    /* This method is used to navigate to the base url provided in application.properties */

    public static void navigateToURL(){
        String url = getPropertyValue(BaseTest.APPLICATION_PROP_FILE, "base.url");
        getDriver().manage().window().maximize();
        getDriver().get(url);
    }


    @AfterAll
    public static  void flushExt(){
        ExtentReportHelper helper = new ExtentReportHelper();
        helper.flushReport();
        driver.quit();
        driver=null;
    }

}






