package com.dd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloSeleniumTest {

    @Test
    public void testHelloSelenium() {

        //Launching a browser instance
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
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
