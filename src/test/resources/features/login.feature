Feature: User Login Functionality

  Background:
    Given User navigates to login page

  Scenario Outline: Check login with different user credentials
    When User enters username "<username>" and password "<password>"
    And User clicks on the login button
    Then User should see "<expected_result>" status

    Examples:
      | username      | password     | expected_result |
      | standard_user | secret_sauce | SUCCESS         |
      | standard_user | wrong_pass   | FAILURE         |