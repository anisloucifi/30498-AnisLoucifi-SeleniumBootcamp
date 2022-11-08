import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='globalnav-primary__links']/li[2]/a")
    public WebElement locationButton;
    @FindBy(xpath = "//*[@id='animation-container-2b17aad8-55b2-4ded-a189-5d59c1163138']/div/div/div/div/div/div/section/a")
    public WebElement buildYourOwnL;
    @FindBy(xpath = "//div[1]/div/div/div[2]/div[5]/div/div[1]/div/div[3]/div/form/div")
    public WebElement searchV;
    @FindBy (className="site search")
    public WebElement searchField;
    @FindBy (xpath = " //div[1]/div/div/div[2]/div[4]/div/nav/div[2]/div/form/div/button[1]")
    WebElement searchV2;
    @FindBy (xpath = "//div[2]/div[2]/footer/div[1]/div/nav")
    public List<WebElement> series;

    //    @FindBy (className = "//button[@class='globalnav-primary-location-bar__dealer-name label-2--bold']")
//    public WebElement locationButton;
    public MapPage clickOnlocation() {
        safeClickOnElement(locationButton);
        return new MapPage();
    }
    public void clickOnSearch(){
        clickOnElement(searchV);
    }

    public BuildYourOwnPage clickBuildYourOwnLink() {
        moveToElementAndClick(buildYourOwnL);
        return new BuildYourOwnPage();
    }

    public void sendtextTosearchfield(String car){
        sendKeysToElement(searchField,car);
    }
    public void chooseModel(WebElement mod){
        for(WebElement element: series){
            hoverOverElement(mod);
        }
    }


}
