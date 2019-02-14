@Login
Feature: Login Page
  This feature verifies the functionality on Orsay Login Page

  Scenario: Check that user can log in successfully
    Given User open login page
    When User click on Account
    And User login with correct username as dorina.lavraniuc@gmail.com and password as lavraniuc.S1
    Then User Dorina Lavraniuc is logged in

    Scenario: Check that user can change the language from the Login Page
    Scenario: Check the functionality of the search
    Scenario: Check that user can select shop location from the dashboard page
    Scenario: Adding a new item to the system should automatically make it searchable
    Scenario: Check that user is able to add products in the shopping cart
    Scenario: Check that user is able to delete the products from basket