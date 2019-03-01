package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends PageObject {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id='wrapper']/header/div/div/div[3]/div[1]/span/i")
    private WebElement searchLink;

    @FindBy(xpath = "//*[@id='wrapper']/header/div/div/div[4]/div/form/input[1]")
    private WebElement searchTextBox;

    @FindBy(xpath = "//*[@id='wrapper']/header/div/div/div[4]/div/form/button[2]/span")
    private WebElement searchButton;

    @FindBy(css = "#main > div.container.clearfix > div.content-banner > h1")
    private WebElement messageForSearchedProducts;

    @FindBy(css ="span[class=utility-text]")
    private WebElement languageIcon;


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
