package com.dd.steps;
import com.dd.selenium.pages.InventoryPage;
import com.dd.selenium.pages.LoginPage;
import com.dd.selenium.util.BrowserFactory;
import com.dd.selenium.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginSteps {

   LoginPage loginPage;

   @Before
   public void before()
   {
       BrowserFactory.init(ConfigReader.getBrowser());
       BrowserFactory.getDriver().get(ConfigReader.getBaseURL());
   }

   @After
   public void after()
   {
       BrowserFactory.close();
   }
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {

        loginPage =new LoginPage(BrowserFactory.getDriver());
    }

    @When("the user enters the valid credentials")
    public void theUserEntersTheValidCredentials() {
       loginPage.login(ConfigReader.get("username"),ConfigReader.get("password"));
    }

    @Then("the user should be redirected to the homepage")
    public void theUserShouldBeRedirectedToTheHomepage() {
        InventoryPage inventoryPage = new InventoryPage(BrowserFactory.getDriver());
        Assert.assertEquals(inventoryPage.getPageTitle(),"Products","Title is incorrect");
    }
}
