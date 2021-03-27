package com.akhil.interview.pages;

import com.akhil.interview.utils.AutomationException;
import com.akhil.interview.utils.ExtentReportHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.opentest4j.AssertionFailedError;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class BasePage
{
    public static WebDriver driver;

    public BasePage(){
        PageFactory.initElements(driver,this);
    }

    /* method will read property file
     *  @param propertyFile - Property file Name with path
     *  @param propKey      - key for required property file
     *  @return          - value for provided key
     *   */
    public static String getPropertyValue(String propertyFile,String propKey)  {
        String retVal = null;
        try (InputStream input = new FileInputStream(propertyFile)) {
            Properties prop = new Properties();
            prop.load(input);
            retVal = prop.getProperty(propKey);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            if(retVal==null)
                throw new AutomationException("No entry found for key "+propKey+" in property file");
        }catch(AutomationException e) {

            e.printStackTrace();
        }
        return retVal;
    }

    /* method will clear and enter value in a text field
     *  @param to - Webelement to enter value
     *  @param keys      - value to enter in to Web Element
     *   */
    protected void clearAndSendKeysTo(WebElement to, CharSequence keys) {
        try {
            to.clear();
            to.sendKeys(keys);
        } catch (Exception e) {
            ExtentReportHelper helper = new ExtentReportHelper();
            helper.stepFail(e);
        }
    }

    /* method will click a webelement
     *  @param element - Webelement to click
     *   */
    public void clickElement(WebElement element){
        try{
            element.click();
        }catch (Exception e){
            ExtentReportHelper helper = new ExtentReportHelper();
            helper.stepFail(e);
        }
    }

    public void custom_assertTrue(String expected,String actual,String message){
        ExtentReportHelper helper = new ExtentReportHelper();
        try {
            Assertions.assertEquals(expected, actual);
            helper.stepPass(message,true);
        }catch (AssertionFailedError e){
            helper.stepFail(e);
        }
    }

}
