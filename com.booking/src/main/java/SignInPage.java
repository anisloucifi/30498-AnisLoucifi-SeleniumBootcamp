import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {
    public SignInPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "username")
    public WebElement emailField;

    @FindBy(xpath = "//button[@class='Iiab0gVMeWOd4XcyJGA3 wPxWIS_rJCpwAWksE0s3 Ut3prtt_wDsi7NM_83Jc TuDOVH9WFSdot9jLyXlw EJWUAldA4O1mP0SSFXPm whxYYRnvyHGyGqxO4ici']")
    public WebElement continueButton;

    @FindBy(id = "password")
    public WebElement passwordField;
    public void enterEmail(String email){
        clearSendKeysToElement(emailField,email);
    }
    public HomePage clickOnContinueButton(){
        clickOnElement(continueButton);
        return new HomePage();
    }
    public void enterPassword(String password){
        clearSendKeysToElement(passwordField,password);
    }
    public HomePage doLogin(String email, String password){
        enterEmail(email);
        clickOnContinueButton();
        enterPassword(password);
        return clickOnContinueButton();

    }
}

