@Login
Feature: Login

  Scenario: First scenario
    Given User open login page
    When User login with valid credentials
    Then User is logged in