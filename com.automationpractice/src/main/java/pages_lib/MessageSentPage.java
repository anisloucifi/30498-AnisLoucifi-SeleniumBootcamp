package pages_lib;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageSentPage extends BasePage {
    public MessageSentPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//div[@id='center_column']/p")
    public WebElement messageDisplay;

    public boolean isDisplayMessage(){
        isElementVisible(messageDisplay);
        return true;
    }
}

