package com.webautomation.stepdefinitions;

import com.webautomation.automation.action.LoginAction;
import com.webautomation.automation.utils.SeleniumHelper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class GlobalStep {
    private LoginAction loginAction;

    @Before
    public void setUp() {
        loginAction = new LoginAction();
    }

    @Given("^(?:[uU]ser) is opened the browser$")
    public void user_is_opened_the_browser() {
        SeleniumHelper.getDriver().manage().window().maximize();
    }

    @Given("User/user accessing url {word}")
    public void user_accessing_url(String url) {
        SeleniumHelper.navigateTo(url);
    }

    @Given("^(?:[uU]ser) is not logged in$")
    public void user_is_not_logged_in() {
        SeleniumHelper.getDriver().manage().deleteAllCookies();
    }

    @After
    public void tearDown() {
        SeleniumHelper.closeDriver();
    }
}
