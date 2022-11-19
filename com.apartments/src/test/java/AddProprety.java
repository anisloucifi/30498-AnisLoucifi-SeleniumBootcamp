import base.BasePage;
import org.testng.annotations.Test;
import utils.GenerateData;

public class AddProprety extends BasePage {
    @Test
    public void testaddproprety() {
        HomePage hp = new HomePage();
        String[][] data = excel.readStringArrays("log");
        hp.doSignIn(data[0][0],data[0][1]);
        AddPropertyPage prop = hp.clickOnAddProperty();
        prop.doAddProprety(GenerateData.streetAddress());
    }
}
