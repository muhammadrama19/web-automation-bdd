package com.webautomation.automation.pagelocator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLocator {

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/img")
    public WebElement applicationLogo;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/h1")
    public WebElement applicationTitle;

    @FindBy(xpath = "//*[@id=':Rufnlvb:-form-item']")
    public WebElement usernameField;

    @FindBy(xpath = "//*[@id=':R1efnlvb:-form-item']/input")
    public WebElement passwordField;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div/form/button")
    public WebElement loginButton;

}