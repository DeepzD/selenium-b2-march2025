package com.dd.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SelectItemsDropDown {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://pragmatictesters.github.io/selenium-webdriver-examples/dropdowns.html");
        driver.manage().window().maximize();
    }

//    @AfterMethod
//    public void teardown()
//    {
//    if(driver!=null){
//        driver.quit();
//    }
//   }

    @Test
    public void testSingleSelect() {
        //Locaste the select element
        WebElement ddl_singleselect = driver.findElement(By.id("singleSelect"));
        //Cast the element to select
        Select select = new Select(ddl_singleselect);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Select a fruit");

        //Select the tem by the visible text
        select.selectByContainsVisibleText("Apple");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Apple");

        //Select the item by Value
        select.selectByValue("banana");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Banana");

        //Select Item by index
        select.selectByIndex(4);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Date");

        List<WebElement> alloptions = select.getOptions();
        for (WebElement fruits : alloptions) {
            System.out.println(fruits.getText());
        }
    }

    @Test
    public void testMultiSelect() {
        WebElement ddl_multiSelect = driver.findElement(By.id("multiSelect"));
        Select multiSelect = new Select(ddl_multiSelect);

        multiSelect.selectByIndex(1);
        multiSelect.selectByVisibleText("Red");
        multiSelect.selectByValue("purple");

       // Assert.assertEquals(multiSelect.getAllSelectedOptions(), Arrays.asList("Green","Red","Purple"));

        multiSelect.deselectAll();
    }
}