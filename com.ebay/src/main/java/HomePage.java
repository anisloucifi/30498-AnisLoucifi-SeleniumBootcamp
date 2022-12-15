import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "gh-ac")
    public WebElement searchInput;


    @FindBy(id = "gh-btn")
    public WebElement searchButton;


    @FindBy(id = "gh-as-a")
    public WebElement advanceLink;


    @FindBy(xpath = "//a[text()=' Sell']")
    public WebElement sellLink;


    @FindBy(xpath = "//section[@id='image_banner_1']//a[text()='List an item']")
    public WebElement listItemButton;




    //method region


    public void setSearchInput(String searchTerm) {
        clearSendKeysToElement(searchInput, searchTerm);
    }


    public void clickOnSearchButton() {
        safeClickOnElement(searchButton);
    }


    public SearchResultPage doSearch(String searchTerm) {
        setSearchInput(searchTerm);
        clickOnSearchButton();
        return new SearchResultPage();
    }


//    public SearchAdvancePage clickOnAdvanceLink() {
//        safeClickOnElement(advanceLink);
//        return new SearchAdvancePage();
//    }


    public void clickOnSellLink() {
        safeClickOnElement(sellLink);
    }


//    public ListItemPage clickOnListItem() {
//        clickOnSellLink();
//        safeClickOnElement(listItemButton);
//        return new ListItemPage();
//    }




}


