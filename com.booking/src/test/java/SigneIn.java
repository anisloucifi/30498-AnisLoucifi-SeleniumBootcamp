
import base.BasePage;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SigneIn extends BasePage {
    @Test
    public void testSignIn(){
        HomePage homePage = new HomePage();
        String [] [] data=excel.readStringArrays("accnt");
        SignInPage sg = homePage.clickOnSigneIn();
        homePage = sg.doLogin(data[0][0],data[0][1]);
        Assert.assertTrue(homePage.isVisible(),"you are signe in");
    }


}
