import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarPage extends BasePage {
    public CalendarPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='main-nav']/div[2]/button")
    public WebElement createButton;
    @FindBy(xpath = "//div[@class='rbc-month-view']")
    public WebElement table;
    @FindBy(xpath = "//div[@class='item']/a")
    public WebElement manageCalendarButton;
    @FindBy(id = "rufous-sandbox")
    public WebElement iFrameCalendar;
    @FindBy(name = "calendarName")
    public WebElement calendarNameField;
    @FindBy(xpath = "//button[@class='ui mini icon right floated button basic']")
    public WebElement addPlusButton;
    @FindBy(xpath = "//button[@class='ui linkedin small button']")
    public WebElement addButton;
    @FindBy(xpath = "//div[@class='actions']//button[@class='ui button']")
    public WebElement closeFrame;
    @FindBy(xpath = "//div[@class='item calendar-icon']/div[2]")
    public List<WebElement> calendarsIcon;
    @FindBy (xpath = "//div[@class='item']//label" )
    public List<WebElement> listCalendar;
    @FindBy (xpath = "//i[@class='black trash icon']")
    public WebElement trachButton;
    @FindBy (xpath = "//button[@class='ui red small button']")
    public WebElement deleteButton;
    @FindBy (xpath = "//i[@class='black edit icon']")
    public WebElement editButton;
    @FindBy(xpath = "//input[@name='calendarName']")
    public WebElement editField;
    @FindBy (xpath = "//button[@class='ui blue button']")
    public WebElement saveEditButton;
    public boolean isTableDisplay() {
        if (table.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void clickOnManageCalendar() {
        safeClickOnElement(manageCalendarButton);
    }

    public void clickOnAddCalendar() {
        safeClickOnElement(addPlusButton);
    }

    public void enterCalendarName(String calendarName) {
        clearSendKeysToElement(calendarNameField, calendarName);
    }

    public void clickOnAddButton() {
        safeClickOnElement(addButton);
    }

    public void clickOnCloseButton() {
        safeClickOnElement(closeFrame);
    }
    public void addCalendar(String calendarName){
        clickOnManageCalendar();
        clickOnAddCalendar();
        enterCalendarName(calendarName);
        clickOnAddButton();
        clickOnCloseButton();
    }
//    public List<String> getListCalendar(){
//        webDriverWait.until(ExpectedConditions.invisibilityOfAllElements(calendarsIcon));
//        return  getTextListTrimmedTextElements(listCalendar);
//    }



    public void deletCalendar(String calendar){
        for(WebElement element : calendarsIcon){
            if(getTrimmedElementText(element).equals(calendar)) {
                safeClickOnElement(trachButton);
                safeClickOnElement(deleteButton);
            }
        }
    }
    public void editCalendar(String calendar,String newCalendarName){
        for(WebElement element : calendarsIcon){
            if(getTrimmedElementText(element).equals(calendar)) {
                safeClickOnElement(editButton);
                clearSendKeysToElement(editField,newCalendarName);
                safeClickOnElement(saveEditButton);
            }
        }
    }
    public void doEditCalendar(String calendar,String newCalendarName){
        clickOnManageCalendar();
        editCalendar(calendar,newCalendarName);
        clickOnCloseButton();

    }

    public void doDeletCalendar(String calendar){
        clickOnManageCalendar();
        deletCalendar(calendar);
        clickOnCloseButton();

    }
}