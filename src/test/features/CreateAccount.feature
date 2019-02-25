@CreateAccount
Feature:CreateAccount

  @createAccount
  Scenario: User successfully creates an Orsay Account
    Given User open login page
    And User click on Account
    And User navigate to create new account page
    When User fill new account form and submit it
      | title     | Dna                  |
      | firstName | Alp                  |
      | surname   | Stratu               |
      | birtday   | 4 Iulie 1987         |
      | email     | Stratu.Alp@gmail.com |
      | password  | lavraniuc.A6         |
    Then New Account Alp Stratu is created







