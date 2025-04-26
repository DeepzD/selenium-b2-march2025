package com.dd.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class javaScriptPopupTest {

   WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @Test
    public void testJavaScriptAlerts(){
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();
        String alertTest = alert.getText();
        Assert.assertEquals(alertTest, "I am a JS Alert");
        alert.accept();

       String ResultMessage = driver.findElement(By.cssSelector("#result")).getText();
       Assert.assertEquals(ResultMessage, "You successfully clicked an alert");
    }
    @Test
    public void testJavaScriptConfirmOK(){
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        String ConfirmText = alert.getText();
        Assert.assertEquals(ConfirmText, "I am a JS Confirm");
        alert.accept();

        String ConfirmMessage = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(ConfirmMessage, "You clicked: Ok");
    }

    @Test
    public void testJavaScriptConfirmCancel(){
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        String ConfirmText = alert.getText();
        Assert.assertEquals(ConfirmText, "I am a JS Confirm");
        alert.dismiss();

        String ConfirmMessage = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(ConfirmMessage, "You clicked: Cancel");
    }

    @Test
    public void testJavaScriptPrompt(){
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        String ConfirmText = alert.getText();
        Assert.assertEquals(ConfirmText, "I am a JS prompt");
        alert.sendKeys("Selenium");
        alert.accept();

        String ConfirmMessage = driver.findElement(By.cssSelector("#result")).getText();
        Assert.assertEquals(ConfirmMessage, "You entered: Selenium");
    }
}
