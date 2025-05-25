package com.webautomation.automation.action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.automation.pagelocator.DashboardLocator;
import com.webautomation.automation.utils.SeleniumHelper;

public class DashboardAction {

    DashboardLocator dashboardLocator;


    public DashboardAction() {
        this.dashboardLocator = new DashboardLocator();
        PageFactory.initElements(SeleniumHelper.getDriver(), dashboardLocator);
    }

    public boolean isBendaharaDashboardTitleExists() {
        WebElement dashboardTitle = dashboardLocator.bendaharaDashboardTitle;
        boolean isDisplayed = dashboardTitle.isDisplayed();
        return isDisplayed;
    }

    public boolean isBendaharaProfileExists() {
        WebElement profile = dashboardLocator.bendaharaProfile;
        boolean isDisplayed = profile.isDisplayed();
        return isDisplayed;
    }
}
