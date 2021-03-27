package com.akhil.interview.Runner;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.*;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@ExcludeTags( "prod")
@SelectClasses( {com.akhil.interview.steps.LoginPage.LoginTest.class,com.akhil.interview.steps.RegisterPage.RegisterTest.class})
public class JunitTestRunner  {
}
