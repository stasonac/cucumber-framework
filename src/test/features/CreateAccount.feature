@CreateAccount

Feature:CreateAccount

  Scenario: User successfully creates an Orsay Account
    Given User on create new account page
    When User fill new account form and submit it
      | title     | Dna                  |
      | firstName | Alz                  |
      | surname   | Stratu               |
      | birtday   | 4 Iulie 1987         |
      | email     | Stratu.Alz@gmail.com |
      | password  | lavraniuc.A7         |
    Then New Account Alz Stratu is created







