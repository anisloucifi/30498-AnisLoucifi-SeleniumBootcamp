package pages_lib;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultSearchPage extends BasePage {
    public ResultSearchPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "selectProductSort")
    public WebElement selectSortBy;
    @FindBy (xpath = "//div[@class='right-block']//span[@class='price product-price']")
    public List<WebElement> listOfPrices;
    @FindBy (xpath = "//div[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
    public WebElement imageDress;

    public void selectSortingType(String type){
        selectFromDropdownByVisibleText(selectSortBy,type);
    }
    public List<String> getListOfPrices(){
        List<String> prices= new ArrayList<String>();
        for(WebElement element: listOfPrices){
            prices.add(getTrimmedElementText(element));
        }
        return prices;
    }
    public ItemPage clickOnItem(WebElement item){
        clickOnElement(item);
        return new ItemPage();
    }

}
