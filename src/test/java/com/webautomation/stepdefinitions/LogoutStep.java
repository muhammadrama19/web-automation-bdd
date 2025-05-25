package com.webautomation.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webautomation.automation.action.DashboardAction;
import com.webautomation.automation.action.LoginAction;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStep {

    private DashboardAction dashboardAction;
    private LoginAction    loginAction;

    @Before
    public void setUp() {
        dashboardAction = new DashboardAction();
        loginAction     = new LoginAction();
    }

    @When("user click logout button")
    public void user_click_logout_button() {
        dashboardAction.clickLogout();
    }

    @Then("user should be redirected to login page")
    public void user_should_be_redirected_to_login_page() {
        // verifikasi elemen-elemen halaman login
        assertTrue(loginAction.isApplicationLogoExists());
        assertTrue(loginAction.isUsernameFieldExists());
        assertTrue(loginAction.isPasswordFieldExists());
    }
}