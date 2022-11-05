package pages_lib;

import base.BasePage;
import config.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAPage extends BasePage {
    public ShippingAPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//div[@id='center_column']/form/p/button")
    public WebElement proceedToCheckoutButton;

    public ShippingPage clickProceedToCheckOutButton() {

        clickOnElement(proceedToCheckoutButton);

        return new ShippingPage();

    }
}
