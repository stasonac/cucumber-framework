@Login
Feature: Log in/Log out Page
  This feature verifies the functionality on Orsay Login/Log out Page

  @log-in
  Scenario: Check that user can log in successfully
    Given User open login page
    When User click on Account
    And User login with correct username and password
      | username | Stratu.Alz@gmail.com |
      | password | lavraniuc.A7         |
    Then User Alz Stratu is logged in

  @log-out
  Scenario: Check that user can log out from Account Page
    Given User open login page
    And User login with correct username and password
      | username | Stratu.Alz@gmail.com |
      | password | lavraniuc.A7         |
    When  User Click on Sign out button
    Then User is redirected on Registration Page





