package smoke_test;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_lib.AuthentificationPage;
import pages_lib.HomePage;
import pages_lib.MyAccountPage;


public class Autontification extends BasePage {
    @Test
    public void testlogin(){
        HomePage homePage=new HomePage();
        AuthentificationPage log = homePage.clickOnSingIn();
        String[][] data =excel.readStringArrays("sheet1");
        MyAccountPage account = log.doLogin(data[2][0],data[2][1]);
        Assert.assertTrue(account.isSingOutLinkDisplay(),"on line");



    }
}
