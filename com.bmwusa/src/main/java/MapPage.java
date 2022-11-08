import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MapPage extends BasePage {
    public MapPageg() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='location-search']")
    public WebElement locationField;
    @FindBy(xpath = "//button[@name='location-search-submit']")
    public WebElement searchlocButton;
    @FindBy (xpath = "//div[@title='1 - BMW of Manhattan. 555 W 57th St, New York.']")
    public WebElement locationWanted;
    @FindBy (xpath = "//div[@class='filterable-list-view__detail-header--content']")
    public WebElement locationDisplay;

    public void inputlocation(String location) {
        sendKeysToElement(locationField,location);


    }
    public void clickOnSearchloc() {
        clickOnElement(searchlocButton);

    }
    public void clickOnlocationWanted(){
        clickOnElement(locationWanted);
    }
    public boolean getLocationWated() {
        if (locationDisplay.isDisplayed()) {
            return true;
        } else return false;
    }



}
