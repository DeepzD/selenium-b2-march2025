package com.dd.selenium.testng;

import net.bytebuddy.build.Plugin;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTestingPriority {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("TestNGEampleOne.beforeMethod");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("TestNGEampleOne.afterMethod");
    }

    @Test
    public void testMethodOne() {
        System.out.println("TestNGEampleOne.testMethodOne");
    }

    @Test(priority=1)
    public void testMethodTwo() {
        System.out.println("TestNGEampleOne.testMethodTwo");
    }

    @Test
    public void testMethodThree() {
        System.out.println("TestNGEampleOne.testMethodThree");
    }

    @Test(priority=2)
    public void testMethodFour() {
        System.out.println("TestNGEampleOne.testMethodFour");
    }
}
