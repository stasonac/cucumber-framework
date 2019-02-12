package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class Steps {
    private WebDriver driver;
    private LoginPage loginPO;

    @Given("^User open login page$")
    public void userOpenLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dlavraniuc\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPO = new LoginPage(driver);

        driver.navigate().to("https://www.orsay.com");

    }

    @When("^User login with valid credentials$")
    public void userLoginWithValidCredentials() {

    }

    @Then("^User is logged in$")
    public void userIsLoggedIn() {

    }

    @After
    public void cleanup(Scenario scenario) {
        driver.close();

    }
}