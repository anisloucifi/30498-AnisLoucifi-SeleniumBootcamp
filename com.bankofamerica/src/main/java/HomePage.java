import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePage extends BasePage {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "navHomeLoans")
    public WebElement homeLoansButton;
    @FindBy(id = "navAutoLoans")
    public WebElement autoLoanButton;
    @FindBy(id = "finCenterLocator")
    public WebElement closetCenterLink;
    @FindBy(id = "lid684163")
    public WebElement locationWanted;
    @FindBy(xpath = "//a[@id='navAutoLoans']/span[3]")
    public WebElement autoloanLink;
    @FindBy(id = "useAutoLoanCalculator")
    public WebElement autoLoanCalcLink;
    @FindBy (id = "mortgage")
    public WebElement mortageLink;


    public FinancialCenterLocatPage clickOnfindLocation() {
        clickOnElement(closetCenterLink);
        return new FinancialCenterLocatPage();
    }

    public HomeCalculatePage navigateToMortage() {
        clickOnElement(homeLoansButton);
        safeClickOnElement(mortageLink);
        return new HomeCalculatePage();
    }

    public void clickOnautoLoan() {
        safeClickOnElement(autoloanLink);
    }

    public AutoCalculatePage clickOnCalculateLoan() {
        safeClickOnElement(autoLoanCalcLink);
        return new AutoCalculatePage();
    }

    public AutoCalculatePage navigateToCalculateAutoloan(){
        clickOnautoLoan();
        clickOnCalculateLoan();
        return new AutoCalculatePage();
    }
}
