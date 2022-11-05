package smoke_test;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_lib.*;

import java.util.logging.Handler;

public class CheckOut extends BasePage {
    @Test
    // we test to passing the order
    public void passingOrder() {
        HomePage homePage = new HomePage();
        String[][] data = excel.readStringArrays("sheet1");
        String[][] data2 = excel.readStringArrays("sheet2");
        ResultSearchPage result = homePage.doSearch(data2[0][0]);
        ItemPage itpage=result.clickOnItem(result.imageDress);
        CheckOutPage procced = itpage.proccedToCheckout();
        AuthentificationPage login = procced.clickProceedToCheckoutButton();
        ShippingAPage account = login.SigneIn(data[2][0], data[2][1]);
        ShippingPage shipping = account.clickProceedToCheckOutButton();
        PaymentPage pay = shipping.proceedToPayment();
        pay.clickPayByBankWireButton();
        pay.clickConfirmOrderButton();
        Assert.assertEquals(pay.getConfirmationMessage(),"order confirmed ");


    }
}
