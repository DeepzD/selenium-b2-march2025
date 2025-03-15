package com.dd.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class javaScriptPopupTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

//    @Test
//    public void testjavaScriptAlerts(){
//        clickButton();
//        Alert alert = driver.switchTo().alert();
//        String alertMessage = alert.getText();
//        Assert.assertEquals(alertMessage,"Hello World!");
//        alert.accept();
//        String message = driver.findElement().getText();
//        Assert.assertEquals(message,"Hello World!");
//
//    }
//
//    private void clickButton() {
//    }
}
