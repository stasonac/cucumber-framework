package steps;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class Steps {
    private WebDriver driver;
    private LoginPage loginPO;

    @Given("^User open login page$")
    public void userOpenLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dlavraniuc\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPO = new LoginPage(driver);
        driver.navigate().to("https://www.orsay.com");
        String actualTitle = driver.getTitle();
        driver.manage().window().maximize();
        String expectedTitle = "Orsay Home";
        Assert.assertEquals("Condition true", actualTitle, expectedTitle);

    }
    @When("^User login with correct username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userLoginWithCorrectUsernameAsAndPasswordAs(String username,String password)throws Throwable {
        loginPO.login("dorina.lavraniuc@gmail.com","lavraniuc.S1");
        throw new PendingException();
    }

    @Then("^User is logged in$")
    public void userIsLoggedIn() {

    }

    @After
    public void cleanup(Scenario scenario) {
        driver.close();
    }


}