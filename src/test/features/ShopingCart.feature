@ShoppingCart
  Feature:ShoppingCart functionality
@add
    Scenario: Check that user is able to add products in the basket
      Given User open login page
      When User select and added product in basket
      Then Selected products is added successfully in the basket
@dell
    Scenario: Remove products from shopping cart
      Given User select and added product in basket
      When User click on Delete link
      Then Product is deleted from basket
@update
    Scenario: Edit Details of products from basket
    Given User open login page
    And User log in with correct username and password
      | username | Stratu.Alz@gmail.com |
      | password | lavraniuc.A7         |
    And User go to products basket
    When User edits product details
    Then Details has been changed successfully


