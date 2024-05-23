package Test;

import Support.Constant;
import Support.login;
import Utils.DriverFactory;
import Utils.Methods;
import Utils.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Directory {

    WebDriver driver;
    Selenium s;
    Constant c;
    login lg;
    Methods m;

    @BeforeClass
    void tearUp()
    {
        driver= DriverFactory.GetDriver("edge");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        s=new Selenium(driver);
        c=new Constant(driver);
        lg=new login(driver);
        m=new Methods(driver);
    }

    @Test(priority = 1)
    void login_into_website()
    {
        lg.enter_userName_password("Admin","admin123");
        Assert.assertEquals(s.getText(c.dashboard_text),"Dashboard");
    }

    @Test(priority = 2)
    void click_on_Directory()
    {
        m.goto_functionality(9);
        Assert.assertEquals(s.getText(c.dashboard_text),"Directory");
    }

    @Test(priority = 3)
    void search_details_of_employee()
    {
        s.sendKeys(c.Employee_name_input,m.firstName(c.dashboard_userName));
        s.click(c.Employee_name_input);
        m.select_suggestions(c.employee_name_suggestions);
        s.click(c.search_employee);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        Assert.assertEquals(s.getText(c.search_emyployee_records),"(1) Record Found");
    }


}
