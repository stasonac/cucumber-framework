@Login
Feature: Login

  Scenario: First scenario
    Given User open login page
    When User login with correct username as "dorina.lavraniuc@gmail.com" and password as "lavraniuc.S1"
    Then User is logged in