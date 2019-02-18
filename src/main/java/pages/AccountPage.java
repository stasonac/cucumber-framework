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
    private WebElement createAnAccountNowButton;

    @FindBy(id = "dwfrm_profile_customer_salutation")
    private WebElement title_DropDown;

    @FindBy(id = "dwfrm_profile_customer_firstname")
    private WebElement firstNameTextBox;

    @FindBy(id = "dwfrm_profile_customer_lastname")
    private WebElement surnameTextBox;

    @FindBy(xpath = "//*[@id=\"dwfrm_profile_customer_dayOfBirth\"]")
    private WebElement date_DropDown;

    @FindBy(id = "dwfrm_profile_customer_monthOfBirth")
    private WebElement month_DropDown;

    @FindBy(id = "dwfrm_profile_customer_yearOfBirth")
    private WebElement year_DropDown;

    @FindBy(id = "dwfrm_profile_customer_email")
    private WebElement emailTextBox;

    @FindBy(id = "dwfrm_profile_customer_emailconfirm")
    private WebElement confirmEmailTextBox;

    @FindBy(css = "input.password")
    private WebElement passwordTextBox;

    @FindBy(css = " #RegistrationForm > div:nth-child(12) > div > div > div > div > button")
    private WebElement toRegisterButton;

    @FindBy(css = "#primary > div.account-header-wrapper > a")
    private WebElement SignOut_Button;


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeAccountOwnerMessage() {
        return accountOwner.getText();
    }

    public boolean IsCreateAnAccountNowButtonEnnabled() {

        try {
            return createAnAccountNowButton.isEnabled();
        } catch (Exception e) {
            return false;
        }

    }

    public void ClickOn_CreateAnAccountNowButton() {
        createAnAccountNowButton.click();
    }

    public String getCreateAccountTitle() {
        return createAccountTitle.getText();
    }

    public void SelectDateOfBirth(String value) {
        Select date = new Select(date_DropDown);
        date.selectByValue(value);
    }

    public void SelectMonthOfBirth(String value) {
        Select month = new Select(month_DropDown);
        month.selectByVisibleText(value);
    }

    public void SelectYearOfBirth(String value) {
        Select year = new Select(year_DropDown);
        year.selectByValue(value);
    }

    public void SelectOptionTitle(String title) {
        Select selector = new Select(title_DropDown);
        selector.selectByVisibleText(title);
    }

    public void FillRegisterForm(String title, String FirstName, String SureName, String birtDay, String Email, String Password) {
        String bd[] = birtDay.split(" ");
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

    public void ClickOn_SignUp_Button (){
        SignOut_Button.click();
    }


}