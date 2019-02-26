package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(xpath = "//*[@id='wrapper']/header/div/div/div[3]/div[2]/a/i")
    private WebElement iconAccount;

    @FindBy(css = "#dwfrm_login input[type='text']")
    private WebElement userNameTextBox;

    @FindBy(css = "#dwfrm_login input[type='password']")
    private WebElement passwordTextBox;

    @FindBy(css = "#dwfrm_login button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = "div.veNoClick")
    private WebElement cancelMarketingInfo;

    @FindBy(css = "#main > div.container > div.breadcrumb > span")
    private WebElement LogareMessage;

    @FindBy(xpath = "//*[@id='wrapper']/header/div/div/div[3]/div[1]/span/i")
    private WebElement searchLink;

    @FindBy(xpath = "//*[@id='wrapper']/header/div/div/div[4]/div/form/input[1]")
    private WebElement searchTextBox;

    @FindBy(xpath = "//*[@id='wrapper']/header/div/div/div[4]/div/form/button[2]/span")
    private WebElement searchButton;

    @FindBy(css = "#main > div.container.clearfix > div.content-banner > h1")
    private WebElement messageForSearchedProducts;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void ClickOn_ItemAccount() {
        iconAccount.click();
    }

    public void login(String username, String password) {
        userNameTextBox.clear();
        passwordTextBox.clear();
        userNameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
//        try {
//            cancelMarketingInfo.click();
//        } catch (NoSuchElementException e) {
//        }
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

    public String getLoginMessage()
    {
        return LogareMessage.getText();
    }

    public void SearchProducts(String typeOfProduct) {
        searchLink.click();
        searchTextBox.sendKeys(typeOfProduct);
        searchButton.click();
    }

    public String getMessageOfSearchedProduct()
    {
        return messageForSearchedProducts.getText();
    }

}
