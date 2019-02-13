package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends PageObject {
    @FindBy(xpath = "//*[@id=\"wrapper\"]/header/div/div/div[2]/a/img")
    private WebElement logoImage;

    @FindBy(css = "div.account-header-wrapper>h4")
    private WebElement accountOwner;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getWellcomeAccountOwnerMessage() {
        return accountOwner.getText();
    }
}