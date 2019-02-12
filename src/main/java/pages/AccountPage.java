package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends PageObject {


    @FindBy(xpath = "//*[@id=\"wrapper\"]/header/div/div/div[3]/div[2]/a/span/font/font")
    WebElement icon_UtilityLinkAccount;


    public AccountPage(WebDriver driver) {
        super(driver);
    }


}




