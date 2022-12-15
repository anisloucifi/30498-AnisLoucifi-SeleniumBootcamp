import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFilter extends BasePage {
    @Test
    public void testfilterOnBrand(){
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = homePage.doSearch("jordan");
        searchResultPage.clickOnBrand(searchResultPage.leviCheckbox);
        ProductPage productPage = searchResultPage.clickOnItem(2);
        Assert.assertTrue(productPage.getItemName().contains("levis"));
    }
    @Test
    public void testfilterModel(){
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = homePage.doSearch("jordan");
        searchResultPage.clickOnModel();
        ProductPage productPage = searchResultPage.clickOnItem(1);
        Assert.assertTrue(productPage.getItemName().contains("jordan 4 levis"));
    }
    @Test
    public void testfilterPrice(){
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = homePage.doSearch("jordan");
        searchResultPage.clearSendKeysToElement(searchResultPage.minPrice,"100");
        searchResultPage.clearSendKeysToElement(searchResultPage.maxPrice,"500");
        Assert.assertEquals(searchResultPage.getListItemPrice(),searchResultPage.getListPrice(100,500));
    }

}
