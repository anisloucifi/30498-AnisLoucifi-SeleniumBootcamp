import base.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.GenerateData;

public class Login extends BasePage {
    @Test
    public void login() {
        HomePage hp = new HomePage();
        String[][] data = excel.readStringArrays("log");
        hp.doSignIn(data[0][0], data[0][1]);
        Assert.assertTrue(hp.usernameButton.isDisplayed(), "");
    }

    @Test
    public void loginUnValidIdentification() {
        HomePage hp = new HomePage();
        hp.doSignIn(GenerateData.email(), GenerateData.password());
        Assert.assertTrue(hp.errorMessage.isDisplayed(), "error Message");
    }


}
