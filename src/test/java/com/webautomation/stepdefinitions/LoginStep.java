package com.webautomation.stepdefinitions;

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


   @Given("user is opened the browser")
   public void user_is_opened_the_browser(){
        SeleniumHelper.getDriver().manage().window().maximize();
   }

   @And("user accessing url {string}")
   public void user_accessing_url(String url) {
        SeleniumHelper.navigateTo(url);
   }

   @When("user input username {string} and password {string}")
    public void user_input_valid_credentials(String username, String password) {
        loginAction.loginStep("bendahara", "admin123");
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
        loginAction.loginStep("indra", "admin123");
    }

    @Then("user should see the error message for incorrect username {string}")
    public void user_should_see_the_error_message_for_incorrect_username(String s) {
        assertTrue(loginAction.isTextExists("Incorrect username or password, please try again!"));
    }

    @When("user input username {string} and wrong password {string}")
    public void user_input_invalid_credentials_password(String username, String password) {
        loginAction.loginStep("bendahara", "admin1234");
    }

    @Then("user should see the error message for incorrect password {string}")
    public void user_should_see_the_error_message_for_incorrect_password(String s) {
        assertTrue(loginAction.isTextExists("Incorrect username or password, please try again!"));
    }

    @After
    public void tearDown() {
        SeleniumHelper.closeDriver();   
    }





  







}
