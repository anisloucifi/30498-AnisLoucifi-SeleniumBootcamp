import base.BasePage;
import org.testng.annotations.Test;

import java.awt.*;

public class Autentification extends BasePage {

    @Test (dataProviderClass = data_Provider.Data_Provider.class, dataProvider = "test authentification")
    public  void testlogin(String email ,String password) throws AWTException {
        HomePage homePage = new HomePage();
        homePage.doSignIn(email,password);

}
    }
