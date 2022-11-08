import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesignPage extends BasePage {
    public DesignPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='button-next byo-core-type label-1 theme-core']")
    public WebElement nextButton;
    @FindBy (xpath = "//div[@listprice='0']")
    public WebElement modeLux;
    @FindBy (xpath = "//div[@title='Alpine White']")
    public WebElement colorWhite;
    @FindBy (xpath = "//div[@wheelstyle='St yle 905']")
    public WebElement wheelButton;
    @FindBy (xpath = "//div[@title='Mocha Extended Merino Leather']")
    public WebElement upholstery;
    @FindBy (id = "Trim_selector")
    public WebElement tirmSelector;
    @FindBy (id = "//div[@title='Mirror Oak High Gloss Trim']")
    WebElement mirrorButton;
    @FindBy (xpath = "//a[@class='router-link-exact-active router-link-active']")
    WebElement summaryLink;
    @FindBy (xpath ="//*[@id='Studio']/div[1]/div/div[1]/div[1]/div/div/div[2]/div[2]/section[2]/div[2]/div/div/a")
    public WebElement estimatedPayment;

    public BuildYourOwnPage customizeCar() {
        clickOnElement(modeLux);
        clickOnElement(nextButton);;
        clickOnElement(colorWhite);
        clickOnElement(nextButton);
        clickOnElement(wheelButton);
        clickOnElement(nextButton);
        clickOnElement(upholstery);
        clickOnElement(nextButton);
        clickOnElement(upholstery);
        clickOnElement(tirmSelector);
        clickOnElement(mirrorButton);
        safeClickOnElement(summaryLink);
        clickOnElement(estimatedPayment);

        return new BuildYourOwnPage();
    }
}
