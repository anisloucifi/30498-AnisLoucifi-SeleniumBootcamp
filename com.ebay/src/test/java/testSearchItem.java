import base.BasePage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testSearchItem extends BasePage {
    @Test
    public void testSearch(){
   HomePage homepage=new HomePage();
    SearchResultPage searchResultPage = homepage.doSearch("jordan");
	 Assert.assertEquals(searchResultPage.getNumberProductsSearched(), "60");
}


}
