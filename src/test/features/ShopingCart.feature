@ShoppingCart
  Feature:ShoppingCart functionality

    Scenario: Check that user is able to add products in the basket
      Given User navigate to login page
      When User add selected products
      Then Selected products is added successfully in the basket

    Scenario: Remove products from shopping cart
      Given Product is already added in basket
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


