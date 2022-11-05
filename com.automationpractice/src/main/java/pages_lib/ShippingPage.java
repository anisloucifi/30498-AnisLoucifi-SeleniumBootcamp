package pages_lib;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage  extends BasePage {
    @FindBy(id = "cgv")
    public WebElement termsOfServiceCheckbox;

    @FindBy (xpath = "//button[@name='processCarrier']")
    public WebElement proceedToCheckoutButton;

    public ShippingPage() {

        PageFactory.initElements(driver, this);

    }



    public PaymentPage proceedToPayment() {

        safeClickOnElement(termsOfServiceCheckbox);
        clickOnElement(proceedToCheckoutButton);

        return new PaymentPage();

    }
}
