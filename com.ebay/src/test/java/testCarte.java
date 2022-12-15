import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testCarte extends BasePage {
    @Test
    public void testAddToCartItem() {
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = homePage.doSearch("jordan");
        ProductPage productPage = searchResultPage.clickOnItem(1);
        CartPage cartPage = productPage.clickOnAddToCart();
        Assert.assertTrue(cartPage.getNumberItemInCart() == 1);

    }

    @Test

    public void testRemoveItemFromCart() {
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = homePage.doSearch("jordan");
        ProductPage productPage = searchResultPage.clickOnItem(2);
        CartPage cartPage = productPage.clickOnAddToCart();
        cartPage.clickOnRemoveButton();
        Assert.assertTrue(cartPage.isAlertVisible());

    }

    @Test
    public void testAddtowatchlist() {
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = homePage.doSearch("jordan");
        ProductPage productPage = searchResultPage.clickOnItem(2);
        productPage.clickOnAddToWatch();
        //Assert.assertTrue(cartPage.isAlertVisible());
    }
}