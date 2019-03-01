@CreateAccount
Feature:CreateAccount

  @createAccount
  Scenario: User successfully creates an Orsay Account
    Given User open login page
    And User click on Account
    And User navigate to create new account page
    When User fill new account form and submit it
      | title     | Dna                  |
      | firstName | Mal                  |
      | surname   | Stratu               |
      | birtday   | 4 Iulie 1988         |
      | email     | Stratu.Mal@gmail.com |
      | password  | lavraniuc.A15        |
    Then New Account Mal Stratu is created

  @ChangePass
  Scenario: User is able to change the password
    Given User open login page
    And User click on Account
    And User login with correct username and password
      | username | Stratu.Alz@gmail.com |
      | password | lavraniuc.A11         |
    And User click on Change password link
    And User fill change password form and confirm it
      | currentPass | lavraniuc.A11 |
      | newPass     | lavraniuc.A12 |
      | confirmPass | lavraniuc.A12 |
    Then Confirmation Message is displayed







