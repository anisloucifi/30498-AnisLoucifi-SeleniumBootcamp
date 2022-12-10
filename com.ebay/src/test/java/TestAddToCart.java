import base.BasePage;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class TestAddToCart extends BasePage {
    @Test
    public void testAddToCarte(){
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = homePage.dosearch("jordan");
        ProdectPage prodectPage = searchResultPage.clickOnItem(2);

    }
}
