# @Webautomation
Feature: Login Zaidan Educare

  Background:
    Given User is opened the browser
    And User accessing url http://ptbsp.ddns.net:6882/
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

  Rule: Login is invalid when one or both credentials are empty

    @Negative @TC2.5
    Scenario: Login with empty password
      Given User is not logged in
      When user input username "bendahara"
      And user left the password empty
      And user click login button
      Then user should be able to see message "Password wajib diisi" under password input field
