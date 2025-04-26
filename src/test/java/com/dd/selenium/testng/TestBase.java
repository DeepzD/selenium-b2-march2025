package com.dd.selenium.testng;

import org.testng.annotations.*;

public class TestBase {


    @BeforeSuite
    public void beforeSuite() {
        System.out.println("TestNGEampleOne.beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("TestNGEampleOne.afterSuite");
    }

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("TestNGEampleOne.beforeClass");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("TestNGEampleOne.afterClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("TestNGEampleOne.beforeMethod");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("TestNGEampleOne.afterMethod");
    }


}


