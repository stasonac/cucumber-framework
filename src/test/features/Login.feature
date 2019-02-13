@Login
Feature: Login

  Scenario: First scenario
    Given User open login page
    When User click on Account
    And User login with correct username as dorina.lavraniuc@gmail.com and password as lavraniuc.S1
    Then User Dorina Lavraniuc is logged in