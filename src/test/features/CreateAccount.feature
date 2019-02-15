@CreateAccount

    Feature:CreateAccount
      Scenario: User successfully creates an Orsay Account
        Given User navigate to Login Page
        When  User click on “Account” button
        Then  New page is displayed and the Create an account now button is enabled
        When  User click on Create an account now button
        Then  User is directed to the registration form and “Create Account” title is displayed
        When  User select Title as “Dna”
        And   User enters First Name as “Dorina” and Surname as “Lavraniuc”
        And   User select Date of Birthday : Date : 04, Month:07,Year :1987
        And   User enters email address as lavraniuc.dorina@gmail.com and confirm email as lavraniuc.D1
        And   User enters password as lavraniuc.D1
        And   User click on “To Register” button
        Then  Account “Dorina Lavraniuc” is created


        Scenario: Check that user can Sign out from account
        Scenario: The user is able to change password









