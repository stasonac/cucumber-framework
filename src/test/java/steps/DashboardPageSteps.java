package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class DashboardPageSteps extends  Common{

    @When("^User enters the type of product into search text-box$")
    public void userEntersTheTypeOfProductIntoSearchTextBox(DataTable table) {
        Map<String, String> inputs = table.asMap(String.class, String.class);
         dashboardDA.SearchProducts(
                inputs.get("typeOfProduct"));
    }

    @Then("^The type of searched product will be displayed on the page$")
    public void theTypeOfSearchedProductWillBeDisplayedOnThePage() {
        Assert.assertEquals("Rezultate pentru (blugi)", dashboardDA.getMessageOfSearchedProduct());
    }

    @When("^User click on localization icon and select language$")
    public void userClickOnLocalizationIconAndSelectLanguage() {

    }

    @Then("^The page is translated successfully$")
    public void thePageIsTranslatedSuccessfully() {
    }

}
