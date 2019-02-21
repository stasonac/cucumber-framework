@Login
Feature: Log in/Log out Page
  This feature verifies the functionality on Orsay Login/Log out Page

  Scenario: Check that user can log in successfully
    Given User open login page
    When User click on Account
    And User login with correct username and password
      | username | Stratu.Alz@gmail.com |
      | password | lavraniuc.A7         |
    Then User Alz Stratu is logged in

  Scenario: Check that user can log out from Account Page
    Given User is on Account Page
      | username | Stratu.Alz@gmail.com |
      | password | lavraniuc.A7         |
    When  Clicking on Sign out button
    Then User is redirected on Registration Page
@search
  Scenario: Adding a product to the system should automatically make it searchable
    Given User is on login page
    When User enters the type of product into search text-box
    |typeOfProduct| blugi|
    Then The type of searched product will be displayed on the page



