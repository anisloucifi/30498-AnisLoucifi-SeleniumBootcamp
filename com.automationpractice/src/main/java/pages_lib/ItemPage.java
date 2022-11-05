package pages_lib;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItemPage extends BasePage {
    public ItemPage() {
        PageFactory.initElements(driver, this);
    }
    //WebElement

    @FindBy(id = "quantity_wanted")
    public WebElement inputQuantity;

    @FindBy(xpath = "//ul[@id='color_to_pick_list']//a")
    public List<WebElement> listColor;

    @FindBy(name = "Submit")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[@title = 'Continue shopping']")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    public WebElement proceedToCheckOutButton;

    @FindBy(xpath = "//a[@title = 'View my shopping cart']")
    public WebElement shoppingCartLink;

    @FindBy(xpath = "//span[@class='quantity']")
    public WebElement itemNumberInCart;

    @FindBy (xpath = "//div[@class='product-atributes']//a")
    public WebElement itemColorSizeInCart;
    @FindBy(xpath = "//p[@id='quantity_wanted_p']/a[2]/span/i")
    WebElement plusbutton;
    @FindBy(xpath = "//span[@class='quantity']")
    WebElement numbofIteminCart;
    @FindBy (id = "group_1")
    public WebElement sizeField;
    @FindBy (xpath = "//a[@title='Proceed to checkout']")
    public WebElement proceedToCheckoutButton;

    public void clickonPlusButton() {
        clickOnElement(plusbutton);


    }

    public void clickOnColor(String color) {
        for (WebElement element : listColor) {
            if (element.getAttribute("title").equals(color)) {
                clickOnElement(element);
            }
        }
    }

    public void clickOnAddToCartItem() {
        clickOnElement(addToCartButton);
    }


    public void clickOnContinueShoppingButton() {
        clickOnElement(continueShoppingButton);
    }
    public CheckOutPage proccedToCheckout(){
        clickOnAddToCartItem();
        clickOnElement(proceedToCheckOutButton);
        return new CheckOutPage();
    }



    public void hoverOnShoppingCart() {
        hoverOverElement(shoppingCartLink);
    }

    public int getItemNumberInCart() {
        hoverOnShoppingCart();
        return Integer.parseInt(getTrimmedElementText(itemNumberInCart));
    }
    public String getItemSizeColor(){
        hoverOnShoppingCart();
        return getTrimmedElementText(itemColorSizeInCart);
    }
    public int checkIteminCart() {
        hoverOnShoppingCart();
        return Integer.parseInt(getTrimmedElementText(numbofIteminCart));
    }
    public void selectSize(String size){
        selectFromDropdownByVisibleText(sizeField,size);
    }

}
