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

    @When("^User change language to (.*)$")
    public void userClickOnLocalizationIconAndSelectLanguage(String language) {
        dashboardDA.selectLanguage(language);
    }

    @Then("^The page is translated successfully$")
    public void thePageIsTranslatedSuccessfully() {
        Assert.assertEquals("DE, EUR",dashboardDA.getUtilityTextLanguage());
    }


    @When("^The user filters the products by (.*)$")
    public void theUserFiltersTheProductsByPretDeLaMicLaMare(String filter) {
        dashboardDA.selectCategory();
        dashboardDA.selectFilter(filter);

    }

    @Then("^New list of filtering products are updated$")
    public void newListOfFilteringProductsAreUpdated() {
    }


}