package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"wrapper\"]/header/div/div/div[3]/div[2]/a/i")
    private WebElement icon_Account;

    @FindBy(css = "#dwfrm_login input[type='text']")
    private WebElement userNameTextBox;

    @FindBy(css = "#dwfrm_login input[type='password']")
    private WebElement passwordTextBox;

    @FindBy(css = "#dwfrm_login button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = "div.veNoClick")
    private WebElement cancelMarketingInfo;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void ClickOn_ItemAccount() {
        icon_Account.click();
    }

    public void login(String username, String password) {
        userNameTextBox.clear();
        passwordTextBox.clear();
        userNameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);

        try {
            cancelMarketingInfo.click();
        } catch (NoSuchElementException e) {
        }

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);
        loginButton.click();
    }


    private boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
