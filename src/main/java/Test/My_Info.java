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

public class My_Info {
    Selenium s;
    Methods m;
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
        m=new Methods(driver);
    }

    @Test(priority = 1)
    void login_into_website()
    {
        lg.enter_userName_password("Admin","admin123");
        Assert.assertEquals(s.getText(c.dashboard_text),"Dashboard");
    }

    @Test(priority = 2)
    void click_on_myINFO()
    {
        m.goto_functionality(6);
        Assert.assertEquals(s.getText(c.dashboard_text),"My Info","In webpage it is mentioned incorrect");
    }

    @Test(priority = 3)
    void verify_user_name()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        Assert.assertEquals(s.getText(c.user_name),s.getText(c.dashboard_userName));
    }

    @Test(priority = 4)
    void change_photo()
    {
        driver.findElement(By.xpath("//div[2]/div[2]//img")).click();
        //WebElement e= driver.findElement(By.xpath("<h6 data-v-7b563373=\"\" data-v-42073826=\"\" class=\"oxd-text oxd-text--h6 orangehrm-main-title\">Change Profile Picture</h6>"));
       // s.Wait(e,10);
       // String imagePath=System.getProperty("user.dir");
        //driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[1]/div/div/div[2]/div/button")).sendKeys(imagePath+"src//button.png");
    }
}
