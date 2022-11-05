package pages_lib;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BasePage {
    public CheckOutPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//div[@id=\"center_column\"]/p[2]/a[1]")
    public WebElement proceedtoCheckOutbutton;

    public AuthentificationPage clickProceedToCheckoutButton() {

        clickOnElement(proceedtoCheckOutbutton);

        return new AuthentificationPage();

    }
}
