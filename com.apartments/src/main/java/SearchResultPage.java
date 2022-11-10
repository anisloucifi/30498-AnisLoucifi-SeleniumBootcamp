import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@class='placard-content']")
    public List<WebElement> listApartm;
    @FindBy(xpath = "//div[@id='placardContainer']/ul/li[1]/article/header/div[3]/a")
    public WebElement favoriteButton;
    @FindBy (id = "notificationsFavoritesCount")
    public WebElement favoriteCount;
    @FindBy (id = "rentRangeLink")
    public WebElement priceDropDawn;
    @FindBy(id = "min-input")
    public WebElement minPrice;
    @FindBy(id = "max-input")
    public WebElement maxPrice;
    @FindBy(xpath = "//div[@class='price-range']")
    public List<WebElement> listPrices;
    @FindBy(id = "sortSearchIcon")
    public WebElement sortButton;

    @FindBy(xpath = "//ul[@class='sortMenu']//li")
    public List<WebElement> sortingList;




    public boolean isDisplay() {
    if (listApartm.size() == 25) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listApartm));
        return true;
    }else  return  false;
}
public void clickOnFavorite(){
    clickOnElement(favoriteButton);
}
public boolean getFavoriteCount(){
     if(favoriteCount.isDisplayed()){
         return true;}
    else return false;
     }
     public void selectPricefilter(String min , String max){
    clickOnElement(priceDropDawn);
    sendKeysToElement(minPrice,min);
    sendKeysToElement(maxPrice,max);
    clickOnElement(sortButton);
    webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listPrices));

     }
     public List<Integer> getListPrices(){
    List<String> elements = getListTrimmedElements(listPrices);
         List<Integer> price = new ArrayList<Integer>();
     for(String s : elements){
         s = s.replace("$", "");
         s = s.replace(",", "");
         if (s.endsWith("/mo")) {
             s = s.substring(0, s.length() - 4);
         }
         price.add(Integer.parseInt(s));

     }
     return price;

     }
     public boolean isMatched(int min,int max) {

         for (Integer s : getListPrices()) {
             webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listPrices));
             if (s > min || s < max) {
                 return true;
             }
         }
         return false;
     }
    public void clickOnSortButton() {
        safeClickOnElement(sortButton);
    }

    public void selectDropDawnSorting(String option) {
        for (WebElement element : sortingList) {
            if (getTrimmedElementText(element).equals(option)) {
                safeClickOnElement(element);
                break;
            }
        }


    }

    public List<Integer> sortedPrice(){
        List<Integer> prices = getListPrices();
        List<Integer> sortedprices = new ArrayList<>(prices);
        Collections.sort(sortedprices,Collections.reverseOrder());
        return sortedprices;
    }
    public void doSort(String option) {
        clickOnSortButton();
        selectDropDawnSorting(option);
    }


}

