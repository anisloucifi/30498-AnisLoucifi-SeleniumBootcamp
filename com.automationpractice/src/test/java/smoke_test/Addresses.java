package smoke_test;

import base.BasePage;
import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_lib.*;

public class Addresses extends BasePage {
    @Test
    public void testAddnewAdress(){
        HomePage hp = new HomePage();
        AuthentificationPage lg= hp.clickOnSingIn();
        String[][] data =excel.readStringArrays("sheet1");
        MyAccountPage account = lg.doLogin(data[2][0],data[2][1]);
        MyAdressesPage listadres = account.clickOnAdresses();
        AddNewAddrPage newadd = listadres.clickAddNewAddressButton();
        MyAdressesPage list = newadd.updatenewAddress("astoria", "newyork" , "New York", "11103","United States", "333222444","new address");

        WebElement addressesHeader = MyAdressesPage.subheading;

        Assert.assertTrue(addressesHeader.isDisplayed(), "this  header should be displayed");
    }
}
