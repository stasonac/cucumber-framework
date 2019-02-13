package steps;

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

import java.util.concurrent.TimeUnit;

public class Steps {
    private WebDriver driver;
    private LoginPage loginPO;
    private AccountPage accountPO;

    @Given("^User open login page$")
    public void userOpenLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dlavraniuc\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1224,968");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPO = new LoginPage(driver);
        accountPO = new AccountPage(driver);
        driver.navigate().to("https://www.orsay.com/ro-ro/");
        driver.manage().window().maximize();
    }
    @When("^User click on Account$")
    public void userClickOnAccount() {
        loginPO.ClickOn_ItemAccount();
    }
    @And("^User login with correct username as (.*) and password as (.*)$")
    public void userLoginWithCorrectUsernameAsAndPasswordAs(String username, String password) throws Throwable {
        loginPO.login(username,password);
    }

    @Then("^User (.*) is logged in$")
    public void userIsLoggedIn(String user) {
        String expectedMessage = String.format("Bine ați revenit, %s!", user);
        Assert.assertEquals(expectedMessage, accountPO.getWellcomeAccountOwnerMessage());
    }

    @After
    public void cleanup(Scenario scenario) {

        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        scenario.embed(screenshot, "image/png");

        driver.close();
    }
}