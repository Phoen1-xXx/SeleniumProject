package org.example.pages;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    WebElement errorMessage;



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password){
        setText(userNameField, username);
        setText(passwordField, password);
        clickElement(loginButton);
    }

    public String checkLoginErrorMessage(){
        return getText(errorMessage);
    }

}
