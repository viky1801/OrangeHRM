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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Recruitment {
    Selenium s;
    Constant c;
    login l;
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
        m=new Methods(driver);
    }



    @Test(priority = 1)
    void login_into_website()
    {
        l.enter_userName_password("Admin","admin123");
        Assert.assertEquals(s.getText(c.dashboard_text),"Dashboard");
    }

    @Test(priority = 2)
    void go_to_recruitment_section()
    {
        m.goto_functionality(5);
        Assert.assertEquals(s.getText(c.dashboard_text),"Recruitment");
    }

    @Test(priority = 3)
    void add_candidate_for_recruitment()
    {
        s.click(c.recruitment_add);
        WebElement e=driver.findElement(By.xpath("//div[2]//h6"));
        Assert.assertEquals(s.getText(e),"Add Candidate");
    }

    @Test(priority = 4)
    void enter_details_to_add_candidate()
    {
        m.enterNames("vi","sh","al");
        s.form_drop_down("//form/div[2]//div[2]/div",3);
        s.sendKeys(c.recruitment_email,"ty@emaple.com");
        s.sendKeys(c.recruitment_phone_number,"1234567");
        c.recruitment_file_input.sendKeys(System.getProperty("user.dir")+c.File_path);
        driver.findElement(By.xpath("//form/div[8]/button[2]")).click();
        Assert.assertEquals(s.getText(driver.findElement(By.xpath("//form/h6"))),"Application Stage");
    }

    @Test(priority = 5,dependsOnMethods = "enter_details_to_add_candidate",enabled = false)
    void shortlist_the_candidate_application()
    {
        s.click(c.recruitment_shortlist);
        Assert.assertEquals(s.getText(c.title_text),"Shortlist Candidate");
    }

    @Test(priority = 5 )
    void Vacancies()
    {
        WebElement e= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a"));
        e.click();
        s.click(c.recruitment_add);
        Assert.assertEquals(s.getText(c.title_text),"Add Vacancy");
    }

    @Test(priority = 6)
    void vacancy_details()
    {
        s.sendKeys(c.recrut_vacancyName,"Automation");
        s.form_drop_down("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div",1);
        m.select_suggestion("//form/div[3]/div[1]/div/div[2]/div","t",1);
        s.sendKeys(c.recrut_No_of_positions,"10");
        s.click(c.save_form_data);
        Assert.assertEquals(s.getText(driver.findElement(By.xpath("//h6[normalize-space()='Edit Vacancy']"))),"Edit Vacancy");
    }

    @Test(priority = 7)
    void add_vacancy_attachment()
    {
        s.click(c.add_user);
        c.vacancy_form2_filepath.sendKeys(System.getProperty("user.dir")+c.File_path);
        s.click(c.save_form2);
        m.Hard_wait(2);
        Assert.assertEquals(s.getText(c.vacancy_attachment_records),"(1) Record Found");
    }

}
