import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(name = "password")
    public WebElement passwordField;
    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    public WebElement loginButton;
    @FindBy(xpath = "//div[@id='ui']/div/div/form/div/div[3]/p")
    public WebElement negativeMessage;

    public void enterUserName(String email) {
        sendKeysToElement(emailField, email);
    }

    public void enterPassword(String password) {
        sendKeysToElement(passwordField, password);
    }

    public void clickOnLogin() {
        safeClickOnElement(loginButton);
    }

    public AccountPage doLogin(String email, String password) {
        enterUserName(email);
        enterPassword(password);
        clickOnLogin();
        return new AccountPage();
    }

    public String getErrorMessage() {
       return getTrimmedElementText(negativeMessage);
    }
}

