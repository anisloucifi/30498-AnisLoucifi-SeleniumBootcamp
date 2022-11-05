package smoke_test;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_lib.*;

import static base.BasePage.excel;

public class ContactUs extends BasePage {
    @Test
    public void testContactUs(){
        HomePage homePage = new HomePage();
        String[][] data =excel.readStringArrays("sheet1");
        ContactUsPage contact = homePage.clickOnContact();
        contact.selectSubjectHeading("Customer service");
        contact.enterEmailAddress(data[2][0]);
        contact.enterMessage("cancel my order");
        MessageSentPage result = contact.clickOnSubmitMessage();
        Assert.assertTrue(result.isDisplayMessage(), "message sent");
    }
}
