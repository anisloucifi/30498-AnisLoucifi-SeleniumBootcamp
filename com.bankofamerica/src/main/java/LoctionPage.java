import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoctionPage extends BasePage {
    public LoctionPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//div[@id='section-location-information']/div[2]/a")
    WebElement favoriteButton;
    @FindBy (xpath = "//div[@id='titleModule']/div/div/div/div[2]/a")
    public WebElement favoriteExtention;
    @FindBy (xpath = "//*[@id='lid684163']/div/div[4]/div[1]")
    public WebElement addressText;
    @FindBy (xpath = "//div[@id='section-location-information']/div[2]/p/span")
    public WebElement getAddressText;

    public void clickAddToFavorite(){
        safeClickOnElement(favoriteButton);
    }
    public boolean isFavoriteDisplay(){
        safeClickOnElement(favoriteExtention);
        if(getAddressText.isDisplayed())
        {
            return true;}
        else return false;
        }

    }


