package com.akhil.interview.steps;

import com.akhil.interview.pages.BasePage;
import com.akhil.interview.utils.BrowserUtils;
import com.akhil.interview.utils.ExtentReportHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.util.concurrent.TimeUnit;

import static com.akhil.interview.pages.BasePage.getPropertyValue;
import static com.akhil.interview.utils.ExtentReportHelper.initReport;

public class BaseTest extends BrowserUtils
{
    public static String APPLICATION_PROP_FILE = System.getProperty("user.dir")+"//src//main//resources//application.properties";

    @BeforeEach
    public void testInit(TestInfo testInfo){
        ExtentReportHelper.createTest(testInfo.getTestMethod().get().getName());
    }

    @BeforeAll
    public static void setUp() {
        initReport();
        String browserName = getPropertyValue(APPLICATION_PROP_FILE, "browser.name");
        String path = getPropertyValue(APPLICATION_PROP_FILE, "driver.path");
        driver = initiateBrowser(browserName,path);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        BasePage.driver = driver;
    }
}
