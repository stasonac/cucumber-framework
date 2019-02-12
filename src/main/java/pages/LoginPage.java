package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    // aici tre sa declari web elementele din pagina login si metodele de care ai nevoie

    @FindBy(css = "")
    WebDriver sampleElement;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
