package com.dd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://pragmatictesters.github.io/selenium-synchronization/buttons.html");
        driver.manage().window().maximize();
    }


    @Test
    public void testButtonWithThreadSleep() throws InterruptedException {
        Thread.sleep(1000);   // DO NOT USE THREADS
        driver.findElement(By.id("easy00")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("easy01")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("easy02")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("easy03")).click();
        String message=driver.findElement(By.id("easybuttonmessage")).getText();
        Assert.assertEquals(message,"All Buttons Clicked");
}


    @Test
    public void testButtonWithImplicitWait(){
        //driver.manage().timeouts().implicitlyWait(10,.TimeUnit.SECONDS); Deprecated
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("easy00")).click();
        driver.findElement(By.id("easy01")).click();
        driver.findElement(By.id("easy02")).click();
        driver.findElement(By.id("easy03")).click();
        String message=driver.findElement(By.id("easybuttonmessage")).getText();
        Assert.assertEquals(message,"All Buttons Clicked");
}

    @Test
    public void testButtonWithExplicitWait(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("easy00"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("easy01"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("easy02"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("easy03"))).click();
        String message=driver.findElement(By.id("easybuttonmessage")).getText();
        Assert.assertEquals(message,"All Buttons Clicked");
    }

    @Test
    public void testWithFluentWait(){
        WebDriverWait wait =(WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds((5))).
                pollingEvery(Duration.ofMillis(10)).withMessage("<<==  Element was not Visible ==>>").
                ignoring(ElementNotInteractableException.class);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("easy00"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("easy01"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("easy02"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("easy03"))).click();
        wait.until(ExpectedConditions.textToBe(By.id("easybuttonmessage"),"All buttons Clicked"));

    }
    @AfterMethod(alwaysRun = true)
    public void teardown()
    {
    if(driver!=null){
        driver.quit();
    }
   }
}
