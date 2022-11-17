import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FinancialCenterLocatPage extends BasePage {
    public FinancialCenterLocatPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "q")
    public WebElement addressField;
    @FindBy (id = "search-button")
    public WebElement searchButton;
    @FindBy (xpath = "//div[@id='list-expand']/div[4]/ul")
    public List<WebElement>  addresses;
    @FindBy (xpath = "//*[@id='lid684163']/div/a[2]")
    public WebElement locationWanted;

    public void enterZipCode(String zipcode){
        clearSendKeysToElement(addressField,zipcode);

    }
    public void clickOnsearch(){
       clickOnElement(searchButton);

    }
    public boolean isListOfAdressesDisplay(){
        if(addresses != null){
            return true;
        }
        return false;
    }
    public LoctionPage clickOnLocationWanted(){
        safeClickOnElement(locationWanted);
        return new LoctionPage();
    }
}
