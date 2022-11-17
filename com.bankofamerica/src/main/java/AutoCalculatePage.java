import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoCalculatePage extends BasePage {
    public AutoCalculatePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "stateSelectModal")
    public WebElement selectState;

    @FindBy(id = "stateSelectorSubmit")
    public WebElement goButton;

    @FindBy(xpath = "//input[@id='totalLoanAmountField']")
    public WebElement totalAmountField;

    @FindBy(xpath = "//input[@id='term']")
    public WebElement termField;

    @FindBy(xpath = "//input[@id='interestRateField']")
    public WebElement interestRateField;

    @FindBy(xpath = "//a[@id='calculateButton']")
    public WebElement calculateButton;

    @FindBy(xpath = "//span[@id='amount']")
    public WebElement estimate;

    //method region

    public AutoCalculatePage setSelectState(String state){
        selectFromDropdownByVisibleText(selectState,state);
        return new  AutoCalculatePage();
    }
    public void clickOnSubmit(){
        safeClickOnElement(goButton);

    }


    public void enterTotalLoanAmount(String amount){
        clearSendKeysToElement(totalAmountField,amount);
    }
    public void enterTerm(String term){
        clearSendKeysToElement(termField,term);
    }
    public void enterInterestRate(String interestRate){
        clearSendKeysToElement(interestRateField,interestRate);
    }
    public void clickOnCalculateButton(){
        clickOnElement(calculateButton);
    }
    public void doCalculate(String amount, String term,String interestRate){
        enterTotalLoanAmount(amount);
        enterTerm(term);
        enterInterestRate(interestRate);
        clickOnCalculateButton();
    }
    public String getEstimatePayment(){
        return getTrimmedElementText(estimate);
    }


}

