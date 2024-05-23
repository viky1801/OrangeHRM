package Test;

import Support.Constant;
import Support.login;
import Utils.DriverFactory;
import Utils.Selenium;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Admin {
    Selenium s;
    Constant c;
    login lg;
    WebDriver driver;

    @BeforeClass
    void tearUP()
    {
        driver= DriverFactory.GetDriver("edge");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        s=new Selenium(driver);
        c=new Constant(driver);
        lg=new login(driver);

    }

    @Test(priority = 1)
    void login_into_website()
    {
        lg.enter_userName_password("Admin","admin123");
        Assert.assertEquals(s.getText(c.dashboard_text),"Dashboard");
    }

    @Test(priority = 2)
    void verify_user_able_to_click_ADMIN()
    {
        s.click(c.Admin);
        Assert.assertEquals(s.getText(c.Admin_txt),"Admin");
    }

    @Test(priority = 3)
    void add_user()
    {
        s.click(c.add_user);
        s.form_drop_down(c.User_Role,1);
        //s.sendKeys(c.employee_name,"vishal");
        s.form_drop_down(c.status,1);
        Assert.assertEquals(s.getText(c.add_user_text),"Add User");

    }

    @Test(priority = 4)
    void user_able_to_reach_add_JobTitle()
    {
        s.Upper_dropMenu(2,1);
        s.click(c.add_Job_Title);
        Assert.assertEquals(s.getText(c.title_text),"Add Job Title");
    }


    @Test(priority = 5)
    void verify_record()
    {
        Assert.assertTrue(s.list_records());
    }


    @Test(priority = 6)
    void user_able_to_add_job_title()
    {
        s.sendKeys(c.Job_title_input,"Tetng");
        s.sendKeys(c.Job_description,"We are hiring 2+ year experience of selenium automation.");
        //s.uploadFile();
        s.click(c.save_job_data);
    }

    @Test(priority = 7)
    void user_able_to_add_Pay_Grade()
    {
        s.Upper_dropMenu(2,2);
        s.click(c.add_Job_Title);
        s.sendKeys(c.add_pay_grade_input,"Grade 7");
        s.click(c.save_pay_grade);
    }




}
