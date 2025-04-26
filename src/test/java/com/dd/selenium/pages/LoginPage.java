package com.dd.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "user-name")
    WebElement eleUsername;

    @FindBy(id = "password")
    WebElement elePassword;

    @FindBy(id = "login-button")
    WebElement eleLoginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public LoginPage typeUsername(String username) {
        eleUsername.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        elePassword.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        eleLoginButton.click();
    }

    public void login(String username, String password)
    {
        this.typeUsername(username).typePassword(password).clickLoginButton();
    }
    public String getError() {
        return errorMessage.getText();
    }

}
