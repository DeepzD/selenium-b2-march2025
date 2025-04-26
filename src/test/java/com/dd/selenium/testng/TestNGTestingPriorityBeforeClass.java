package com.dd.selenium.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGTestingPriorityBeforeClass extends TestBase {


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
