import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.GenerateData;

public class LoanCalculate extends BasePage {
    @Test
    public void testAutoLoan(){
        HomePage homePage=new HomePage();
        AutoCalculatePage autoloan = homePage.navigateToCalculateAutoloan().setSelectState(GenerateData.state());
        autoloan.clickOnSubmit();
        autoloan.doCalculate("40000","50","5.00");
        Assert.assertEquals(autoloan.getEstimatePayment(),("888"));
    }
@Test
    public void testHomeLoan() throws InterruptedException {
        HomePage homePage =new HomePage();
        HomeCalculatePage homeloan = homePage.navigateToMortage();
        homeloan.doCalculate("300000","50000","11103");
        Thread.sleep(2000);
        Assert.assertEquals(homeloan.getResult(),("$1,577"));
}
}
