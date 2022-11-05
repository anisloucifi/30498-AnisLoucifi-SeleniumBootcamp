package pages_lib;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {
    @FindBy(xpath = "//div[@id='HOOK_PAYMENT']/div[1]/div/p/a")
    public WebElement payByBankWireButton;

    @FindBy (xpath = "//p[@id='cart_navigation']/button")
    public WebElement confirmOrderButton;

    @FindBy (xpath = "//div[@id='center_column']/div/p/strong")
    public WebElement confirmationMessage;

    public PaymentPage() {

        PageFactory.initElements(driver, this);

    }

    public void clickPayByBankWireButton() {

        clickOnElement(payByBankWireButton);

    }

    public void clickConfirmOrderButton() {

        clickOnElement(confirmOrderButton);

    }


    public String getConfirmationMessage() {
        return getTrimmedElementText(confirmationMessage);
    }

}

