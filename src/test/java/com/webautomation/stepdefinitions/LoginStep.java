package com.webautomation.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class LoginStep {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "edgedriver_win64/msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @Given("user is opened the browser")
    public void user_is_opened_the_browser() {
        driver.manage().window().maximize();
    }

    @Given("user accessing url {word}")
    public void user_accessing_url(String url) {
        driver.get(url);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
