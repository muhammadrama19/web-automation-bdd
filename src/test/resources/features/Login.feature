# @Webautomation
Feature: Login Zaidan Educare

    Scenario: Setup
        Given user is opened the browser
        And user accessing url http://ptbsp.ddns.net:6882/

    # Background:
    #     Given user is opened the browser
    #     And user accessing url http://ptbsp.ddns.net:6882/

    # @PageVerfication @TC1
    # Scenario: Login page is displayed
    #     When user first time open the page
    #     Then There are field for input username
    #     And There are field for input password
    #     And There are button for login

    # @ValidCredentials @TC2.1
    # Scenario: Login with valid credentials
    #     When user input username "bendahara"
    #     And user input password "admin123"
    #     And  user click login button
    #     Then user should see the dashboard page
    
    # @InvalidCredentials @TC2.2
    # Scenario: Login with invalid credentials username
    #     When user input username "indra"
    #     And user input password "admin123"
    #     And  user click login button
    #     Then user should see the error message "Incorrect username or password, please try again!"
    
    # @InvalidCredentials @TC2.3
    # Scenario: Login with invalid credentials password
    #     When user input username "bendahara"
    #     And user input password "admin1234"
    #     And  user click login button
    #     Then user should see the error message "Incorrect username or password, please try again!"

