package steps;

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
        System.setProperty("webdriver.chrome.driver", "aici tre sa pui calea spre chromedriver.exe");
        driver = new ChromeDriver();
        loginPO = new LoginPage(driver);

        driver.navigate().to("aici scrii linku la pagina care o testezi");

    }

    @When("^User login with valid credentials$")
    public void userLoginWithValidCredentials() {

    }

    @Then("^User is logged in$")
    public void userIsLoggedIn() {

    }
}