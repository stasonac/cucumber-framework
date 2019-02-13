package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Thread.*;

public class LoginPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"wrapper\"]/header/div/div/div[3]/div[2]/a/i")
    private WebElement icon_Account;

    @FindBy(css = "#dwfrm_login input[type='text']")
    private WebElement userNameTextBox;

    @FindBy(css = "#dwfrm_login input[type='password']")
    private WebElement passwordTextBox;

    @FindBy(css = "#dwfrm_login button[type='submit']")
    private WebElement loginButton;

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
        loginButton.click();
    }


}
