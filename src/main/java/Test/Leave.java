package Test;

import Support.Constant;
import Support.leave;
import Support.login;
import Utils.DriverFactory;
import Utils.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Leave {
    Selenium s;
    Constant c;
    login lg;
    leave l;
    WebDriver driver;

    @BeforeClass
    void tearUP()
    {
        driver= DriverFactory.GetDriver("edge");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        s=new Selenium(driver);
        c=new Constant(driver);
        lg=new login(driver);
        l=new leave(driver);
    }

    @Test(priority = 1)
    void login_into_website()
    {
        lg.enter_userName_password("Admin","admin123");
        //Assert.assertEquals(s.getText(c.dashboard),"Dashboard");
    }


    @Test(priority = 2)
    void verify_user_able_to_click_LEAVE()
    {
        s.click(c.Leave);
        //Assert.assertEquals(s.getText(c.Leave_header),"Leave");
    }

    @Test(priority = 3)
    void verify_user_able_to_reject_leave()
    {
        s.scroll_down();
        //Assert.assertTrue(l.leave_list_records());
    }

    @Test(priority = 4)
    void verify_user_able_to_go_on_apply_leave_page()
    {
        s.click(c.Leave_apply);
        //Assert.assertEquals(s.getText(c.apply_leave_text),"Apply Leave");
    }

    @Test(dependsOnMethods = "verify_user_able_to_go_on_apply_leave_page")
    void user_able_to_apply_leave()
    {
        WebElement t=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/h6"));
        s.Wait(t,5);
        s.click(c.leave_type);
        s.click(c.leave_option);
        WebElement fromDate=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/input"));
        fromDate.sendKeys("2024-22-06");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//form//button")).click();

    }

    @Test(priority = 5,enabled = false)
    void user_able_to_click_MyLeave()
    {
        s.click(c.myLeave);
        Assert.assertEquals(s.getText(c.MyleaveList_text),"My Leave List");
        System.out.println(l.leave_listNumber()+1);
        System.out.println(l.leave_list_records());
    }

    @Test(dependsOnMethods ="user_able_to_click_MyLeave",enabled = false)
    void number_of_leaveRecords()
    {
        Assert.assertTrue(l.leave_list_records());
    }

    @Test(priority = 6,enabled = false)
    void number_of_holiday_in_year()
    {
        l.configure(4);
        s.click(c.search_Holiday);
        System.out.println(l.leave_list_records());
    }




}
