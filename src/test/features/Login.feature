@Login
Feature: Log in/Log out Page
  This feature verifies the functionality on Orsay Login/Log out Page

  Scenario: Check that user can log in successfully
    Given User open login page
    When User click on Account
    And User login with correct username as dorina.lavraniuc@gmail.com and password as lavraniuc.S1
    Then User Dorina Lavraniuc is logged in

  Scenario : Check that user can log out from Account Page
    Given User is on Account Page
    When  Clicking on Sign out button
    Then User is redirected on Registration Page

