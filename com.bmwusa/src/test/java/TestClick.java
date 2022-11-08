import base.BasePage;
import org.testng.annotations.Test;

public class TestClick extends BasePage {
    @Test
    public void Testclcik()  {
        HomePage hp = new HomePage();
        MapPage map = hp.clickOnlocation();


    }
}
