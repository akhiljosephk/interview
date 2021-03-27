package com.akhil.interview.steps.LoginPage;

import com.akhil.interview.pages.LoginPage.LoginPage;
import com.akhil.interview.steps.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTest extends BaseTest
{

    @Tag("demo")
    @Test
    public void login_HappyPath(){
        navigateToURL();
        LoginPage loginPage = new LoginPage();
        loginPage.verifyLogin("root","root");
    }

    @Tag("demo")
    @Test
    public void login_NegativePath(){
        navigateToURL();
        LoginPage loginPage = new LoginPage();
        loginPage.verifyLoginFail("root1","root1");
    }

    @Tag("prod")
    @Test
    public void login1(){
        System.out.println("Akil11 Tested");
    }

}
