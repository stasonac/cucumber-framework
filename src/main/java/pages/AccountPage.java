package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends PageObject {
    @FindBy(xpath = "//*[@id=\"wrapper\"]/header/div/div/div[2]/a/img")
    WebElement logoImage;

    public AccountPage(WebDriver driver) {
        super(driver);

    }




}




