import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RentalCalculatorPage extends BasePage {
    public RentalCalculatorPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "monthlyIncome")
    public WebElement income;
    @FindBy (id = "searchButton")
    public WebElement searchButton;
    @FindBy (id = "result")
    public WebElement rentalPrice;
    @FindBy (id = "income-percentage-label")
    public WebElement rate;
    @FindBy (xpath = "//*[@id='tickmarks']/p[3]")
    public WebElement fiftypercent;
    @FindBy (id = "sliderInput")
    public WebElement sliderInput;


    public void enterMonthlyIncome(String amount){
        clearSendKeysToElement(income,amount);
    }
    public void changePercentage(int per){
        sendKeysToElement(sliderInput, String.valueOf(per));
    }
    public int getResult(){
        String result=getTrimmedElementText(rentalPrice);
        result = result.replace("$","");
        result = result.replace(",","");
        return Integer.parseInt(result);

    }
    public void clickOnSearch(){
        clickOnElement(searchButton);
    }
    public int getValueBaseOnRate(int value, int percentage){

        int calcule=0;
        calcule=(value*percentage)/100;
        return calcule;
    }
}
