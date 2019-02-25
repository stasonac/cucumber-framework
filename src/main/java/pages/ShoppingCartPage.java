package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ShoppingCartPage extends PageObject {

    @FindBy(css = "#mini-cart > div.mini-cart-total > a > i")
    private WebElement basketLink;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/header/div/nav/ul/li[2]/a")
    private WebElement productsLink;

    @FindBy(css = "//*[@id=\"secondary\"]/div/div[2]/div[2]/h3")
    private WebElement PriceLink;

    @FindBy(css = "#secondary div:nth-child(4) ul > li:nth-child(3) > a")
    private WebElement priceCheckBox;

    @FindBy(xpath = "//*[@id=\"swatch-36_s\"]")
    private WebElement sizeCheckBox;

    @FindBy(xpath = "//*[@id=\"swatch-green\"]/span")
    private WebElement colorCheckBox;

    @FindBy(css = "#add-to-cart")
    private WebElement addToCartButton;

    @FindBy(css = "#search-result-items > li:nth-child(1)")
    private WebElement productItem1;

    @FindBy(css = "#checkout-form > button")
    private WebElement checkOutButton;

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
        productsLink.click();
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        priceCheckBox.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sizeCheckBox);
        sizeCheckBox.click();
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        colorCheckBox.click();
    }

    public void AddToShoppingCart() {
        productItem1.click();
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        addToCartButton.click();
        basketLink.click();
    }

    public boolean IsElementPresent() {
        try {
            checkOutButton.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void ClickOn_basket() {
        basketLink.click();
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












