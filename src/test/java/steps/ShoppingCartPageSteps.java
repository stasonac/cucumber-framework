package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ShoppingCartPageSteps extends Common {

    @When("^User select and added product in basket$")
    public void userAddSelectedProducts() {
        shoppingCA.SelectProducts();
        shoppingCA.AddToShoppingCart();
    }

    @Then("^Selected products is added successfully in the basket$")
    public void selectedProductsIsAddedSuccessfullyInTheBasket() {
        Assert.assertEquals(true, shoppingCA.IsElementPresent());
    }

    @When("^User click on Delete link$")
    public void userClickOnDeleteLink() {
        shoppingCA.DeleteProductsFromBasket();
    }

    @Then("^Product is deleted from basket$")
    public void productIsDeletedFromBasket() {
        Assert.assertEquals("Coșul dvs. este gol", shoppingCA.getStateMessage_Basket());
    }

    @And("^User go to products basket$")
    public void productsIsAlreadyOnBasket() {
        shoppingCA.ClickOn_basket();
    }

    @When("^User edits product details$")
    public void userEditsDetailsOfProductWhichHasBeenAddedInBasket() {
        shoppingCA.EditDetailsOfProduct();
    }

    @Then("^Details has been changed successfully$")
    public void detailsHasBeenChangedSuccessfully() {
        Assert.assertEquals(true,shoppingCA.isEnabled());

    }



}
