import base.BasePage;
import io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeCalculatePage extends BasePage {
    public HomeCalculatePage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "purchase-price-input-medium")
    public WebElement priceField;
    @FindBy (id = "down-payment-input-medium")
    public WebElement dawnPaymentField;
    @FindBy (id = "zip-code-input-medium")
    public WebElement zipCodeField;
    @FindBy (id = "update-button-medium")
    public WebElement updateButton;
    @FindBy (xpath = "//div[@id='ratesTableModule']/div/div[1]/section/div/div/div/div[2]/div[5]/div/div/p/span[2]")
    public WebElement monthlyPayment;

    public void enterPrice(String price){
        clearSendKeysToElement(priceField,price);
    }
    public void enterDawnPayment(String payment){
        clearSendKeysToElement(dawnPaymentField,payment);
    }
    public void enterZipCode(String zipcode){
        clearSendKeysToElement(zipCodeField,zipcode);
    }
    public void clickOnUpdate(){
        safeClickOnElement(updateButton);
    }
    public void doCalculate(String price,String payment,String zipCode){
        enterPrice(price);
        enterDawnPayment(payment);
        enterZipCode(zipCode);
        clickOnUpdate();
    }

    public String getResult(){
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='ratesTableModule']/div/div[1]/section/div/div/div/div[2]/div[5]/div/div/p/span[2]")));
       return getTrimmedElementText(monthlyPayment);
    }
}
