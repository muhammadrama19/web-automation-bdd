# @Webautomation
Feature: Login Zaidan Educare

  Background:
    Given user is opened the browser
    And user accessing url http://ptbsp.ddns.net:6882/

  @ValidCredentials @TC2.1
  Scenario: Login with valid credentials
    When user input username "bendahara" and password "admin123"
    And user click login button
    Then user should see the dashboard page

  @InvalidCredentials @TC2.3
  Scenario: Login with invalid credentials username
    When user input wrong username "indra" and password "admin123"
    And user click login button
    Then user should see the error message for incorrect username "Incorrect username or password, please try again!"

  @InvalidCredentials @TC2.4
  Scenario: Login with invalid credentials password
    When user input username "bendahara" and wrong password "admin1234"
    And user click login button
    Then user should see the error message for incorrect password "Incorrect username or password, please try again!"

  Rule: Login is invalid when one or both credentials are empty

    @Negative @TC2.5
    Scenario: Login with empty password
      Given User is not logged in
      When user input username "bendahara"
      And user left the password empty
      And user click login button
      Then user should be able to see message "Password wajib diisi" under password input field
