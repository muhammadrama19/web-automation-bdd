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
import io.cucumber.java.en.When;

public class LoginVerificationStep {

    private LoginAction loginAction;
    @Before
    public void setUp() {
        loginAction = new LoginAction();
    }

    @When("User/user left the {word}( field) empty")
    public void user_left_the_field_empty(String fieldName) {
        loginAction.setFieldEmpty(fieldName);
    }

    @Then("User/user should be able to see message {string} under {word}( input) field")
    public void user_should_see_message_under_input_field(String message, String fieldName) {
        boolean isMessageDisplayed = loginAction.isTextExistUnderInputField(fieldName, message);
        assertEquals(true, isMessageDisplayed);
    }

    @After
    public void tearDown() {
        SeleniumHelper.closeDriver();
    }

}
