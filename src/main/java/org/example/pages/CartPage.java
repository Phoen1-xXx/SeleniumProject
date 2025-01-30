package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(className = "inventory_item_name")
    WebElement itemName;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String  getAddedElementName(){
        return itemName.getText();
    }

}
