import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.GenerateData;

public class Testauthentification extends BasePage {
    @Test
    public void testLogin(){
        HomePage homePage = new HomePage();
        LoginPage log = homePage.clickOnLogin();
        AccountPage accountPage = log.doLogin("khalilPNT@gmail.com","PNTclass123!");
        Assert.assertEquals(accountPage.getUserName(),"khalil akbi");

    }
    @Test
    public void testInvalidlogin(){
        HomePage homePage = new HomePage();
        LoginPage log = homePage.clickOnLogin();
        AccountPage accountPage = log.doLogin(GenerateData.email(),GenerateData.password());
        Assert.assertEquals(log.getErrorMessage(),"Invalid login");

    }
}
