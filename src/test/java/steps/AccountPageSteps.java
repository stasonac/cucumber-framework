package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Map;


public class AccountPageSteps extends Common {

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

    @When("^User click on Change password link$")
    public void userClickOnChangePasswordLink() {
        accountPO.ClickOn_ChangePassword_Link();

    }

    @And("^User fill change password form and confirm it$")
    public void userFillChangePasswordFormAndConfirmIt(DataTable table) {
        Map<String, String> inputs = table.asMap(String.class, String.class);
        accountPO.FillChangePassword_Form(
                inputs.get("currentPass"),
                inputs.get("newPass"),
                inputs.get("confirmPass")
        );

    }

    @Then("^Confirmation Message is displayed$")
    public void confirmationMessageIsDisplayed() {
        Assert.assertEquals("Bine ați revenit, Alz Stratu!", accountPO.getConfirmationMessage());
    }
}



