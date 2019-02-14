package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;

public class AccountPage extends PageObject {
    @FindBy(xpath = "//*[@id=\"wrapper\"]/header/div/div/div[2]/a/img")
    private WebElement logoImage;

    @FindBy(css = "div.account-header-wrapper>h4")
    private WebElement accountOwner;

    @FindBy(xpath = "//*[@id=\"primary\"]/div/div/h1/font/font")
    private WebElement createAccountTitle;

    @FindBy(css = "#dwfrm_login_register > div > button")
    private WebElement createAnAccountNowButton;

    @FindBy(id = "dwfrm_profile_customer_salutation")
    private WebElement title_DropDown;

    @FindBy(id = "dwfrm_profile_customer_firstname")
    private WebElement firstNameTextBox;

    @FindBy(id = "dwfrm_profile_customer_lastname")
    private WebElement surnameTextBox;

    @FindBy (id = "dwfrm_profile_customer_dayOfBirth")
    private WebElement date_DropDown;

    @FindBy (id ="dwfrm_profile_customer_monthOfBirth")
    private WebElement month_DropDown;

    @FindBy (id ="dwfrm_profile_customer_yearOfBirth")
    private WebElement year_DropDown;

    @FindBy (id = "dwfrm_profile_customer_email")
    private WebElement emailTextBox;

    @FindBy(id = "dwfrm_profile_customer_emailconfirm")
    private WebElement confirmEmailTextBox;

    @FindBy (id ="dwfrm_profile_login_password_d0qyoqzkftdf")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//*[@id=\"RegistrationForm\"]/div[12]/div/div/div/div[1]/button")
    private WebElement toRegisterButton;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getWellcomeAccountOwnerMessage() {
        return accountOwner.getText();
    }

    public boolean IsCreateAnAccountNowButtonEnnabled () {

        try {
            return createAnAccountNowButton.isDisplayed() & createAnAccountNowButton.isEnabled();
            }
        catch (Exception)
        {
            return false;
        }

    }
    public void ClickOn_CreateAnAccountNowButton (){
        createAnAccountNowButton.click();
    }

    public String getCreateAccountTitle(){
        return createAccountTitle.getText();
    }
     public void SelectDateOfBirth(){
         Select date = new Select(date_DropDown);
         date.selectByValue("4");
     }

     public void SelectMonthOfBirth(){
        Select month = new Select(month_DropDown);
        month.selectByVisibleText("Juli");
     }

     public void SelectYearOfBirth(){
        Select year =new Select(year_DropDown);
        year.selectByValue("1987");
     }

     public void SelectOptionTitle (){
        Select title = new Select (title_DropDown);
        title.selectByVisibleText("Frau");
    }

    public void FillRegisterForm(String FirstName,String SureName,String Email,String ConfirmEmail,String Password){
        SelectOptionTitle();
        firstNameTextBox.sendKeys(FirstName);
        surnameTextBox.sendKeys(SureName);
        SelectDateOfBirth();
        SelectMonthOfBirth();
        SelectYearOfBirth();
        emailTextBox.sendKeys(Email);
        confirmEmailTextBox.sendKeys(ConfirmEmail);
        passwordTextBox.sendKeys(Password);
    }

    public void ClickOn_ToRegisterButton(){
        toRegisterButton.click();
    }






}