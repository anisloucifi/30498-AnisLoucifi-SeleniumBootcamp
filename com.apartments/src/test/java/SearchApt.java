import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchApt extends BasePage {
    @Test
    public void testSearchapartement()  {
        HomePage hp = new HomePage();
        String[][] data = excel.readStringArrays("location");
        SearchResultPage search = hp.doSearch(data[0][0]);
        Assert.assertTrue(search.isDisplay(),"");
    }
    @Test
    public void testFavorite()  {
        HomePage hp = new HomePage();
        String[][] data = excel.readStringArrays("location");
        SearchResultPage search = hp.doSearch(data[0][0]);
        search.clickOnFavorite();
        Assert.assertTrue(search.getFavoriteCount(),"");
    }
@Test
    public void testfixprice() {
    HomePage hp = new HomePage();
    String[][] data = excel.readStringArrays("location");
    SearchResultPage search = hp.doSearch(data[0][0]);
    search.selectPricefilter("700","$1200");
    Assert.assertTrue(search.isMatched(700,1200),"");

}
@Test
    public void testSortingLowToHigh(){
    HomePage hp = new HomePage();
    String[][] data = excel.readStringArrays("location");
    SearchResultPage search = hp.doSearch(data[0][0]);
    search.doSort("Rent (low to high)");
    List<Integer> prices = search.getListPrices();
    Assert.assertTrue(prices.equals(search.sortedPrice()));

}
@Test
    public void testSrtingHightoLow(){
    HomePage hp = new HomePage();
    String[][] data = excel.readStringArrays("location");
    SearchResultPage search = hp.doSearch(data[0][0]);
    search.doSort("Rent (high to low)");
    List<Integer> prices = search.getListPrices();
    Assert.assertTrue(prices.equals(search.sortedPrice()));

}
}
