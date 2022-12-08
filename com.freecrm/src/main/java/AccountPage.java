import base.BasePage;
import config.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;

public class AccountPage extends BasePage {
    public AccountPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//i[@class='home icon']")
    public WebElement menu;

    @FindBy(xpath = "//div[@id='main-nav']//a")
    public List<WebElement> menuList;

    @FindBy (xpath = "//span[@class='user-display']")
    public WebElement header;

    public void hoverOnMenu(){
        hoverOverElement(menu);
    }
    public void listMenu(String option){
        for(WebElement element : menuList){
            if(getTrimmedElementText(element).equals(option)) {
                safeClickOnElement(element);
                break;
            }
            }


        }
        public CalendarPage clickOnCalendar(){
        hoverOnMenu();
        listMenu("Calendar");
        return new CalendarPage();
        }

        public String getUserName(){
       return  getTrimmedElementText(header);
    }
}

