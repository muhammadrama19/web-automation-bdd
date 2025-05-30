package com.webautomation.automation.action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import com.webautomation.automation.pagelocator.DashboardLocator;
import com.webautomation.automation.utils.SeleniumHelper;

public class DashboardAction {

    DashboardLocator dashboardLocator;

    public DashboardAction() {
        this.dashboardLocator = new DashboardLocator();
        PageFactory.initElements(SeleniumHelper.getDriver(), dashboardLocator);
    }

    public boolean isBendaharaDashboardTitleExists() {
        try {
            WebElement dashboardTitle = dashboardLocator.bendaharaDashboardTitle;
            boolean isDisplayed = dashboardTitle.isDisplayed();
            return isDisplayed;
        } catch (Exception e) {
            System.out.println("Dashboard title is not displayed: " + e.getMessage());
            return false;
        }
    }

    public boolean isBendaharaProfileExists() {
        try {
            WebElement profile = dashboardLocator.bendaharaProfile;
            boolean isDisplayed = profile.isDisplayed();
            return isDisplayed;
        } catch (Exception e) {
            System.out.println("Bendahara profile is not displayed: " + e.getMessage());
            return false;
        }
    }
    
    public void clickLogout() {
        dashboardLocator.logoutButton.click();
        new WebDriverWait(SeleniumHelper.getDriver(), Duration.ofSeconds(5))
            .until(ExpectedConditions.elementToBeClickable(dashboardLocator.logoutConfirmButton))
            .click();
        SeleniumHelper.waitForPageToLoad();
    }

    public boolean areNavbarItemsDisplayed() {
        List<String> expectedItems = Arrays.asList(
            "Dasbor",
            "Tagihan Siswa",
            "Transaksi Penerimaan Dana",
            "Pengaturan Notifikasi",
            "Status Pembayaran",
            "Rekapitulasi",
            "Progres Transaksi Penerimaan Dana"
        );

        try {
            for (String expected : expectedItems) {
                boolean found = dashboardLocator.navbarItems.stream()
                    .anyMatch(el -> el.getText().trim().equalsIgnoreCase(expected));
                if (!found) {
                    System.out.println("Menu item not found: " + expected);
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error verifying navbar: " + e.getMessage());
            return false;
        }
    }
}
