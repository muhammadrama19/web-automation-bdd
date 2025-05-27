# @Webautomation
Feature: Login Zaidan Educare

  Background:
    Given user is opened the browser
    And user accessing url http://ptbsp.ddns.net:6882/
    And user is not logged in

  @Positive @TC2.1
  Scenario: Login with valid credentials
    When user input username "bendahara" and password "admin123"
    And user click login button
    Then user should see the dashboard page

  Rule: Login is invalid when credentials are incorrect

  @Negative @TC2.3
  Scenario: Login with invalid credentials username
    When user input wrong username "indra" and password "admin123"
    And user click login button
    Then user should see the error message for incorrect username "Incorrect username or password, please try again!"

  @Negative @TC2.4
  Scenario: Login with invalid credentials password
    When user input username "bendahara" and wrong password "admin1234"
    And user click login button
    Then user should see the error message for incorrect password "Incorrect username or password, please try again!"

  Rule: Login is invalid when one or both credentials are empty

    @Negative @TC2.5
    Scenario: Login with empty password
      When user input username "bendahara"
      And user left the password empty
      And user click login button
      Then user should be able to see message "Password wajib diisi" under password input field

    @Negative @TC2.6
    Scenario: Login with empty username
      When user left the username empty
      And user input password "admin123"
      And user click login button
      Then user should be able to see message "Password wajib diisi" under password input field

    @Negative @TC2.7
    Scenario: Login with empty username and password
      When user left the username empty
      And user left the password empty
      And user click login button
      Then user should be able to see message "Username wajib diisi" under username input field
      And user should be able to see message "Password wajib diisi" under password input field

  Rule: Login is invalid when username is not formatted correctly

    @Negative @TC2.8
    Scenario: Login with wrong formatted username
      When user input wrong formatted username "BENDAHARA"
      And user input password "admin123"
      And user click login button
      Then user should be able to see message for wrong formatted username "Username diisi dengan huruf kecil semua"

    @Negative @TC2.9
    Scenario: Login with username more than 20 characters
      When user input username "wdadwadwadawdwagdwiau" and password "admin123"
      And user click login button
      Then user should be able to see message for wrong formatted username "Username maksimal 20 karakter"

  Rule: Login is invalid when password is not formatted correctly

    @Negative @TC2.10
    Scenario: Login with password less than 6 characters
      When user input username "bendahara" and wrong password "admin"
      And user click login button
      Then user should be able to see the error message for incorrect password "Password minimal 6 karakter"