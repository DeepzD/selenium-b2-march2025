package com.dd.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class InventoryPage {
    private final WebDriver driver;

    By title = By.cssSelector(".title");
    By productsCard = By.xpath("//div[@class='inventory_item']");
    By productsName = By.xpath(".//div[@data-test='inventory-item-name']");
    By addToCartButton = By.xpath("//button[text()='Add to cart']");
    By itemPrice = By.cssSelector("[data-test='inventory-item-price']");
    //By.xpath(".//div[@data-test='inventory-item-price']");
    By productImage = By.tagName("img");
    //.xpath("//div[@class='inventory_item_img']");
    By productDesc = By.cssSelector("[data-test='inventory-item-description']");
    By removeButton = By.xpath("//button[text()='Remove']");
    By shoppingCartIcon = By.xpath("//span[@class='shopping_cart_badge']");
    By shoppingCartBadge = By.cssSelector(".shopping_cart_badge");
    By errorMessage = By.xpath("//h3[@data-test='error']");
    By sortDropdown = By.xpath("//select[@data-test='product-sort-container']");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyAllProductsHaveNamePriceImageDescription() {
        List<WebElement> availableProducts = driver.findElements(productsCard);
        //  Assert.assertFalse(availableProducts.isEmpty(), "No Products found on inventory page");

        for (WebElement productCard : availableProducts) {
            WebElement name = productCard.findElement(productsName);
            WebElement price = productCard.findElement(itemPrice);
            WebElement image = productCard.findElement(productImage);
            WebElement description = productCard.findElement(productDesc);
            System.out.println(name.getText() +  "," + description.getText());
        }

    }

    public String getPageTitle() {
        return driver.findElement(title).getText();
    }

    public void ClickOnImageLink() {
        //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> ImageLinks = driver.findElements(productImage);
        Assert.assertFalse(ImageLinks.isEmpty(), "No Products found on inventory page");

        int size = ImageLinks.size();
        for (int i = 0; i < size; i++) {

            //    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productImage));

            List<WebElement> allImageLinks = driver.findElements(productImage);
            WebElement ImageLink = allImageLinks.get(i);

            ImageLink.click();
            driver.navigate().back();
            //  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productImage));
        }

    }

    public void ClickOnNameLink() {
        List<WebElement> NameLinks = driver.findElements(productsName);
        Assert.assertFalse(NameLinks.isEmpty(), "No Products found on inventory page");

        int size = NameLinks.size();
        for (int i = 0; i < size; i++) {
            List<WebElement> allLinks = driver.findElements(productsName);
            WebElement NameLink = allLinks.get(i);

            NameLink.click();

            driver.navigate().back();
        }

    }
    public void addItemsToCart(List<String> itemsNeeded) {
        //String[] itemsNeeded ={"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt"};
        List<WebElement> eleProducts = driver.findElements(productsName);
        Assert.assertEquals(eleProducts.size(), 6, "Displayed product count");

        for (WebElement eleProduct : eleProducts) {
            // System.out.println(eleProduct.getText());

            if (itemsNeeded.contains(eleProduct.getText())) {
                driver.findElement(addToCartButton).click();
            }
        }
    }

    public void removeItems(double price) {
        List<WebElement> eleProducts = driver.findElements(productsName);
        for (WebElement eleProduct : eleProducts) {
            List<WebElement> removeButtons = driver.findElements(removeButton);
            {
                if (!removeButtons.isEmpty()) {
                    String PriceText = eleProduct.findElement(itemPrice).getText();
                    double Price = Double.parseDouble(PriceText.replace("$", " "));
                    if (Price > price) {
                        driver.findElement(removeButton).click();
                    }
                }

            }
        }
    }

    public void clickOnShoppingCartIcon() {
        driver.findElement(shoppingCartIcon).click();
    }

    public int ShoppingCart_itemCount() {
        String itemCount = driver.findElement(shoppingCartBadge).getText();
        return Integer.parseInt(itemCount);
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void sortProductList(String optionValue) {
        WebElement sortContainer = driver.findElement(sortDropdown);
        Select select = new Select(sortContainer);
        select.selectByValue(optionValue);

        List<WebElement> sortedListZ_A = driver.findElements(productsName);
        //List<String> sortedListNamesZ_A = new ArrayList<>();
        for (WebElement sortedItemZ_A : sortedListZ_A) {
            System.out.println(sortedItemZ_A.getText());
        }

    }
}
