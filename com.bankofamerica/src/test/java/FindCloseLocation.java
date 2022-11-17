import base.BasePage;
import io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FindCloseLocation extends BasePage {
    @Test // test location search
    public void testLocation(){
        HomePage hp=new HomePage();
        FinancialCenterLocatPage loc =hp.clickOnfindLocation();
        loc.enterZipCode("11103");
        loc.clickOnsearch();
        Assert.assertTrue(loc.isListOfAdressesDisplay(),"");
    }
    @Test // test add to favorite
    public void testAddToFavorite(){
        HomePage hp=new HomePage();
        FinancialCenterLocatPage loc =hp.clickOnfindLocation();
        loc.enterZipCode("11103");
        loc.clickOnsearch();
        LoctionPage loc1 = loc.clickOnLocationWanted();
        loc1.clickAddToFavorite();
        Assert.assertTrue(loc1.isFavoriteDisplay(),"");

    }
}
