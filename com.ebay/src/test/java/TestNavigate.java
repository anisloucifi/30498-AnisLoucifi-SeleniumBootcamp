import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNavigate extends BasePage {
    @Test
    public void testsearch(){
        HomePage homePage = new HomePage();
        SearchResultPage resultPage = homePage.dosearch("jordan");
        Assert.assertEquals(resultPage.getResultNumber(),"60");

    }
}
