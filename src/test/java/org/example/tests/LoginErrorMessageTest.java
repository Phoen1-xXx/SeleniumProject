package org.example.tests;

import org.example.BaseTest;
import org.example.pages.LoginPage;
import org.example.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginErrorMessageTest extends BaseTest {

    private int counter = 0;

    @DataProvider(name = "loginTestData")
    public Object[][] userData(){
        return new Object[][]{
                {"",""}
                ,{"user",""}
                ,{"user","password"}
        };
    }

    /** Check Error messages
     * No username - Epic sadface: Username is required
     * No password - Epic sadface: Password is required
     * Invalid user - Epic sadface: Username and password do not match any user in this service
     * **/
    @Test(dataProvider = "loginTestData")
    public void errorMessageCheck(String username, String password){
        counter++;
//        System.out.println(counter);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

        String errorMsg = loginPage.checkLoginErrorMessage();

        if (counter==1){
            Assert.assertEquals(errorMsg,"Epic sadface: Username is required", "Error message is not correct!");
            Utils.log("Username error message is correct!");
        }
        else if (counter==2){
            Assert.assertEquals(errorMsg,"Epic sadface: Password is required", "Error message is not correct!");
            Utils.log("Password error message is correct!");
        }
        else if ((counter==3)){
            Assert.assertEquals(errorMsg,"Epic sadface: Username and password do not match any user in this service", "Error message is not correct!");
            Utils.log("Invalid user error message is correct!");
        }

    }

}
