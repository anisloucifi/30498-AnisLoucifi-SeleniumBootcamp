import base.BasePage;
import org.testng.annotations.Test;

public class Login extends BasePage {
    @Test
    public void login() {
        HomePage hp = new HomePage();
        String[][] data = excel.readStringArrays("log");
        hp.doSignIn(data[0][0],data[0][1]);



    }
}
