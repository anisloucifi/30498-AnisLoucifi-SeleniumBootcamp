import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearch extends BasePage {
    @Test
    public void testSearch(){
        HomePage homePage = new HomePage();
        SearchResultPage search=homePage.doSearch("amazon");
        Assert.assertTrue(search.textResult.isDisplayed(),"");
    }

}
