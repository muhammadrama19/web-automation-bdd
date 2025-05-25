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
        try {
            WebElement applicationLogo = loginLocator.applicationLogo;
            boolean isDisplayed = applicationLogo.isDisplayed();
            return isDisplayed;
        } catch (Exception e) {
            System.out.println("Application logo is not displayed: " + e.getMessage());
            return false;
        }
    }

    public String isApplicationTitleExists() {
        try {
            WebElement applicationTitle = loginLocator.applicationTitle;
            boolean isDisplayed = applicationTitle.isDisplayed();
            String title = applicationTitle.getText();
            return isDisplayed ? title : null;
        } catch (Exception e) {
            System.out.println("Application title is not displayed: " + e.getMessage());
            return null;
        }
    }

    public boolean isTextExists(String text) {
        try {
            String textXPath = "//*[contains(text(),'" + text + "')]";
            WebElement textElement = SeleniumHelper.getDriver().findElement(By.xpath(textXPath));
            boolean isDisplayed = textElement.isDisplayed();
            return isDisplayed;
        } catch (Exception e) {
            System.out.println("Text '" + text + "' is not displayed: " + e.getMessage());
            return false;
        }
    }

    public boolean isTextExistUnderInputField(String fieldName, String text) {
        try {
            String fieldXPath = "//label[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"
                    + fieldName.toLowerCase()
                    + "']/following-sibling::*//input | //label[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"
                    + fieldName.toLowerCase() + "']/following-sibling::input";
            String textXPath = fieldXPath + "/following-sibling::*[contains(text(),'" + text + "')]";
            WebElement textElement = SeleniumHelper.getDriver().findElement(By.xpath(textXPath));
            boolean isDisplayed = textElement.isDisplayed();
            return isDisplayed;
        } catch (Exception e) {
            System.out
                    .println("Text '" + text + "' under field '" + fieldName + "' is not displayed: " + e.getMessage());
            return false;
        }
    }

    public boolean isInputFieldWithLabelExists(String fieldName) {
        try {
            String fieldXPath = "//label[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"
                    + fieldName.toLowerCase()
                    + "']/following-sibling::*//input | //label[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"
                    + fieldName.toLowerCase() + "']/following-sibling::input";
            WebElement inputField = SeleniumHelper.getDriver().findElement(By.xpath(fieldXPath));
            boolean isDisplayed = inputField.isDisplayed();
            boolean isEmpty = inputField.getAttribute("value").isEmpty();
            return isDisplayed && isEmpty;
        } catch (Exception e) {
            System.out.println("Input field with label '" + fieldName + "' is not displayed: " + e.getMessage());
            return false;
        }
    }

    public boolean isButtonExists(String buttonName) {
        try {
            String buttonXPath = "//button[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"
                    + buttonName.toLowerCase() + "']";
            WebElement button = SeleniumHelper.getDriver().findElement(By.xpath(buttonXPath));
            boolean isDisplayed = button.isDisplayed();
            return isDisplayed;
        } catch (Exception e) {
            System.out.println("Button '" + buttonName + "' is not displayed: " + e.getMessage());
            return false;
        }
    }

    public void setFieldEmpty(String fieldName) {
        String fieldXPath = "//label[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"
                + fieldName.toLowerCase()
                + "']/following-sibling::*//input | //label[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"
                + fieldName.toLowerCase() + "']/following-sibling::input";
        WebElement field = SeleniumHelper.getDriver().findElement(By.xpath(fieldXPath));
        field.clear();
    }

    public void setField(String fieldName, String text) {
        String fieldXPath = "//label[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"
                + fieldName.toLowerCase()
                + "']/following-sibling::*//input | //label[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '"
                + fieldName.toLowerCase() + "']/following-sibling::input";
        WebElement field = SeleniumHelper.getDriver().findElement(By.xpath(fieldXPath));
        field.clear();
        field.sendKeys(text);
    }

    public boolean isUsernameFieldExists() {
        try {
            WebElement usernameField = loginLocator.usernameField;
            boolean isDisplayed = usernameField.isDisplayed();
            boolean isEmpty = usernameField.getAttribute("value").isEmpty();
            return isDisplayed && isEmpty;
        } catch (Exception e) {
            System.out.println("Username field is not displayed: " + e.getMessage());
            return false;
        }
    }

    public boolean isPasswordFieldExists() {
        try {
            WebElement passwordField = loginLocator.passwordField;
            boolean isDisplayed = passwordField.isDisplayed();
            boolean isEmpty = passwordField.getAttribute("value").isEmpty();
            return isDisplayed && isEmpty;
        } catch (Exception e) {
            System.out.println("Password field is not displayed: " + e.getMessage());
            return false;
        }
    }

    public void loginStep(String username, String password) {
        WebElement Username = loginLocator.usernameField;
        Username.clear();
        Username.sendKeys(username);
        WebElement Password = loginLocator.passwordField;
        Password.clear();
        Password.sendKeys(password);
    }

    public void loginClicked() {
        WebElement loginButton = loginLocator.loginButton;
        loginButton.click();
        SeleniumHelper.waitForPageToLoad();
    }

}
