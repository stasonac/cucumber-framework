package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class ShoppingCartPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"mini-cart\"]/div[1]/a/span")
    private WebElement basket_Link;

    @FindBy(xpath="//*[@id=\"wrapper\"]/header/div/nav/ul/li[2]/a")
    private WebElement products_Link;

    @FindBy(css="//*[@id=\"secondary\"]/div/div[2]/div[2]/h3")
    private WebElement PriceLink;

    @FindBy(css= "#secondary div:nth-child(4) ul > li:nth-child(3) > a")
    private WebElement price_CheckBox;

    @FindBy(xpath= "//*[@id=\"swatch-36_s\"]")
    private WebElement size_CheckBox;

    @FindBy(xpath = "//*[@id=\"swatch-green\"]/span")
    private WebElement color_CheckBox;

   @FindBy(css="#add-to-cart")
   private WebElement addToCart_button;

   @FindBy(css="#search-result-items > li:nth-child(1)")
   private WebElement product_Item1;

   @FindBy(css="#checkout-form > button")
   private WebElement checkOut_Button;

   @FindBy(xpath = "//*[@id=\"cart-table\"]/div[3]/div/div[2]/div[1]/div[2]/button")
   private WebElement deleteLink;

   @FindBy (css ="#primary > div > div.cart-empty > p")
   private WebElement stateMessageAboutBasket;

   @FindBy(xpath = "//*[@id=\"cart-table\"]/div[7]/div/div[2]/div[1]/div[2]/div[2]/a")
   private WebElement editDetails_Link;

   @FindBy(xpath = "//*[@id=\"product-content\"]/div[4]/ul/li[1]/div[2]/ul/li[4]")
   private WebElement color_Link;

   @FindBy(xpath = "//*[@id=\"product-content\"]/div[4]/ul/li[2]/div[2]/ul/li[4]")
   private WebElement size_Link;

   @FindBy (xpath = "//*[@id=\"add-to-cart\"]")
   private WebElement updated_Button;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    public void SelectProducts (){
        products_Link.click();
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        price_CheckBox.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", size_CheckBox);
       size_CheckBox.click();
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
       color_CheckBox.click();
    }
    public void AddToShoppingCart (){
        product_Item1.click();
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        addToCart_button.click();
        basket_Link.click();
    }
    public boolean IsElementPresent(){
        try {
            checkOut_Button.isDisplayed();
                    return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void ClickOn_basket(){
        basket_Link.click();
    }

    public void DeleteProductsFromBasket(){
        deleteLink.click();
    }

    public String getStateMessage_Basket(){
        return stateMessageAboutBasket.getText();
    }

    public void EditDetailsOfProduct (){
        editDetails_Link.click();
        color_Link.click();
        size_Link.click();
        updated_Button.click();
    }


    }












