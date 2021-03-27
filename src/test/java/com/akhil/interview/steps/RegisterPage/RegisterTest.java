package com.akhil.interview.steps.RegisterPage;

import com.akhil.interview.steps.BaseTest;
import com.akhil.interview.utils.BrowserUtils;
import com.akhil.interview.utils.ExtentReportHelper;
import org.junit.jupiter.api.Test;

public class RegisterTest extends BaseTest {

    ExtentReportHelper helper = new ExtentReportHelper();

    @Test
    public void fail_registration(){
        navigateToURL();
        helper.stepFail("Test FAIL Demo");
    }
}
