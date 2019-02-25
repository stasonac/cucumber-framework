package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountPage extends PageObject {
    @FindBy(xpath = "//*[@id=\"wrapper\"]/header/div/div/div[2]/a/img")
    private WebElement logoImage;

    @FindBy(css = "div.account-header-wrapper>h4")
    private WebElement accountOwner;

    @FindBy(css = "h1.account-heading")
    private WebElement createAccountTitle;

    @FindBy(css = "#dwfrm_login_register > div > button")
    private WebElement createAnAccountNewButton;

    @FindBy(id = "dwfrm_profile_customer_salutation")
    private WebElement titleDropDown;

    @FindBy(id = "dwfrm_profile_customer_firstname")
    private WebElement firstNameTextBox;

    @FindBy(id = "dwfrm_profile_customer_lastname")
    private WebElement surnameTextBox;

    @FindBy(xpath = "//*[@id=\"dwfrm_profile_customer_dayOfBirth\"]")
    private WebElement dateDropDown;

    @FindBy(id = "dwfrm_profile_customer_monthOfBirth")
    private WebElement monthDropDown;

    @FindBy(id = "dwfrm_profile_customer_yearOfBirth")
    private WebElement year_DryearDropDown;

    @FindBy(id = "dwfrm_profile_customer_email")
    private WebElement emailTextBox;

    @FindBy(id = "dwfrm_profile_customer_emailconfirm")
    private WebElement confirmEmailTextBox;

    @FindBy(css = "input.password")
    private WebElement passwordTextBox;

    @FindBy(css = " #RegistrationForm > div:nth-child(12) > div > div > div > div > button")
    private WebElement toRegisterButton;

    @FindBy(css = "#primary > div.account-header-wrapper > a")
    private WebElement signOutButton;


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeAccountOwnerMessage() {
        return accountOwner.getText();
    }

    public boolean IsCreateAnAccountNewButtonEnnabled() {

        try {
            return createAnAccountNewButton.isEnabled();
        } catch (Exception e) {
            return false;
        }

    }

    public void ClickOn_CreateAnAccountNewButton() {
        createAnAccountNewButton.click();
    }

    public String getCreateAccountTitle() {
        return createAccountTitle.getText();
    }

    public void SelectDateOfBirth(String value) {
        Select date = new Select(dateDropDown);
        date.selectByValue(value);
    }

    public void SelectMonthOfBirth(String value) {
        Select month = new Select(monthDropDown);
        month.selectByVisibleText(value);
    }

    public void SelectYearOfBirth(String value) {
        Select year = new Select(year_DryearDropDown);
        year.selectByValue(value);
    }

    public void SelectOptionTitle(String title) {
        Select selector = new Select(titleDropDown);
        selector.selectByVisibleText(title);
    }

    public void FillRegisterForm(String title, String FirstName, String SureName, String birthDay, String Email, String Password) {
        String bd[] = birthDay.split(" ");
        SelectOptionTitle(title);
        firstNameTextBox.sendKeys(FirstName);
        surnameTextBox.sendKeys(SureName);
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        SelectDateOfBirth(bd[0]);
        SelectMonthOfBirth(bd[1]);
        SelectYearOfBirth(bd[2]);
        emailTextBox.sendKeys(Email);
        confirmEmailTextBox.sendKeys(Email);
        passwordTextBox.clear();
        passwordTextBox.sendKeys(Password);
    }

    public void ClickOn_ToRegisterButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toRegisterButton);
        toRegisterButton.click();
    }

    public void ClickOn_SignOut_Button (){
        signOutButton.click();
    }


}