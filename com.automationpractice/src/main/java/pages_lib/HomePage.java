package pages_lib;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    // webelement region
    @FindBy (id = "search_query_top")
    public WebElement inputSearch;
    @FindBy (name = "submit_search")
    public WebElement searchButton;
    @FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    public WebElement singInLink;
    @FindBy (id="contact-link")
    public WebElement contactButton;
    @FindBy (xpath = "//div[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
    public WebElement imageDress;
    @FindBy(xpath = "//ul[@id='homefeatured']//a[@class='product-name']")
    public List<WebElement> listOfProducts;

    public void enterItemtoSearch(String item){
        clearSendKeysToElement(inputSearch,item);

    }

    public void clickOnSearch(){
        safeClickOnElement(searchButton);

    }
    public AuthentificationPage clickOnSingIn(){
        safeClickOnElement(singInLink);

        return new AuthentificationPage();
    }
    public ResultSearchPage doSearch(String item){
        enterItemtoSearch(item);
        clickOnSearch();
        return new ResultSearchPage();

    }
    public ContactUsPage clickOnContact(){
        clickOnElement(contactButton);
        return new ContactUsPage();

    }
    public ItemPage clickFeaturedProduct(int productIndex) {
        try {
            clickOnElement(listOfProducts.get(productIndex));
        } catch (IndexOutOfBoundsException e) {
            clickOnElement(listOfProducts.get(listOfProducts.size() - 1));
        }
        return new ItemPage();
    }


}
