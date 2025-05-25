# @Webautomation
Feature: Logout Zaidan Educare

  Background:
    Given user is opened the browser
    And user accessing url http://ptbsp.ddns.net:6882/

  @Positive @TC3.1
  Scenario: Logout redirects to login page
    # --- LOGIN lebih dulu ---
    When user input username "bendahara" and password "admin123"
    And user click login button
    Then user should see the dashboard page

    # --- AKSI LOGOUT ---
    When user click logout button
    Then user should be redirected to login page
