Feature: Page verification

  Background:
    Given User is opened the browser
    And User accessing url http://ptbsp.ddns.net:6882/

  Rule: Login page must exist when user not logged in

    @Positive @TC1 @PageVerification
    Scenario: Verification that login page is exist
      Given User is not logged in
      And user accessing url http://ptbsp.ddns.net:6882/login
      Then user should be able to see app logo
      And user should be able to see app title "Pengelolaan Dana Pendidikan Sekolah Zaidan Educare"
      And user should be able to see this following text:
        | Selamat Datang                 |
        | Silahkan masuk ke dalam sistem |
      And user should be able to see username input field
      And user should be able to see password input field
      And user should be able to see login button

    @Positive @TC2.2 @PageVerification
    Scenario: Verification that the eye icon is working
    Given User is not logged in
    And user accessing url http://ptbsp.ddns.net:6882/login
    And user input password "admin123"
    Then user should be able to see the eye icon
    When user click the eye icon
    Then user should be able to see password input field in plain text