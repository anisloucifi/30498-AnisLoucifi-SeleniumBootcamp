import base.BasePage;
import org.testng.annotations.Test;

public class FlightsSearch extends BasePage {
    @Test
    public void searchFlights() throws InterruptedException {
        HomePage homePage =new HomePage();
        SearchFlightsPage sr = homePage.clickOnFlight();
        sr.doSearch("One-way","new york","20","boston");
    }
}
