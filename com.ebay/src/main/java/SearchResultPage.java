import base.BasePage;
import org.apache.bcel.generic.IFLE;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {
    public SearchResultPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//*[@id='x-refine__group_1__3']/ul/li[8]/div/a/div/span/input")
    public WebElement leviCheckbox;
    @FindBy (xpath = "//div[@id='x-refine__group_1__1']/ul/li[1]/div/a/div/span/input")
    public WebElement modelCheckbox;
    @FindBy(id = "srp-ipp-menu")
    public WebElement numProductSearch;


    @FindBy(xpath = "//div[@class='s-item__title']//span")
    public List<WebElement> listItemName;


    @FindBy(xpath = "//span[@class='s-item__price']")
    public List<WebElement> listItemPrices;


    @FindBy(xpath = "//span[@class='SECONDARY_INFO']")
    public List<WebElement> itemConditionStatus;


    @FindBy(xpath = "//span[text()='Shipping']")
    public WebElement shippingDropDown;


    @FindBy(xpath = "//div[@class='srp-controls--responsive srp-controls__row-cells left']/div[2]/span[2]/span/div/div")
    public WebElement freeShippingCheckBox;


    @FindBy(xpath = "//span[@class='POSITIVE BOLD']")
    public List<WebElement> itemShippingStatus;


    @FindBy(xpath = "//span[text()='Condition']")
    public WebElement conditionDropDown;


    @FindBy(xpath = "//div[@class='srp-controls--responsive srp-controls__row-cells left']/div[2]/span[1]/span/div/div")
    public List<WebElement> conditionsOption;


    @FindBy(xpath = "//button[@class='faux-link follow-ebay__trigger']")
    public WebElement saveSearchButton;


    @FindBy(xpath = "//span[@class='s-item__watchheart-icon']")
    public List<WebElement> listAddToWatchListButton;


    @FindBy(xpath = "//div[@class='srp-sort srp-sort--filter-evolution']//span")
    public WebElement bestMatchDropDown;


    @FindBy(xpath = "//ul[@id='s0-52-12-5-4[1]-34-1-content-menu']//li//a")
    public List<WebElement> bestMatchOption;


    @FindBy(xpath = "//ul[@class='fake-tabs__items']/li[3]")
    public WebElement auctionButton;


    @FindBy(xpath = "//span[@class='s-item__bids s-item__bidCount']")
    public List<WebElement> numbersBids;
    @FindBy (id = "s0-52-12-0-1-2-6-0-7[3]-0-textrange-beginParamValue-textbox")
    public WebElement minPrice;
    @FindBy (id = "s0-52-12-0-1-2-6-0-7[3]-0-textrange-endParamValue-textbox")
    public WebElement maxPrice;













    //method region
    public String getNumberProductsSearched() {
        return getTrimmedElementText(numProductSearch);
    }
    public void clickOnShippingDropDown(){
        safeClickOnElement(shippingDropDown);
    }
    public void clickOnFreeShippingCheckBox(){
        safeClickOnElement(freeShippingCheckBox);
    }
    public void doFilterFreeShipping(){
        clickOnShippingDropDown();
        clickOnFreeShippingCheckBox();
    }
    public void clickOnConditionDropDown(){
        safeClickOnElement(conditionDropDown);
    }
    public void clickOnConditionOption(String option){
        for(WebElement element : conditionsOption){
            if (element.getText().equals(option)){
                safeClickOnElement(element);break;
            }
        }
    }


    public void doFilterByItemCondition(String condition){
        clickOnConditionDropDown();
        clickOnConditionOption(condition);
    }


    public List<String> getListItemName() {
        return getListTrimmedElements(listItemName);
    }
    public List<Float> getListItemPrice(){
        List<String>stringPrices = new ArrayList<String>();
        for(WebElement element : listItemPrices){
            stringPrices.add(element.getText());
        }
        List<Float> prices = new ArrayList<Float>();
        for(String s : stringPrices){
            if(s.startsWith("$")){
                s = s.replace("$", "");
                s = s.replace(",", "");
                prices.add(Float.parseFloat(s));}
        }
        return prices;
    }
    public List<String> getItemConditionStatus(){
        List<String> status = new ArrayList<>();
        for (WebElement element : itemConditionStatus){
            if(!element.getText().equals("")){
                status.add(element.getText());
            }
        }
        return status;
    }


    public List<Float> getListPrice(float min,float max){
        List<Float> price = new ArrayList<>();
        if(min<=500){
            price.add(min);
        }
        return  price;
    }

    public List<String> getItemShippingStatus(){
        List<String> status = new ArrayList<>();
        for(WebElement element : itemShippingStatus){
            status.add(element.getText());
        }
        return status;
    }


    public void clickOnSaveSearch(){
        safeClickOnElement(saveSearchButton);
    }
    public void clickOnAddToWatchList(int index){
        safeClickOnElement(listAddToWatchListButton.get(index));
    }


    public void clickOnBestMatchDropDown(){
        safeClickOnElement(bestMatchDropDown);
    }
    public void selectSortingOption(String option){
        for(WebElement element : bestMatchOption){
            if(getTrimmedElementText(element).equals(option)){
                safeClickOnElement(element);break;
            }
        }
    }
    public void doSortItemBy(String option){
        clickOnBestMatchDropDown();
        selectSortingOption(option);
    }
    public void clickOnAuction(){
        safeClickOnElement(auctionButton);
    }


    public List<String> getNumberBids(){
        List<String> bids = new ArrayList<>();
        for(WebElement element : numbersBids){
            bids.add(element.getText());
        }
        return bids;
    }


    public ProductPage clickOnItem(int index){
        safeClickOnElement(listItemName.get(index));
        switchToTab();
        return new ProductPage();
    }

    public void clickOnBrand(WebElement brand){
        safeClickOnElement(brand);
    }

    public void clickOnModel(){
        safeClickOnElement(modelCheckbox);
    }




}


