package pages_lib;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {
    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Log me out']")
    public WebElement singOutLink;
    @FindBy(xpath = "//a[@title='Addresses']/span")
    WebElement addresses;
    @FindBy (id="contact-link")
    public WebElement contactButton;


    public boolean isSingOutLinkDisplay() {
        return isElementVisible(singOutLink);
    }
    public MyAdressesPage clickOnAdresses() {
        clickOnElement(addresses);
        return new MyAdressesPage();

    }
    }
