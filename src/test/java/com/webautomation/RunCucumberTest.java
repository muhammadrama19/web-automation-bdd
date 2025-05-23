package com.webautomation;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("com.webautomation")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.webautomation.stepdefinitions")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "classpath:features")
// @ConfigurationParameter(key = "plugin", value =
// "html:target/cucumber-reports/cucumber")
// @ConfigurationParameter(
// key = PLUGIN_PROPERTY_NAME,
// value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
// )
public class RunCucumberTest {
}
