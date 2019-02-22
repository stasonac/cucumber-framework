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
    Given Products is already on basket
    When User Edits details of product which has been added in basket
    Then Details has been changed successfully


