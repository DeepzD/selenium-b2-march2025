package com.dd.selenium;

import com.dd.selenium.util.BrowserFactory;
import com.dd.selenium.util.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HelloSeleniumTest {

    @Parameters({"browser"})
    @Test
    public void testHelloSelenium() {

        //Launching a browser instance
        //logger.infor("Initializing a web browser");

        WebDriver driver;

        BrowserFactory.init(ConfigReader.getBrowser());
        driver = BrowserFactory.getDriver();

        driver.get(ConfigReader.getBaseURL());
        driver.manage().window().maximize();

        // type username
        WebElement txtUsername = driver.findElement(By.id("user-name"));
        txtUsername.sendKeys("standard_user");

        //enter password
        WebElement txtPassword = driver.findElement(By.id("password"));
        txtPassword.sendKeys("secret_sauce");

        // click login button
        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        String pageTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(pageTitle,"Products");
    }


}
