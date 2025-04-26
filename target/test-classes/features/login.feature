Feature: Login to the Sauce Demo Application
  This feature will check successfully and unsuccessful user logins

  Scenario: Valid User Login
    Given the user is on the login page
    When the user enters the valid credentials
    Then the user should be redirected to the homepage

  Scenario: Valid Login parametrised
    Given the user is on the login page
    When the user enters credentials "standard_user","secret_sauce"
    Then the user should be redirected to the homepage

  Example: Login with invalid password
    Given the user is on the login page
    When the user enters credentials "standard_user","invalid"
    Then the user should error message "Epic sadface: Username and password do not match any user in this service"

  Scenario Outline: Invalid user Login Scenarios
    Given the user is on the login page
    When the user enters credentials <username>,<password>
    Then the user should error message <expectedErrorMessage>





