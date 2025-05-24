package com.webautomation.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import lombok.Getter;
import lombok.Setter;

@Setter
public class SeleniumHelper {
    
    private static WebDriver driver;

    public SeleniumHelper(){
        System.setProperty("webdriver.edge.driver", "edgedriver_win64/msedgedriver.exe");
        
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            new SeleniumHelper();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void navigateTo(String url) {
        if (driver != null) {
            driver.get(url);
        } else {
            throw new IllegalStateException("WebDriver is not initialized. Call getDriver() first.");
        }
    }
}
