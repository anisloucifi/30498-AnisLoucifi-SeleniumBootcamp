package data_Provider;

import base.BasePage;
import org.testng.annotations.DataProvider;

import javax.xml.transform.Result;

public class Data_Provider extends BasePage {
    @DataProvider (name = "test authentification")
    public Object[][] getIdentification(){
        return  excel.readStringArrays("log");

    }
}
