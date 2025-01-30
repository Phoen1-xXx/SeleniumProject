package org.example;

import org.example.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = DriverManager.getDriver();
        driver.manage().window().maximize(); //browser window maximize line
        driver.get("https://saucedemo.com");
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quit();
    }


}
