package com.webautomation.stepdefinitions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;

import com.webautomation.automation.action.LoginAction;
import com.webautomation.automation.utils.SeleniumHelper;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

public class GlobalStep {
    
    @Given("^(?:[uU]ser) is opened the browser$")
    public void user_is_opened_the_browser() {
        SeleniumHelper.getDriver().manage().window().maximize();
    }

    @Given("User/user accessing url {word}")
    public void user_accessing_url(String url) {
        SeleniumHelper.navigateTo(url);
        SeleniumHelper.waitForPageToLoad();
    }

    @Given("^(?:[uU]ser) is not logged in$")
    public void user_is_not_logged_in() {
        SeleniumHelper.getDriver().manage().deleteAllCookies();
    }
}
