package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class ShoppingCartPage extends PageObject {

    @FindBy(css = "#mini-cart > div.mini-cart-total > a > span > span")
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

   @FindBy(xpath = "//*[@id=\"94118f15f94ddcb8de128996cf\"]/div[1]/a/div[2]/img")
   private WebElement fustaMidi;

   @FindBy(id="add-to-cart")
   private WebElement addToCart_button;

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

        //document.getElementByTagName("li").item(2).className;

    }

    public void OpenShoppingCart (){
        basket_Link.click();
    }










}
