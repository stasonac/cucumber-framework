package steps;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AccountPage;
import pages.LoginPage;
import pages.ShoppingCartPage;
import java.util.Map;


public class AccountPageSteps {
    private WebDriver driver;
    private LoginPage loginPO;
    private AccountPage accountPO;
    private ShoppingCartPage shoppingCA;

    @And("^User navigate to create new account page$")
    public void userNavigateToCreateNewAccountPage() {
        accountPO.ClickOn_CreateAnAccountNewButton();
    }

    @When("^User fill new account form and submit it$")
    public void userFillNewAccountFormAndSubmitIt(DataTable table) {
        Map<String, String> inputs = table.asMap(String.class, String.class);
        accountPO.FillRegisterForm(
                inputs.get("title"),
                inputs.get("firstName"),
                inputs.get("surname"),
                inputs.get("birthday"),
                inputs.get("email"),
                inputs.get("password")
        );
        accountPO.ClickOn_ToRegisterButton();
    }

    @Then("^New Account (.*) is created$")
    public void newAccountIsCreated(String user) {
        String expectedMessage = String.format("Bine ați revenit, %s!", user);
        Assert.assertEquals(expectedMessage, accountPO.getWelcomeAccountOwnerMessage());
    }



}
