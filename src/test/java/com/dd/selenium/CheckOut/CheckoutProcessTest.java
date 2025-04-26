package com.dd.selenium.CheckOut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CheckoutProcessTest {

     WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @Test
    public void validLogin()
    {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        addItems();
        clickOnShoppingCart();
        checkOut();
    }


    public void addItems()
    {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public void clickOnShoppingCart()
    {
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
    }

    public void checkOut()
    {
        driver.findElement(By.id("checkout")).click();
    }

    public void fillCheckOutInfo()
    {
      //  String firstName = RandomData.getFirstname();

    }
}
