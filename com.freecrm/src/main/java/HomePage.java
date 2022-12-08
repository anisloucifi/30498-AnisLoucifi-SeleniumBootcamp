import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//div[@id='navbar-collapse']/ul/li[1]/a")
    public WebElement loginLink;

    public LoginPage clickOnLogin(){
        safeClickOnElement(loginLink);
        return new LoginPage();
    }
}
