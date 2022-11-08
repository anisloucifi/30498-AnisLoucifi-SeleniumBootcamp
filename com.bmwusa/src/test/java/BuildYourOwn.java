import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuildYourOwn extends BasePage {
    @Test
    public void testNavigate(){
        HomePage homePage =new HomePage();
        homePage.clickBuildYourOwnLink();
//        I7SedanPage sedan = build.clickSelect();
//        DesignPage design= sedan.clickCustomizeThisBuild();
//        design.customizeCar();
//        Assert.assertTrue(build.isDisplay(),"");
    }
}
