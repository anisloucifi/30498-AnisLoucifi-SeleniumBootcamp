import base.BasePage;
import io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body[@id='b2indexPage']/header/nav[1]/div[2]/div[6]/a/span")
    public WebElement singInLink;
    @FindBy(id = "profile-menu-trigger--title")
    public WebElement accountButton;
    @FindBy(xpath = "//body[@id='b2indexPage']/header/nav[2]/ul")
    public List<WebElement> header;
    @FindBy (xpath = "//*[@id=\"b2indexPage\"]/header/nav[2]/ul/li[2]/a")
    public WebElement bjc;

    public SignInPage clickOnSigneIn() {
        safeClickOnElement(singInLink);
        return new SignInPage();
    }


    public boolean isVisible() {
        return isElementVisible(accountButton);
    }

    public void clickOnHeader(String buttonlink) {
        for (WebElement element : header) {
            if (getTrimmedElementText(element) == (buttonlink)) {
                clickOnElement(element);
                break;
            }

        }
    }
    public SearchFlightsPage clickOnFlight(){
       clickOnElement(bjc);
       return new SearchFlightsPage();
    }
}
