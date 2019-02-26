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

  @search
  Scenario: Adding a product to the system should automatically make it searchable
    Given User open login page
    When User enters the type of product into search text-box
      | typeOfProduct | blugi |
    Then The type of searched product will be displayed on the page

  @language
  Scenario:Change Language from localization icon on Dashboard Page
    Given User open login page
    When User click on localization icon and select language
    Then The page is translated successfully



