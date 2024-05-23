package Test;

import Support.Constant;
import Support.login;
import Utils.DriverFactory;
import Utils.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PIM {
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
    void click_on_PIM()
    {
        s.click(c.click_PIM);
        Assert.assertEquals(s.getText(c.Admin_txt),"PIM");
    }

    @Test(priority = 3)
    void add_employee()
    {
        s.click(c.click_add_employee);
        s.sendKeys(c.firstName,"Vishal");
        s.sendKeys(c.LastName,"Tyagi");
        s.sendKeys(c.employeeID,"12321");
        driver.findElement(By.xpath("//form//input")).sendKeys(System.getProperty("user.dir")+c.image_path);
        s.click(c.save_button);
        Assert.assertEquals(s.getText(c.personal_details_text),"Personal Details");
    }

    @Test(priority = 4)
    void enter_personal_details()
    {
        s.sendKeys(c.driver_license_number,"DL98123");
        s.sendKeys(c.license_expiry_date,"2024-09-05");
        s.form_drop_down(c.Nationality,84);
        s.form_drop_down(c.Marital_status,1);
        WebElement dob=driver.findElement(By.xpath("//form/div[3]//div[1]//input"));
        s.sendKeys(dob,"2000-16-05");
        s.click(c.save_details);
        //add attachment
        s.click(driver.findElement(By.xpath("//div[3]/div[1]//button")));
        WebElement file= driver.findElement(By.xpath("//div[3]//form//div[2]/input"));
        file.sendKeys(System.getProperty("user.dir")+c.File_path);
        s.click(c.save_3_details);
        Assert.assertEquals(s.getText(c.record_data),"(1) Record Found");
    }





//    @Test(priority = 5)
//    void user_able_to_open_emergency_contact_page()
//    {
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/a")).click();
//        s.click(c.Emergency_contact);
//        Assert.assertEquals(s.getText(c.assigned_em_contact_text),"Assigned Emergency Contacts");
//    }

    //@Test(priority = 6,dependsOnMethods ="user_able_to_open_emergency_contact_page" )
//    void user_able_to_add_contact()
//    {
//        s.click(c.add_contact_button);
//        s.sendKeys(c.name_Contact_number,"Sunny");
//        s.sendKeys(c.relation_contact_number,"Brother");
//        s.sendKeys(c.emergency_number,"11111111111");
//        s.click(c.save_emergency_contact);
//
//        // I implement a wait till webelemnt is present
//        s.Wait(c.em_contact_record_txt,10);
//
//        Assert.assertEquals(s.getText(c.em_contact_record_txt),"(1) Record Found");
//    }


}














