package com.dd.selenium;

import com.dd.SauceData.SauceTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginNegativeTests {

    WebDriver driver;
    WebElement txtUserName;
    WebElement txtPassword;
    WebElement btnLogin;

    @BeforeMethod
    public void setup()
    {
        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        txtUserName = driver.findElement(By.id("user-name"));
        txtPassword = driver.findElement(By.id("password"));
        btnLogin = driver.findElement(By.id("login-button"));

    }

//    @AfterMethod
//    public void teardown()
//    {
//        driver.quit();
//    }

    // 01-- Invalid username, correct password
    @Test
    public void invalidUsernameLogin()
    {
        txtUserName.sendKeys("Deepika");
        txtPassword.sendKeys("secret_sauce");
        btnLogin.sendKeys(Keys.ENTER);

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");
//        System.out.println(errorMessage);
    }

    private String errorMessage() {

        return driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
    }

    // 02 -- Correct username, invalid password
    @Test
    public void invalidPasswordLogin()
    {
        txtUserName.clear();
        txtUserName.sendKeys("standard_user");
        txtPassword.clear();
        txtPassword.sendKeys("Test123");
        btnLogin.click();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");

    }

    // 03 -- Invalid username and password
    @Test
    public void invalidUsernameAndPasswordLogin()
    {
        txtUserName.clear();
        txtUserName.sendKeys("UserOne");
        txtPassword.clear();
        txtPassword.sendKeys("Test123");
        btnLogin.click();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");

    }

    // 04 -- Blank username, correct password
    @Test
    public void blankUsernameLogin()
    {
        txtUserName.clear();
        txtUserName.sendKeys("");
        txtPassword.clear();
        txtPassword.sendKeys("secret_sauce");
        btnLogin.click();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username is required");
    }

    // 05 -- Correct username, blank password
    @Test
    public void blankPasswordLogin()
    {
        txtUserName.clear();
        txtUserName.sendKeys("standard_user");
        txtPassword.clear();
        txtPassword.sendKeys("");
        btnLogin.click();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Password is required");
    }

    // 06 -- Blank username and password
    @Test
    public void blankUsernameAndPasswordLogin()
    {
        txtUserName.clear();
        txtPassword.clear();
        btnLogin.click();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username is required");
    }

    // 07 -- Locked-out user attempt
    @Test
    public void LockedoutUserLogin()
    {
        txtUserName.clear();
        txtUserName.sendKeys("locked_out_user");
        txtPassword.clear();
        txtPassword.sendKeys("secret_sauce");
        btnLogin.click();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Sorry, this user has been locked out.");
    }

    // 08 -- Special characters in username/password
    @Test
    public void testwithSpecialCharacters()
    {
        txtUserName.clear();
        txtUserName.sendKeys("1");
        txtPassword.clear();
        txtPassword.sendKeys("secret_sauce");
        btnLogin.click();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");
    }

    // 09 -- Very long username/password
    @Test
    public void logWithLongUsername() {
        txtUserName.clear();
        txtUserName.sendKeys("useriuguhoihspoadhaposdhaspjdshdpcjhpvcvpjcvpjchvpocxhvpoxchoihdsio");
        txtPassword.clear();
        txtPassword.sendKeys("secret_sauce");
        btnLogin.click();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    @DataProvider(name="user-credentials")
    public Object[][] userCredentials(){
        return new Object[][]{
                {"","","Epic sadface: Username is required"},
                {"","password","Epic sadface: Username is required"},
                {"standard-user","","Epic sadface: Password is required"}

        };
    }

    @Test(dataProvider="user-credentials", dataProviderClass= SauceTestData.class)
    public void testInvalidLoginScenariosWithDDT(String username, String password, String expectedMessage){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(errorMessage(),expectedMessage);
    }

}
