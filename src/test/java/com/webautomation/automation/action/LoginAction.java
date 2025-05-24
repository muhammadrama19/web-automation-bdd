package com.webautomation.automation.action;

import org.openqa.selenium.support.PageFactory;

import com.webautomation.automation.pagelocator.LoginLocator;
import com.webautomation.automation.utils.SeleniumHelper;

import org.openqa.selenium.By;
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

    public String isApplicationTitleExists() {
        WebElement applicationTitle = loginLocator.applicationTitle;
        boolean isDisplayed = applicationTitle.isDisplayed();
        String title = applicationTitle.getText();
        return isDisplayed ? title : null;
    }

    public boolean isTextExists(String text) {
        String textXPath = "//*[contains(text(),'" + text + "')]";
        WebElement textElement = SeleniumHelper.getDriver().findElement(By.xpath(textXPath));
        boolean isDisplayed = textElement.isDisplayed();
        return isDisplayed;
    }

    public boolean isInputFieldWithLabelExists(String fieldName) {
        String fieldXPath = "//label[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" 
            + fieldName.toLowerCase() + "']/following-sibling::*//input | //label[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" 
            + fieldName.toLowerCase() + "']/following-sibling::input";
        WebElement inputField = SeleniumHelper.getDriver().findElement(By.xpath(fieldXPath));
        boolean isDisplayed = inputField.isDisplayed();
        boolean isEmpty = inputField.getAttribute("value").isEmpty();
        return isDisplayed && isEmpty;
    }

    public boolean isButtonExists(String buttonName) {
        String buttonXPath = "//button[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" 
            + buttonName.toLowerCase() + "']";
        WebElement button = SeleniumHelper.getDriver().findElement(By.xpath(buttonXPath));
        boolean isDisplayed = button.isDisplayed();
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
