import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddPropertyPage extends BasePage {
    public AddPropertyPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "iframeAddProperty")
    public WebElement iframeAddProperty;
    @FindBy(xpath = "//div[@class='recaptcha']/div//iframe")
    public WebElement iframeCheckBox;
    @FindBy(id = "unitQuantityTypeMultiple")
    public WebElement multipleUnit;

    @FindBy(id = "unitQuantityTypeSingle")
    public WebElement singleUnitButton;

    @FindBy(id = "cpid1-address")
    public WebElement addressField;

    @FindBy(id = "cpid1-propertyType")
    public WebElement selectProperty;

    @FindBy(id = "cpid2-0beds")
    public WebElement selectBed;
    @FindBy(id = "//mat-option[@id='mat-option-51']/span")
    public WebElement selectadress;


    @FindBy(id = "cpid2-0baths")
    public WebElement selectBath;

    @FindBy(id = "recaptcha-anchor")
    public WebElement checkBox;


    @FindBy(xpath = "//button[contains(text(),' Add My Property ')]")
    public WebElement addPropertyButton;


    @FindBy(id = "cpid1-propertyType-3")
    public WebElement selectPropertyOption;
    @FindBy(id = "mat-option-1")
    public WebElement getSelectBed;
    @FindBy(id = "mat-option-9")
    public WebElement getSelectBath;


    public void enterAddress(String address) {
        sendKeysToElement(addressField, address);
        //safeClickOnElement(selectadress);


    }

    public void setSelectProperty() {
        clickOnElement(selectProperty);
        clickOnElement(selectPropertyOption);
    }

    public void setSelectBed() {
        clickOnElement(selectBed);
        clickOnElement(getSelectBed);
    }

    public void setSelectBath() {
        clickOnElement(selectBath);
        clickOnElement(getSelectBath);
    }

    public void clickonCheckBox() {
        safeClickOnElement(checkBox);
    }

    public void clickOnAddPropertyButton() {
        safeClickOnElement(addPropertyButton);
    }

    public void doAddProprety(String address) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(iframeAddProperty));
        switchToFrameByElement(iframeAddProperty);
        enterAddress(address);
        setSelectProperty();
        setSelectBed();
        setSelectBath();
        switchToFrameByElement(iframeCheckBox);
        clickonCheckBox();
        switchToParentFrame();
        clickOnAddPropertyButton();
    }

}
