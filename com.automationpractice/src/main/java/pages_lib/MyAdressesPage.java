package pages_lib;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAdressesPage extends BasePage {
    public MyAdressesPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='clearfix main-page-indent']/a")
    public WebElement addNewAddressButton;
    @FindBy (xpath = "//h3[@class='page-subheading']")
    public static WebElement subheading;






    public AddNewAddrPage clickAddNewAddressButton(){
        clickOnElement(addNewAddressButton);
        return  new AddNewAddrPage();
    }

}
