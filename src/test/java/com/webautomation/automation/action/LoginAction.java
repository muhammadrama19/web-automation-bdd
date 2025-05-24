package com.webautomation.automation.action;

import org.openqa.selenium.support.PageFactory;

import com.webautomation.automation.pagelocator.LoginLocator;
import com.webautomation.automation.utils.SeleniumHelper;
import org.openqa.selenium.WebElement;

public class LoginAction {

    LoginLocator loginLocator;
    public LoginAction() {
        this.loginLocator = new LoginLocator();
        PageFactory.initElements(SeleniumHelper.getDriver(), loginLocator);
    }

    public boolean isApplicationLogoExists() {
        WebElement applicationLogo = loginLocator.applicationLogo;
        boolean isDisplayed = applicationLogo.isDisplayed();
        return isDisplayed;
    }

    public boolean isUsernameFieldExists() {
        WebElement usernameField = loginLocator.usernameField;
        boolean isDisplayed = usernameField.isDisplayed();
        boolean isEmpty = usernameField.getAttribute("value").isEmpty();
        return isDisplayed && isEmpty;
    }

    public boolean isPasswordFieldExists() {
        WebElement passwordField = loginLocator.passwordField;
        boolean isDisplayed = passwordField.isDisplayed();
        boolean isEmpty = passwordField.getAttribute("value").isEmpty();
        return isDisplayed && isEmpty;
    }

    public void loginStep(String username, String password) {
        loginLocator.usernameField.sendKeys(username);
        loginLocator.passwordField.sendKeys(password);
        loginLocator.loginButton.click();
    }

}
