package pages_lib;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage {

    public ContactUsPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "id_contact")
    public WebElement uniformDropDawn;
    @FindBy (id = "email")
    public WebElement emailField;

    @FindBy (id = "message")
    public WebElement messageField;
    @FindBy (id = "submitMessage")
    public WebElement submitButton;

    public void selectSubjectHeading(String uniform){
        selectFromDropdownByVisibleText(uniformDropDawn,uniform);
    }
    public void enterEmailAddress(String email){
        clearSendKeysToElement(emailField,email);
    }
    public void enterMessage(String message){
        sendKeysToElement(messageField,message);
    }
    public MessageSentPage clickOnSubmitMessage(){
        clickOnElement(submitButton); ////div[@id="center_column"]/p

        return new MessageSentPage();
    }
}
