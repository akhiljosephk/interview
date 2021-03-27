package com.akhil.interview.pages.LoginPage;

import com.akhil.interview.pages.BasePage;
import com.akhil.interview.utils.ExtentReportHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

    @FindBy(name = "userName")
    private WebElement userNameTxtBx;

    @FindBy(name = "password")
    private WebElement passwordTxtBx;

    @FindBy(name ="submit")
    private WebElement submitBtn;

    @FindBy(xpath = "//td/h3")
    private WebElement msgElement;

    @FindBy(xpath = "//span[contains(text(),'Enter your userName and password correct')]")
    private WebElement errorMsg;

    private void performLogin(String userN, String passW){
        clearAndSendKeysTo(userNameTxtBx,userN);
        clearAndSendKeysTo(passwordTxtBx,passW);
        clickElement(submitBtn);
    }

    public void verifyLogin(String userN, String passW) {
//        ExtentReportHelper helper = new ExtentReportHelper();
        performLogin(userN,passW);
        custom_assertTrue(msgElement.getText(),"Login Successfully","Login assertion for Username "+userN+" and password "+passW);
//        helper.stepPass("Step pass for "+userN+" and pass "+passW,true);
    }

    public void verifyLoginFail(String userN, String passW) {
//        ExtentReportHelper helper = new ExtentReportHelper();
        performLogin(userN,passW);
        custom_assertTrue(errorMsg.getText().trim(),"Enter your userName and password correct","Login assertion for Username "+userN+" and password "+passW);
//        helper.stepPass("Step pass for "+userN+" and pass "+passW,true);
    }
}
