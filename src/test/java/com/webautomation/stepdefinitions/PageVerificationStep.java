package com.webautomation.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PageVerificationStep {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "edgedriver_win64/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
    }

    @Given("^(?:[uU]ser) is opened the browser$")
    public void user_is_opened_the_browser() {
        driver.manage().window().maximize();
    }

    @Given("User/user accessing url {word}")
    public void user_accessing_url(String url) {
        driver.get(url);
    }

    @Given("^(?:[uU]ser) is not logged in$")
    public void user_is_not_logged_in() {
        driver.manage().deleteAllCookies();
    }

    @Then("User/user should be able to see app(lication) logo")
    public void user_should_see_application_logo() {
        String logoXPath = "/html/body/div[2]/div/div[1]/img";
        boolean isLogoDisplayed = driver.findElement(By.xpath(logoXPath)).isDisplayed();
        assertEquals(true, isLogoDisplayed);
    }

    @Then("User/user should be able to see app(lication) title {string}")
    public void user_should_see_application_title(String title) {
        String titleXPath = "/html/body/div[2]/div/div[1]/h1";
        String actualTitle = driver.findElement(By.xpath(titleXPath)).getText();
        String expectedTitle = title;
        assertEquals(expectedTitle, actualTitle);
    }

    @Then("User/user should be able to see this following text:")
    public void user_should_see_this_following_text(DataTable dataTable) {
        for (String text : dataTable.asList()) {
            String textXPath = "//*[contains(text(),'" + text + "')]";
            boolean isTextDisplayed = driver.findElement(By.xpath(textXPath)).isDisplayed();
            assertEquals(true, isTextDisplayed);
        }
    }

    @Then("User/user should be able to see {word} input field")
    public void user_should_see_input_field(String fieldName) {
        String fieldXPath = "//label[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" 
            + fieldName.toLowerCase() + "']/following-sibling::*//input | //label[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" 
            + fieldName.toLowerCase() + "']/following-sibling::input";
        boolean isFieldDisplayed = driver.findElement(By.xpath(fieldXPath)).isDisplayed();
        assertEquals(true, isFieldDisplayed);
    }

    @Then("User/user should be able to see {word} button")
    public void user_should_see_button(String buttonName) {
        String buttonXPath = "//button[translate(normalize-space(text()), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" 
            + buttonName.toLowerCase() + "']";
        boolean isButtonDisplayed = driver.findElement(By.xpath(buttonXPath)).isDisplayed();
        assertEquals(true, isButtonDisplayed);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
