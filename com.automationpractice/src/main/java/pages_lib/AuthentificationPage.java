package pages_lib;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthentificationPage extends BasePage {
    public AuthentificationPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "email")
    public WebElement inputusername;
    @FindBy(id = "passwd")
    public WebElement inputpassword;
    @FindBy(id = "SubmitLogin")
    public WebElement loginButton;
    public void enterUserName(String username) {
        sendKeysToElement(inputusername, username);
    }

    public void enterPassword(String password) {
        sendKeysToElement(inputpassword, password);
    }

    public void clickOnLogin() {
        clickOnElement(loginButton);

    }

    public MyAccountPage doLogin(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickOnLogin();
       return new MyAccountPage();
    }
    public ShippingAPage SigneIn(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickOnLogin();
        return new ShippingAPage();
    }
}
