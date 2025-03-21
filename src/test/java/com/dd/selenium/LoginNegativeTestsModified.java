package com.dd.selenium;

import com.dd.SauceData.SauceTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginNegativeTestsModified {

    WebDriver driver;


    @BeforeMethod
    public void setup()
    {
        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    private void enterCredentials(String username, String password) {
        WebElement txtUserName = driver.findElement(By.id("user-name"));
        WebElement txtPassword = driver.findElement(By.id("password"));

        txtUserName.clear();
        txtPassword.sendKeys(username);

        txtPassword.clear();
        txtPassword.sendKeys(password);

    }

    private void loginBtnClick() {
        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();
    }

    // VALID LOGIN
    @Test
    public void validLogin()
    {
        enterCredentials("standard_user", "secret_sauce");
        loginBtnClick();
    }
    // 01-- Invalid username, correct password
    @Test
    public void invalidUsernameLogin()
    {
        enterCredentials("Deepika","secret_sauce");
        loginBtnClick();

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
        enterCredentials("standard_user","Test123");
        loginBtnClick();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");

    }

    // 03 -- Invalid username and password
    @Test
    public void invalidUsernameAndPasswordLogin()
    {
        enterCredentials("UserOne","Test123");
        loginBtnClick();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");

    }

    // 04 -- Blank username, correct password
    @Test
    public void blankUsernameLogin()
    {
        enterCredentials("","secret_sauce");
        loginBtnClick();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username is required");
    }

    // 05 -- Correct username, blank password
    @Test
    public void blankPasswordLogin()
    {
        enterCredentials("standard_user","");
        loginBtnClick();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Password is required");
    }

    // 06 -- Blank username and password
    @Test
    public void blankUsernameAndPasswordLogin()
    {
        enterCredentials("","");
        loginBtnClick();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username is required");
    }

    // 07 -- Locked-out user attempt
    @Test
    public void LockedoutUserLogin()
    {
        enterCredentials("locked_out_user","secret_sauce");
        loginBtnClick();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Sorry, this user has been locked out.");
    }

    // 08 -- Special characters in username/password
    @Test
    public void testwithSpecialCharacters()
    {
        enterCredentials("1.1","secret_sauce");
        loginBtnClick();

        String errorMessage = errorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");
    }

    // 09 -- Very long username/password
    @Test
    public void logWithLongUsername() {

        enterCredentials("useriuguhoihspoadhaposdhaspjdshdpcjhpvcvpjcvpjchvpocxhvpoxchoihdsi1","secret_sauce");
        loginBtnClick();

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
