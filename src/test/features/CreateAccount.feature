@CreateAccount

Feature:CreateAccount

  Scenario: User successfully creates an Orsay Account
    Given User open login page
    When  User click on “Account” button
    Then  New page is displayed and the Create an account now button is enabled
    When  User click on Create an account now button
    Then  User is directed to the registration form and Creați contul title is displayed
    When User fill the form with the following data
      | title     | Dna                        |
      | firstName | Dorina                     |
      | surname   | Lavraniuc                  |
      | birtday   | 04 Iulie 1987              |
      | email     | lavraniuc.dorina@gmail.com |
      | password  | lavraniuc.D1               |
    And   User click on “To Register” button
    Then  Account “Dorina Lavraniuc” is created


  Scenario: Check that user can Sign out from account

  Scenario: The user is able to change password









