import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class I7SedanPage extends BasePage {

    public I7SedanPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='selected-vehicle-cta cta-2']/a")
    public static WebElement customizeThisBuildButton;



    public DesignPage clickCustomizeThisBuild(){
        safeClickOnElement(customizeThisBuildButton);
        return  new DesignPage();
    }

}
