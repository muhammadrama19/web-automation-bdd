# @Webautomation
Feature: Login Zaidan Educare

    Background:
        Given user is opened the browser
        And user accessing url http://ptbsp.ddns.net:6882/


    @ValidCredentials @TC2.1
    Scenario: Login with valid credentials
        When user input username "bendahara" and password "admin123"
        And  user click login button
        Then user should see the dashboard page
    
    @InvalidCredentials @TC2.2
    Scenario: Login with invalid credentials username
        When user input wrong username "indra" and password "admin123"
        And  user click login button
        Then user should see the error message for incorrect username "Incorrect username or password, please try again!"
    
    @InvalidCredentials @TC2.3
    Scenario: Login with invalid credentials password
        When user input username "bendahara" and wrong password "admin1234"
        And  user click login button
        Then user should see the error message for incorrect password "Incorrect username or password, please try again!"

