package com.webautomation.automation.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
    @BeforeAll
    public static void before_all() {
        new SeleniumHelper();
        File screenshotsDir = new File("screenshots");
        if (screenshotsDir.exists()) {
            try {
                FileUtils.deleteDirectory(screenshotsDir);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Before
    public void before(Scenario scenario) {
        SeleniumHelper.getDriver().manage().deleteAllCookies();
    }

    @AfterAll
    public static void after_all() {
        SeleniumHelper.closeDriver();
    }

    @After
    public void take_screenshoot_on_fail(Scenario scenario) {
        WebDriver driver = SeleniumHelper.getDriver();
        if (scenario.isFailed() && driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed_Screenshot");
            try {
                FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
                        new File("screenshots/" + scenario.getName() + ".png"));
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }
}
