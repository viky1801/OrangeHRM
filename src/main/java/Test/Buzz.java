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

public class Buzz {
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
    void click_on_Buzz()
    {
        m.goto_functionality(12);
        Assert.assertEquals(s.getText(c.dashboard_text),"Buzz");
    }

    @Test(priority = 3)
    void user_able_to_share_on_Newsfeed()
    {
        driver.findElement(By.xpath("//*[@id=\"Buzz Newsfeed\"]/div/div[1]/div[1]/div[2]/form/div/textarea")).sendKeys("I achieve it");
        driver.findElement(By.xpath("//*[@id=\"Buzz Newsfeed\"]/div/div[1]/div[1]/div[2]/form/div/div/button")).click();
    }
}
