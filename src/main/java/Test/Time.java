package Test;

import Support.Attendace;
import Support.Constant;
import Support.login;
import Support.time;
import Utils.DriverFactory;
import Utils.Methods;
import Utils.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Time {

    Selenium s;
    Constant c;
    login l;
    time t;
    Attendace a;
    Methods m;
    WebDriver driver;

    @BeforeClass
    void tearUP()
    {
        driver= DriverFactory.GetDriver("edge");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        s=new Selenium(driver);
        c=new Constant(driver);
        l=new login(driver);
        t=new time(driver);
        a=new Attendace(driver);
        m=new Methods(driver);
    }



    @Test(priority = 1)
    void login_into_website()
    {
        l.enter_userName_password("Admin","admin123");
        Assert.assertEquals(s.getText(c.dashboard_text),"Dashboard");
    }



    @Test(priority = 2)
    void go_in_time_menu()
    {
        s.click(c.time);
        Assert.assertEquals(s.getText(c.time_dashboard),"Time","First title is not matching");
    }

    @Test(priority = 3)
    void fill_timeSheet()
    {
        s.click(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]")));
        s.click(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li[1]/a")));
        s.click(driver.findElement(By.xpath("//form/div[3]/div[2]/button[1]")));
        t.fill_timesheet();
        s.click(driver.findElement(By.xpath("//form/div[3]//button[3]")));
        m.Hard_wait(7);
        WebElement e=driver.findElement(By.xpath("//tbody/tr[2]/td[10]"));
        Assert.assertEquals(s.getText(e),"48:00");
    }

    @Test(priority = 4,dependsOnMethods = "go_in_time_menu")
    void verify_all_drop_menus()
    {
        Assert.assertTrue(t.all_list_enable());
    }



    @Test(priority = 4)
    void verify_header_of_Attendance()
    {
        s.click(c.Attendance);
        s.click(c.Attend_myRecords);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(s.getText(c.time_dashboard),"Time","It is show wrong data : "+s.getText(c.time_dashboard));
        //Assert.assertEquals(s.getText(c.time_dashboard),"Attendance");
    }


    @Test(priority = 5)
    void verify_dropdown_of_attendace()
    {
        s.click(c.Attendance);
        s.click(c.Attend_PunchIn_PunchOut);
        if(s.getText(a.punch_in_text)=="Punch In")
            verify_user_able_to_punchIn();
        else
            verify_user_able_to_punchout();

    }

    void verify_user_able_to_punchIn()
    {
        a.punchIn("2024-07-06","12:21 AM");
        Assert.assertEquals(s.getText(a.punch_in_text),"Punch Out");
    }

    void verify_user_able_to_punchout()
    {
        a.punchIn("2024-07-06","12:21 AM");
        Assert.assertEquals(s.getText(a.punch_in_text),"Punch In");
    }



    @AfterClass
    void teardown()
    {
        //driver.quit();
    }
}
