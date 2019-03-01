@Dashboard
  Feature: Functionality of the Dashboard page

    @search
    Scenario: Adding a product to the system should automatically make it searchable
      Given User open login page
      When User enters the type of product into search text-box
        | typeOfProduct | blugi |
      Then The type of searched product will be displayed on the page


    @language
    Scenario:Change Language from localization icon on Dashboard Page
      Given User open login page
      When User click on localization icon and select language
      Then The page is translated successfully

