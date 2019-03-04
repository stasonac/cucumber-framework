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
      When User change language to Deutschland
      Then The page is translated successfully

    @filters
    Scenario:Filter product by the best-selling criterion
      Given User open login page
      When The user filters the products by Pret de la mic la mare
      Then New list of filtering products are updated

