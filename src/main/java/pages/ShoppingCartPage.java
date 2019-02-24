package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ShoppingCartPage extends PageObject {

    @FindBy(css = "#mini-cart > div.mini-cart-total > a > i")
    private WebElement basket_Link;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/header/div/nav/ul/li[2]/a")
    private WebElement products_Link;

    @FindBy(css = "//*[@id=\"secondary\"]/div/div[2]/div[2]/h3")
    private WebElement PriceLink;

    @FindBy(css = "#secondary div:nth-child(4) ul > li:nth-child(3) > a")
    private WebElement price_CheckBox;

    @FindBy(xpath = "//*[@id=\"swatch-36_s\"]")
    private WebElement size_CheckBox;

    @FindBy(xpath = "//*[@id=\"swatch-green\"]/span")
    private WebElement color_CheckBox;

    @FindBy(css = "#add-to-cart")
    private WebElement addToCart_button;

    @FindBy(css = "#search-result-items > li:nth-child(1)")
    private WebElement product_Item1;

    @FindBy(css = "#checkout-form > button")
    private WebElement checkOut_Button;

    @FindBy(xpath = "//*[@id=\"cart-table\"]/div[3]/div/div[2]/div[1]/div[2]/button")
    private WebElement deleteLink;

    @FindBy(css = "#primary > div > div.cart-empty > p")
    private WebElement stateMessageAboutBasket;

    @FindBy(css = "a.icon-edit")
    private List<WebElement> editDetailsLinks;

    @FindBy(css = "ul[class='swatches color']>li[class='selectable selected']")
    private List<WebElement> selectableColors;

    @FindBy(css = "ul[class='swatches size']>li[class='selectable selected']")
    private List<WebElement> selectableSizes;

    @FindBy(css = "#add-to-cart")
    private WebElement updatedButton;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void SelectProducts() {
        products_Link.click();
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        price_CheckBox.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", size_CheckBox);
        size_CheckBox.click();
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        color_CheckBox.click();
    }

    public void AddToShoppingCart() {
        product_Item1.click();
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        addToCart_button.click();
        basket_Link.click();
    }

    public boolean IsElementPresent() {
        try {
            checkOut_Button.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void ClickOn_basket() {
        basket_Link.click();
    }

    public void DeleteProductsFromBasket() {
        deleteLink.click();
    }

    public String getStateMessage_Basket() {
        return stateMessageAboutBasket.getText();
    }

    public void EditDetailsOfProduct() {
        scrollAndClick(editDetailsLinks.get(0));
        if (!selectableColors.isEmpty()) selectableColors.get(0).click();
        if (!selectableSizes.isEmpty()) selectableSizes.get(0).click();
        updatedButton.click();
    }
}












