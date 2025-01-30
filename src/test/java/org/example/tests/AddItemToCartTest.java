package org.example.tests;

import com.beust.jcommander.Parameter;
import org.example.BaseTest;
import org.example.pages.CartPage;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.example.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddItemToCartTest extends BaseTest {

//  Add item to cart and check if it's added
    @Test()
    public void addCartTest(){
//      login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Utils.log("Login Successfully");

/** id's for items
 *  0 - Sauce Labs Bike Light
 *  1 - Sauce Labs Bolt T-Shirt
 *  2 - Sauce Labs Onesie
 *  3 - Test.allTheThings() T-Shirt (Red)
 *  4 - Sauce Labs Backpack
 *  5 - Sauce Labs Fleece Jacket
 * **/
//      Get item Name
        InventoryPage inventoryPage = new InventoryPage(driver, '0');
        String itemName = inventoryPage.getItemName();
        Utils.log("Get Name: " + itemName);

//      Add item to cart
        String buttonId = "add-to-cart-" + itemName.toLowerCase().replace(" ", "-");
        inventoryPage.addToCart(buttonId);
        Utils.log("Add: " + itemName + "to cart.");

//      Go to cart page
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);

        String expectedName = itemName;
        String actualName = cartPage.getAddedElementName();
        Assert.assertEquals(actualName,expectedName);

    }

}
