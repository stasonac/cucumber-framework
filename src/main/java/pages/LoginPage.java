package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"wrapper\"]/header/div/div/div[3]/div[2]/a/i")
    private WebElement icon_Account;

    @FindBy(css = "#dwfrm_login_username_d0sfgdbqogpu")
    private WebElement userNameTextBox;

    @FindBy(css = "#dwfrm_login_password_d0ajzpytojks")
    private WebElement passwordTextBox;

    @FindBy(css = "#dwfrm_login > div.form-row.form-row-button > button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void ClickOn_ItemAccount() {
        icon_Account.click();
    }

    public void login(String username, String password) {
        userNameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        loginButton.click();
    }


}
