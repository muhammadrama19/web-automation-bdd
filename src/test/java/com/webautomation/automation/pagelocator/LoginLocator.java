package com.webautomation.automation.pagelocator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLocator {

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/img")
    public WebElement applicationLogo;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/h1")
    public WebElement applicationTitle;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div/form/div[1]/input")
    public WebElement usernameField;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div/form/div[2]/div/input")
    public WebElement passwordField;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div/form/button")
    public WebElement loginButton;

}