package com.webautomation.automation.action;

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
        String title = dashboardLocator.bendaharaDashboardTitle;
        return title != null && !title.isEmpty();
    }

    public boolean isBendaharaProfileExists() {
        String profile = dashboardLocator.bendaharaProfile;
        return profile != null && !profile.isEmpty();
    }
}
