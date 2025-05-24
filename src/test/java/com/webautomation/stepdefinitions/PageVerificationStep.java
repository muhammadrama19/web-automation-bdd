package com.webautomation.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.webautomation.automation.action.LoginAction;
import com.webautomation.automation.utils.SeleniumHelper;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PageVerificationStep {

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

    @Then("User/user should be able to see app(lication) logo")
    public void user_should_see_application_logo() {
        boolean isLogoDisplayed = loginAction.isApplicationLogoExists();
        assertEquals(true, isLogoDisplayed);
    }

    @Then("User/user should be able to see app(lication) title {string}")
    public void user_should_see_application_title(String title) {
        String actualTitle = loginAction.isApplicationTitleExists();
        assertEquals(title, actualTitle);
    }

    @Then("User/user should be able to see this following text:")
    public void user_should_see_this_following_text(DataTable dataTable) {
        for (String text : dataTable.asList()) {
            boolean isTextDisplayed = loginAction.isTextExists(text);
            assertEquals(true, isTextDisplayed);
        }
    }

    @Then("User/user should be able to see {word} input field")
    public void user_should_see_input_field(String fieldName) {
        boolean isFieldDisplayed = loginAction.isInputFieldWithLabelExists(fieldName);
        assertEquals(true, isFieldDisplayed);
    }

    @Then("User/user should be able to see {word} button")
    public void user_should_see_button(String buttonName) {
        boolean isButtonDisplayed = loginAction.isButtonExists(buttonName);
        assertEquals(true, isButtonDisplayed);
    }

    @After
    public void tearDown() {
        SeleniumHelper.closeDriver();
    }

}
