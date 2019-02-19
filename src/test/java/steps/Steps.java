package steps;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AccountPage;
import pages.LoginPage;
import pages.ShoppingCartPage;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Steps {
    private WebDriver driver;
    private LoginPage loginPO;
    private AccountPage accountPO;
    private ShoppingCartPage shoppingCA;

    @Given("^User open login page$")
    public void userOpenLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dlavraniuc\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1224,968");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPO = new LoginPage(driver);
        accountPO = new AccountPage(driver);
        shoppingCA = new ShoppingCartPage(driver);
        driver.navigate().to("https://www.orsay.com/ro-ro/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @When("^User click on Account$")
    public void userClickOnAccount() {
        loginPO.ClickOn_ItemAccount();
    }

    @And("^User login with correct username and password$")
    public void userLoginWithCorrectUsernameAndPassword(DataTable table) {
        Map<String, String> inputs = table.asMap(String.class, String.class);
        userOpenLoginPage();
        loginPO.ClickOn_ItemAccount();
        loginPO.login(
                inputs.get ("username"),
                inputs.get ("password")
        );
    }

    @Then("^User (.*) is logged in$")
    public void userIsLoggedIn(String user) {
        String expectedMessage = String.format("Bine ați revenit, %s!", user);
        Assert.assertEquals(expectedMessage, accountPO.getWelcomeAccountOwnerMessage());
    }

    @After
    public void cleanup(Scenario scenario) {

        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        scenario.embed(screenshot, "image/png");

        driver.close();
    }

    @Given("^User on create new account page$")
    public void userOnCreateNewAccountPage() {
        userOpenLoginPage();
        loginPO.ClickOn_ItemAccount();
        accountPO.ClickOn_CreateAnAccountNowButton();
    }

    @When("^User fill new account form and submit it$")
    public void userFillNewAccountFormAndSubmitIt(DataTable table) {
        Map<String, String> inputs = table.asMap(String.class, String.class);
        accountPO.FillRegisterForm(
                inputs.get("title"),
                inputs.get("firstName"),
                inputs.get("surname"),
                inputs.get("birtday"),
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

    @Given("^User is on Account Page$")
    public void userIsOnAccountPage(DataTable table){
    Map<String, String> inputs = table.asMap(String.class, String.class);
        userOpenLoginPage();
        loginPO.ClickOn_ItemAccount();
        loginPO.login(
                inputs.get ("username"),
                inputs.get ("password")
                );
        }

    @When("^Clicking on Sign out button$")
    public void clickingOnSignOutButton() {
        accountPO.ClickOn_SignOut_Button();
    }

    @Then("^User is redirected on Registration Page$")
    public void userIsRedirectedOnRegistrationPage() {
        Assert.assertEquals("Logare", loginPO.getLoginMessage());
    }


    @Given("^User navigate to login page$")
    public void userNavigateToLoginPage() {
       userOpenLoginPage();
    }

    @When("^User add selected products$")
    public void userAddSelectedProducts() {
        shoppingCA.SelectProducts();
        shoppingCA.AddToShoppingCart();


    }

    @Then("^Selected products is added successfully in the basket$")
    public void selectedProductsIsAddedSuccessfullyInTheBasket() {
    }
}








