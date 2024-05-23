package Test;

import Support.Constant;
import Support.login;
import Utils.DriverFactory;
import Utils.Selenium;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Punch_IN {


        Selenium s;
        Constant c;
        login l;
        WebDriver driver;

        @BeforeClass
        void tearUP()
        {
            driver= DriverFactory.GetDriver("firefox");
            driver.get("https://opensource-demo.orangehrmlive.com/");
            s=new Selenium(driver);
            c=new Constant(driver);
            l=new login(driver);
        }

        @Test(priority = 1)
        void login_into_website()
        {
            l.enter_userName_password("Admin","admin123");
            Assert.assertEquals(s.getText(c.dashboard_text),"Dashboard");
        }

        @Test(priority = 2)
        void start_punchIN()
        {
            s.click(c.start_time);
            Assert.assertEquals(s.getText(c.punchIN_OUT),"In","User is already punch_IN");
        }

        @Test(dependsOnMethods ="start_punchIN" )
        void enter_time_and_punchIn()
        {
            s.sendKeys(c.set_time,"02:02 PM");
            s.click(c.punchIN_OUT);
            Assert.assertTrue(c.punchIN_OUT.isDisplayed());

        }

        @Test(dependsOnMethods = "enter_time_and_punchIn")
        void punch_out()
        {
            s.click(c.punchIN_OUT);
        }


        @AfterClass
        void teardown()
        {
            //driver.quit();
        }

    }
