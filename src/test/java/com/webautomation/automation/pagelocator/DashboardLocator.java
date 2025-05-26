package com.webautomation.automation.pagelocator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardLocator {

    @FindBy(xpath ="/html/body/div[2]/main/div/div[1]/div/div/div[1]/h1")
    public WebElement bendaharaDashboardTitle;

    @FindBy(xpath ="/html/body/div[2]/main/div/div[1]/div/div/div[2]/span")
    public WebElement bendaharaProfile;

    @FindBy(xpath = "/html/body/div[2]/main/div/div[1]/div/div/div[2]/button")
    public WebElement logoutButton;
    
    @FindBy(xpath = "//button[text()='Ya']")
    public WebElement logoutConfirmButton;

}
