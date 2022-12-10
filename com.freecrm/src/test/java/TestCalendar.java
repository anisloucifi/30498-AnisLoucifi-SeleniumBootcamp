import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalendar extends BasePage {
    @Test
    public void testCalendarDisplay(){
        HomePage homePage =new HomePage();
        LoginPage log = homePage.clickOnLogin();
        AccountPage accountPage = log.doLogin("khalilPNT@gmail.com","PNTclass123!");
        CalendarPage calendarPage = accountPage.clickOnCalendar();
        Assert.assertTrue(calendarPage.isTableDisplay(),"");
    }
@Test
    public void testAddCalendar(){
    HomePage homePage =new HomePage();
    LoginPage log = homePage.clickOnLogin();
    AccountPage accountPage = log.doLogin("khalilPNT@gmail.com","PNTclass123!");
    CalendarPage calendarPage = accountPage.clickOnCalendar();
    calendarPage.addCalendar("Event");
    Assert.assertTrue(calendarPage.getListCalendar().contains("Event"));
}
@Test
    public void testDeletCalendar(){
    HomePage homePage =new HomePage();
    LoginPage log = homePage.clickOnLogin();
    AccountPage accountPage = log.doLogin("khalilPNT@gmail.com","PNTclass123!");
    CalendarPage calendarPage = accountPage.clickOnCalendar();
    calendarPage.doDeletCalendar("Event");
    Assert.assertFalse(calendarPage.getListCalendar().contains("Event"));
}
@Test
    public void testEditCalendar(){
    HomePage homePage =new HomePage();
    LoginPage log = homePage.clickOnLogin();
    AccountPage accountPage = log.doLogin("khalilPNT@gmail.com","PNTclass123!");
    CalendarPage calendarPage = accountPage.clickOnCalendar();
    calendarPage.editCalendar("Event","new");
    Assert.assertEquals("Event","newEvent");
}

}
