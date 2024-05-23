package Test;

import Support.Constant;
import Support.login;
import Utils.DriverFactory;
import Utils.Selenium;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_testcases {

    Selenium s;
    Constant c;
    login l;
    WebDriver driver;

    @BeforeClass
    void tearUP()
    {
        driver=DriverFactory.GetDriver("firefox");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        s=new Selenium(driver);
        c=new Constant(driver);
        l=new login(driver);
    }

    void wait(int t)  {
        try {
            Thread.sleep(1000*t);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(enabled = false)
    void verify_user_on_login_Page()
    {
        Assert.assertEquals(s.getText(c.save_details),"Login");
    }

    @Test(priority = 1)
    void verify_login_without_username_password()
    {
        l.enter_userName_password("1","1");
        Assert.assertEquals(s.getText(c.Invalid_Credentials),"Invalid credentials");
        wait(2);
    }

    @Test(priority = 2)
    void verify_login_with_invalid_password()
    {
        l.enter_userName_password("Admin","Admin12");
        Assert.assertEquals(s.getText(c.Invalid_Credentials),"Invalid credentials");
        wait(2);
    }


    @Test(priority = 3)
    void verify_login_with_invalid_username_and_password()
    {
        l.enter_userName_password("admin","Admin123");
        Assert.assertEquals(s.getText(c.Invalid_Credentials),"Invalid credentials");
        wait(2);
    }


    @Test(priority = 4)
    void verify_login_with_invalid_username()
    {
        l.enter_userName_password("admin","admin123");
        Assert.assertEquals(s.getText(c.Invalid_Credentials),"Invalid credentials");
        wait(3);
    }


    @AfterTest
    void tearDown()
    {
        //driver.quit();
    }


}
