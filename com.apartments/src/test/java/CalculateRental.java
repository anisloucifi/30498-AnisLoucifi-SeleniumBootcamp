

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class CalculateRental extends BasePage {
    @Test
    public void testCalculate(){
        HomePage hp = new HomePage();
       RentalCalculatorPage rental= hp.navigatetoRentalCalculate();
       rental.enterMonthlyIncome("4000");
       Assert.assertEquals(rental.getResult(),rental.getValueBaseOnRate(4000,30));

    }
    @Test
    public void testCalculate50percent(){

    }
}

