@ShoppingCart
  Feature:ShoppingCart functionality
@dev
    Scenario: Check that user is able to add products in the basket
      Given User navigate to login page
      When User add selected products
      Then Selected products is added successfully in the basket
