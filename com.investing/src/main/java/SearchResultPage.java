import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage {
public SearchResultPage(){
    PageFactory.initElements(driver,this);
}
@FindBy (xpath = "//span[text()='Amazon.com Inc']")
    public WebElement textResult;
}
