package steps;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
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

public class LoginPageSteps extends Common {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dlavraniuc\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1224,968");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPO = new LoginPage(driver);
        accountPO = new AccountPage(driver);
        shoppingCA = new ShoppingCartPage(driver);
    }

    @After
    public void cleanup(Scenario scenario) {

        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        scenario.embed(screenshot, "image/png");

        driver.close();
    }
    @Given("^User open login page$")
    public void userOpenLoginPage() {
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.orsay.com/ro-ro/");
        driver.manage().window().maximize();
    }

    @When("^User click on Account$")
    public void userClickOnAccount() {
        loginPO.ClickOn_ItemAccount();
    }


    @Then("^User (.*) is logged in$")
    public void userIsLoggedIn(String user) {
        String expectedMessage = String.format("Bine ați revenit, %s!", user);
        Assert.assertEquals(expectedMessage, accountPO.getWelcomeAccountOwnerMessage());
    }
    @And("^User login with correct username and password$")
    public void userLoginWithCorrectUsernameAndPassword(DataTable table) {
        Map<String, String> inputs = table.asMap(String.class, String.class);
        loginPO.ClickOn_ItemAccount();
        loginPO.login(
                inputs.get("username"),
                inputs.get("password")
        );

    }

    @When("^User Click on Sign out button$")
    public void clickingOnSignOutButton() {
        accountPO.ClickOn_SignOut_Button();
    }

    @Then("^User is redirected on Registration Page$")
    public void userIsRedirectedOnRegistrationPage() {
        Assert.assertEquals("Logare", loginPO.getLoginMessage());
    }

    @When("^User enters the type of product into search text-box$")
    public void userEntersTheTypeOfProductIntoSearchTextBox(DataTable table) {
        Map<String, String> inputs = table.asMap(String.class, String.class);
        loginPO.SearchProducts(
                inputs.get("typeOfProduct"));
    }

    @Then("^The type of searched product will be displayed on the page$")
    public void theTypeOfSearchedProductWillBeDisplayedOnThePage() {
        Assert.assertEquals("Rezultate pentru (blugi)", loginPO.getMessageOfSearchedProduct());
    }


}

















