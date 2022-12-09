import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdectPage extends BasePage {
    public ProdectPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//span[text()='Add to cart']")
    public WebElement addToCartButton;

    //method region

    public void clickOnAddToCart(){
        safeClickOnElement(addToCartButton);
    }
}
