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
import sun.security.util.Password;

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

    @Given("^User navigate to Login Page$")
    public void userNavigateToLoginPage() {
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

    @When("^User click on “Account” button$")
    public void userClickOnAccountButton() {
        loginPO.ClickOn_ItemAccount();
    }

    @Then("^New page is displayed and the Create an account now button is enabled$")
    public void newPageIsDisplayedAndTheCreateAnAccountNowButtonIsEnabled() {
        Assert.assertEquals(true,accountPO.IsCreateAnAccountNowButtonEnnabled());

    }

    @When("^User click on Create an account now button$")
    public void userClickOnCreateAnAccountNowButton() {
        accountPO.ClickOn_CreateAnAccountNowButton();
    }

    @Then("^User is directed to the registration form and “Creați un cont” title is displayed$")
    public void userIsDirectedToTheRegistrationFormAndCreateAccountTitleIsDisplayed(String Title) {
        String expectedMessage = String.format("Creați un cont", Title);
        Assert.assertEquals(expectedMessage, accountPO.getCreateAccountTitle());
    }

    @When("^User select Title as (.*)$")
    public void userSelectTitleAsDna() {
        accountPO.SelectOptionTitle();
        
    }

    @And("^User enters First Name as (.*) and Surname as (.*)$")
    public void userEntersFirstNameAsAlinaSurnameAsLavraniuc(String FirstName,String SureName)throws Throwable{
        accountPO.FillFirstNameSurename(FirstName,SureName);
    }

    @And("^User select Date of Birthday : Date : (\\d+)$")
    public void userSelectDateOfBirthdayDate(int arg0) {
        accountPO.SelectDateOfBirth();
    }

    @And("^User select Month:(\\d+)$")
    public void userSelectMonth(int arg0) {
    accountPO.SelectMonthOfBirth();
    }

    @And("^User select Year :(\\d+)$")
    public void userSelectYear(int arg0) {
    accountPO.SelectYearOfBirth();
    }

    @And("^User enters email address as (.*) and confirm email as (.*)$")
    public void userEntersEmailAddressAsLavraniucDorinaGmailComAndConfirmEmailAsLavraniucDAndPasswordAsLavraniucD(String Email,String ConfirmEmail) {
        accountPO.TypeEmailAndConfirmEmail(Email,ConfirmEmail);
    }

    @And("User enters password as (.*)$")
    public void userEntersPasswordAsLavraniucD(String Password) {
        accountPO.TypePassword(Password);
    }

    @And("^User click on “To Register” button$")
    public void userClickOnToRegisterButton() {
        accountPO.ClickOn_ToRegisterButton();
        
    }

    @Then("^Account (.*)is created$")
    public void accountDorinaLavraniucIsCreated(String user) {
        String expectedMessage = String.format("Bine ați revenit, %s!", user);
        Assert.assertEquals(expectedMessage, accountPO.getWellcomeAccountOwnerMessage());

    }
}






