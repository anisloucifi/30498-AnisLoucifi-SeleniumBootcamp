import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchFlightsPage extends BasePage {
    public SearchFlightsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "GsNP-switch")
    public List<WebElement> flightType;
    @FindBy(id = "rsfr-origin-airport")
    public WebElement homeAirportField;
    @FindBy(xpath = "//*[@id=\"c0c_x-origin-airport-smartbox-dropdown\"]/ul[2]")
    public List<WebElement> listAirports;

    @FindBy(id = "rsfr-destination-airport-display-inner")
    public WebElement destinationField;
    @FindBy(xpath = "//div[@id='rsfr-depart']/div[1]/svg/use")
    public WebElement calender;
    @FindBy(xpath = "//tbody//tr/td")
    public List<WebElement> days;
    @FindBy(id = "rsfr-submit")
    public WebElement searchButton;
    @FindBy(xpath = "//div[@class='css-hm3w49']")
    public WebElement fromContainer;

    public void chooseType(String trip) {
        for (WebElement element : flightType) {
            if (getTrimmedElementText(element).equals(trip)) {
                safeClickOnElement(element);
                break;
            }
        }
    }

    public void enterHomeAiroport(String airoport) {
        sendKeysToElement(homeAirportField, airoport);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"c0c_x-origin-airport-smartbox-dropdown\"]/ul[2]")));
        safeClickOnElement(listAirports.get(0));
    }

    public void enterDestinationAiroport(String destination) {
        clearSendKeysToElement(destinationField, destination);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='c0c_x-origin-airport-smartbox-dropdown']/ul[2]")));
        safeClickOnElement(listAirports.get(0));

    }

    public void clickOnCalendar(){
        safeClickOnElement(calender);
    }
    public void chooseDepartDate(String day) {
        for (WebElement element : days) {
            if (getTrimmedElementText(element).equals(day)) {
                safeClickOnElement(element);
                break;
            }
        }

    }

    public void clickOnSearch() {
        clickOnElement(searchButton);
    }
    public void doSearch(String trip,String airoport,String date,String destination){
        chooseType(trip);
        enterHomeAiroport(airoport);
        enterDestinationAiroport(destination);
        clickOnCalendar();
        chooseDepartDate(date);
        clickOnSearch();

    }
}
