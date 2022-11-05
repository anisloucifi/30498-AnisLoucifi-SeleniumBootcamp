package utils;

import base.BasePage;

import java.util.Collections;
import java.util.List;

import static base.BasePage.excel;

public class HelperMethod  extends BasePage {

    public static void sortList(List<String> list){
        Collections.sort(list);

    }

    public static void main(String[] args) {

        test();

    }
    public static   void test(){
        String [][] data=null;
         data =excel.readStringArrays("sheet1");
        // MyAccountPage account = log.doLogin("loucifianis23@outlook.com","1234567");
        //Assert.assertTrue(account.isSingOutLinkDisplay(),"on line");
        System.out.println(data[2][0] + " " + data[2][1]);
    }
}
