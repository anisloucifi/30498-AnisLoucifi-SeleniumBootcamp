import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuildYourOwnPage extends BasePage {
    public BuildYourOwnPage(){
        PageFactory.initElements(driver,this);

    }
    @FindBy (xpath = "//a[@title='i7 Sedan']")
    public WebElement selectModButton;
    @FindBy (xpath = "//p[@class='previous-builds-cta__copy byo-core-type label-2 theme-gkl']")
    public WebElement lastBuildButton;

    public I7SedanPage clickSelect(){
        clickOnElement(selectModButton);
        return new I7SedanPage();
    }
    public boolean isDisplay(){
        if(lastBuildButton.isDisplayed()) {
            return true;}
        else return false;
        }
    }

