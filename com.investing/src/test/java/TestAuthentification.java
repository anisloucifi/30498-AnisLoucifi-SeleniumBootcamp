import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.GenerateData;

public class TestAuthentification extends BasePage {

    @Test
    public void testValidLogin(){
        HomePage homePage = new HomePage();
        homePage.doSigneIn("loucifianis20@gmail.com","anis1234567");
        Assert.assertEquals(homePage.getuserName(),"AnisQA");
    }
    @Test
    public void testinValidLogin(){
        HomePage homePage = new HomePage();
        homePage.doSigneIn(GenerateData.email(),GenerateData.password());
        Assert.assertTrue(homePage.errorMsg.isDisplayed(),"");

    }
}
