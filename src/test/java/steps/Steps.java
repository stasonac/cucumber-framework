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
        accountPO.IsCreateAnAccountNowButtonEnnabled();
    }

    @When("^User click on Create an account now button$")
    public void userClickOnCreateAnAccountNowButton() {
        accountPO.ClickOn_CreateAnAccountNowButton();
    }

    @Then("^User is directed to the registration form and “Create Account” title is displayed$")
    public void userIsDirectedToTheRegistrationFormAndCreateAccountTitleIsDisplayed() {
        accountPO.getCreateAccountTitle();
    }

    @When("^User select Title as (.*)$")
    public void userSelectTitleAsFrau() {
        accountPO.SelectOptionTitle();
        
    }

    @And("^User enters First Name as (.*) and Surname as (.*)$")
    public void userEntersFirstNameAsDorinaSurnameAsLavraniuc(String FirstName,String SureName,String Email,String ConfirmEmail,String Password)throws Throwable{
        accountPO.FillRegisterForm(FirstName,SureName,Email,ConfirmEmail,Password);
    }


    @And("^User select Date of Birthday : Date : (\\d+), Month:(\\d+),Year :(\\d+)$")
    public void userSelectDateOfBirthdayDateMonthYear(int arg0, int arg1, int arg2) {
        accountPO.SelectDateOfBirth();
    }

    @And("^User enters email address as (.*) and confirm email as (.*)$")
    public void userEntersEmailAddressAsLavraniucDorinaGmailComAndConfirmEmailAsLavraniucDAndPasswordAsLavraniucD(int arg0, int arg1) {

        
    }
    @And("User enters password as (.*)$")
    public void userEntersPasswordAsLavraniucD(int arg0) {
    }

    @And("^User click on “To Register” button$")
    public void userClickOnToRegisterButton() {
        
    }

    @Then("^Account (.*)is created$")
    public void accountDorinaLavraniucIsCreated() {
    }



}