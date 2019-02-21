@ShoppingCart
  Feature:ShoppingCart functionality
@add
    Scenario: Check that user is able to add products in the basket
      Given User navigate to login page
      When User add selected products
      Then Selected products is added successfully in the basket
@del
    Scenario: Remove products from shopping cart
      Given Product is already added in basket
      When User click on Delete link
      Then Product is deleted from basket
  


