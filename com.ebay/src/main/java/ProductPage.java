import base.BasePage;
import org.apache.batik.apps.svgbrowser.JSVGViewerFrame;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.backgroundservice.BackgroundService;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdectPage extends BasePage {
    public ProdectPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='Add to cart']")
    public WebElement addToCartButton;


    @FindBy(xpath = "//button[text()='No thanks']")
    public WebElement addPlanNo;


    @FindBy(id = "binBtn_btn_1")
    public WebElement buyButton;


    @FindBy(xpath = "//span[text()='Check out as guest']")
    public WebElement checkoutAsGuestButton;


    @FindBy(id = "MaxBidId")
    public WebElement inputBid;


    @FindBy(id = "bidBtn_btn")
    public WebElement placeBidButton;




    //method region
    public void clickOnAddPlanNo(){
        safeClickOnElement(addPlanNo);
    }
    public CartPage clickOnAddToCart(){
        safeClickOnElement(addToCartButton);
        clickOnAddPlanNo();
        return new CartPage();
    }
    public void clickOnBuyButton(){
        safeClickOnElement(buyButton);
    }
    public void clickOnCheckoutAsGuest(){
        safeClickOnElement(checkoutAsGuestButton);
    }
    public CheckoutPage goToCheckoutAsGuest(){
        clickOnBuyButton();
        clickOnAddPlanNo();
        clickOnCheckoutAsGuest();
        return new CheckoutPage();
    }


    public void setInputBid(String amount){
        clearSendKeysToElement(inputBid,amount);
    }
    public void clickOnPlaceBidButton(){
        safeClickOnElement(placeBidButton);
    }
    public SignInPage doBid(String amount){
        setInputBid(amount);
        clickOnPlaceBidButton();
        return new SignInPage();
    }


}





