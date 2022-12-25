import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='register bold']")
    public WebElement SignUpBtnOnHeaderHomePage;

    @FindBy(xpath = "//a[@class='login bold']")
    public WebElement signinLink;

    @FindBy(id = "loginFormUser_email")
    public WebElement emailField;

    @FindBy(id = "loginForm_password")
    public WebElement passwordField;

    @FindBy(xpath = "//a[@class='newButton orange']")
    public WebElement SigninButtonInsideForm;

    @FindBy (xpath = "//span[text()='AnisQA']")
    public WebElement  userName;

    @FindBy(xpath = "//div[@id='signup']//a[@id='signUPBtn']")
    public WebElement SignupBtninsideForm;

    @FindBy(xpath = "//input[@id='in_user_firstname']")
    public WebElement FirstNameForSignUp;

    @FindBy(xpath = "//input[@id='in_user_lastname']")
    public WebElement LstNameForSignUp;

    @FindBy(xpath = "//input[@id='in_user_email']")
    public WebElement EmailForSignUp;

    @FindBy(xpath = "//input[@id='in_password']")
    public WebElement PasswordForSignUp;
    @FindBy (id = "serverErrors")
    public WebElement errorMsg;

    @FindBy(xpath = "//input[@placeholder='Search the website...']")
    public WebElement searchField;

    @FindBy(xpath = "//label[@class='searchGlassIcon js-magnifying-glass-icon']")
    public WebElement searchbutton;

    // method region
    public void doSigneIn(String username, String password)
    {
        safeClickOnElement(signinLink);
        sendKeysToElement(emailField,username);
        sendKeysToElement(passwordField,password);
        safeClickOnElement(SigninButtonInsideForm);
    }
    public String getuserName(){
       return getTrimmedElementText(userName);

    }
    public SearchResultPage doSearch(String item)
    {
        sendKeysToElement(searchField,item);
        safeClickOnElement(searchbutton);
        return new SearchResultPage();
    }

}
