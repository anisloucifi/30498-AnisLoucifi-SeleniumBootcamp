import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class SearchResultPage extends BasePage {
    public SearchResultPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "srp-ipp-menu")
    public WebElement totalItem;
    @FindBy (xpath = "s-item_title")
    public List<WebElement> listOfItem;

    //
    public String getResultNumber(){
        return  getTrimmedElementText(totalItem);

    }
    public ProdectPage clickOnItem(int index){
        safeClickOnElement(listOfItem.get(index));
        switchToTab();
        return new  ProdectPage();
    }
}
