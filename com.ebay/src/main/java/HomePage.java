import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "gh-ac")
    public WebElement serchField;
    @FindBy (id = "gh-btn")
    public WebElement searchButton;
// methode region

     public void setSerchField(String serchItem){
         clearSendKeysToElement(serchField,serchItem);
     }
     public void clickOnSearch(){
         clickOnElement(searchButton);
     }
     public SearchResultPage dosearch(String searchItem){
         setSerchField(searchItem);
         clickOnSearch();
         return new SearchResultPage();

     }
}
