package com.dd.selenium.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CrossBrowserTest {

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
    @Test
    public void testLoginWithChrome(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(actualTitle,"Products","Login filed: unexpected page title.");

    }

    @Test
    public void testLoginWithChromeHeadless(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(actualTitle,"Products","Login filed: unexpected page title.");

    }

    @Test
    public void testLoginWithFirefox(){
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(actualTitle,"Products","Login filed: unexpected page title.");

    }

    @Test
    public void testLoginWithFirefoxHeadless(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless"); // run without opening graphical user interface

        driver = new FirefoxDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(actualTitle,"Products","Login filed: unexpected page title.");

    }
    @Test
    public void testLoginWithEdge(){
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(actualTitle,"Products","Login filed: unexpected page title.");

    }

    @Test
    public void testLoginWithEdgeHeadless(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(actualTitle,"Products","Login filed: unexpected page title.");

    }

    @Test
    public void testLoginWithSafari(){
        driver = new SafariDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actualTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(actualTitle,"Products","Login filed: unexpected page title.");

    }
}
