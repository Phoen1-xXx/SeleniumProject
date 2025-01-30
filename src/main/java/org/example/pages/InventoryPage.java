package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class InventoryPage extends BasePage {

    @FindBy(id = "shopping_cart_container")
    WebElement shoppingCart;

    protected char itemID;
    private String itemLink = "item_5_title_link";


    public InventoryPage(WebDriver driver, char itemID) {
        super(driver);
        this.itemID = itemID;
        this.itemLink = itemLink.replace('5',itemID);
    }

    public String getItemName(){
        By inventoryItem5 = By.id(itemLink);
        return driver.findElement(inventoryItem5).getText();
    }

    public void addToCart(String locator){
        By buttonId = By.id(locator);
        driver.findElement(buttonId).click();
    }

    public void goToCart(){
        shoppingCart.click();
    }

}
