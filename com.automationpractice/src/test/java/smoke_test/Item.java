package smoke_test;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages_lib.HomePage;
import pages_lib.ItemPage;
import pages_lib.ResultSearchPage;

public class Item extends BasePage {

    @Test

    public void testAddToCart(){
        HomePage hp = new HomePage();
        String[] data =excel.readStringArray("sheet2");
        ResultSearchPage result = hp.doSearch(data[0]);
        ItemPage itempage=result.clickOnItem(result.imageDress);
        itempage.clickOnAddToCartItem();
        itempage.clickOnContinueShoppingButton();
        itempage.hoverOnShoppingCart();
        Assert.assertTrue(itempage.getItemNumberInCart()==1,"the item is successfully added");


    }
    @Test
    public void testChangeQuantitie(){
        HomePage hp = new HomePage();
        String[] data =excel.readStringArray("sheet2");
        ResultSearchPage result = hp.doSearch(data[0]);
        ItemPage itempage=result.clickOnItem(result.imageDress);
        itempage.clickonPlusButton();
        itempage.clickonPlusButton();
        itempage.clickOnAddToCartItem();
        itempage.clickOnContinueShoppingButton();
        Assert.assertTrue(itempage.checkIteminCart()>1,"quantity is increased ");
    }
    @Test
    public void testChangeColor(){
        HomePage hp = new HomePage();
        String[][] data =excel.readStringArrays("sheet2");
        ResultSearchPage result = hp.doSearch(data[0][0]);
        ItemPage itempage=result.clickOnItem(result.imageDress);
         itempage.clickOnColor(data[2][1]);
        itempage.clickOnAddToCartItem();
        itempage.clickOnContinueShoppingButton();
        try {
            Assert.assertTrue(itempage.getItemSizeColor().contains(data[2][1]), "the color changed");
        }catch (Exception e){
            System.out.println("something went wrong");
        }

    }
    @Test public void testChangesize(){
        HomePage hp = new HomePage();
        String[][] data =excel.readStringArrays("sheet2");
        ResultSearchPage result = hp.doSearch(data[0][0]);
        ItemPage itempage=result.clickOnItem(result.imageDress);
        itempage.selectSize(data[1][2]);
        itempage.clickOnAddToCartItem();
        itempage.clickOnContinueShoppingButton();
        Assert.assertTrue(itempage.getItemSizeColor().contains(data[1][2]), "the color changed");

    }
}
