package smoke_test;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_lib.HomePage;
import pages_lib.ResultSearchPage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Sorting_Fonctinality extends BasePage {
    @Test
    public void testSortingHeightToLow(){
        HomePage homePage=new HomePage();
        ResultSearchPage resultSearchPage = homePage.doSearch("Dress");
        resultSearchPage.selectSortingType("Price: Highest first");
        // get the list of prices
        List<String> prices = resultSearchPage.getListOfPrices();
        // create a other list from the old list element
        List<String> sortedPrices = new ArrayList<String>(prices);
        Collections.sort(sortedPrices,Collections.reverseOrder());
        Assert.assertTrue(prices==sortedPrices,"");




    }
}

