package com.webautomation.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.webautomation.automation.action.DashboardAction;
import com.webautomation.automation.action.LoginAction;
import com.webautomation.automation.utils.SeleniumHelper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {

    private LoginAction loginAction;
    private DashboardAction dashboardAction;

    @Before
    public void setUp() {
        loginAction = new LoginAction();
        dashboardAction = new DashboardAction();
    }

    @When("user input username {string} and password {string}")
    public void user_input_valid_credentials(String username, String password) {
        loginAction.loginStep(username, password);
    }

    @And("user click login button")
    public void user_click_login_button() {
        loginAction.loginClicked();
    }

    @Then("user should see the dashboard page")
    public void user_should_see_the_dashboard_page() {
        assertTrue(dashboardAction.isBendaharaDashboardTitleExists());
        assertTrue(dashboardAction.isBendaharaProfileExists());
    }

    @When("user input wrong username {string} and password {string}")
    public void user_input_invalid_credentials_username(String username, String password) {
        loginAction.loginStep(username, password);
    }

    @Then("user should see the error message for incorrect username {string}")
    public void user_should_see_the_error_message_for_incorrect_username(String s) {
        assertTrue(loginAction.isTextExists("Incorrect username or password, please try again!"));
    }

    @When("user input username {string} and wrong password {string}")
    public void user_input_invalid_credentials_password(String username, String password) {
        loginAction.loginStep(username, password);
    }

    @Then("user should see the error message for incorrect password {string}")
    public void user_should_see_the_error_message_for_incorrect_password(String s) {
        assertTrue(loginAction.isTextExists("Incorrect username or password, please try again!"));
    }

    @When("User/user left the {word}( field) empty")
    public void user_left_the_field_empty(String fieldName) {
        loginAction.setFieldEmpty(fieldName);
    }

    @Then("User/user should be able to see message {string} under {word}( input) field")
    public void user_should_see_message_under_input_field(String message, String fieldName) {
        boolean isMessageDisplayed = loginAction.isTextExistUnderInputField(fieldName, message);
        assertTrue(isMessageDisplayed);
    }

    @When("User/user input {word}( field)( with)( value) {string}")
    public void user_input_field_with_value(String fieldName, String value) {
        loginAction.setField(fieldName, value);
    }

    @When("user input wrong formatted username {string}")
    public void user_input_wrong_formatted_username(String username) {
        loginAction.setField("Username", username);
    }

    @And ("user input password {string}")
    public void user_input_password(String password) {
        loginAction.setField("Password", password);
    }

    @Then("user should be able to see message for wrong formatted username {string}")
    public void user_should_be_able_to_see_message_for_wrong_formatted_username(String s) {
        boolean isMessageDisplayed = loginAction.isTextExists("Incorrect username or password, please try again!");
        assertTrue(isMessageDisplayed);
    }
}
