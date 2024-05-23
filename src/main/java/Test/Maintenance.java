package Test;

import Support.Constant;
import Support.login;
import Utils.DriverFactory;
import Utils.Methods;
import Utils.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Maintenance {
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
        m.goto_functionality(10);
        //Assert.assertEquals(s.getText(c.dashboard_text),"Maintenance");
    }

    @Test(priority = 3)
    void credentials_for_maintenance()
    {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/form/div[3]/div/div[2]/input")).sendKeys("admin123");
        s.click(c.confirm_password);
    }

    @Test(priority = 4)
    void user_able_to_Access_Records()
    {
        s.Wait(driver.findElement(By.xpath("//div[1]/h6")),10);
        s.click(driver.findElement(By.xpath("//nav/ul/li[2]")));
        Assert.assertEquals(s.getText(c.dashboard_text),"Maintenance");
    }

    @Test(priority = 5)
    void download_personal_data()
    {
        s.sendKeys(c.Employee_name_input,m.firstName(c.dashboard_userName));
        s.click(c.Employee_name_input);
        //m.select_suggestions(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div/div[2]/div[1]")));
    }
}
