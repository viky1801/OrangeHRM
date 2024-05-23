package Support;

import Utils.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class time {

    WebDriver driver;
    Selenium s;
    public time(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean all_list_enable()
    {
        for(int i=1;i<4;i++)
        {
            if(!driver.findElement(By.xpath("//header//nav//li["+i+"]/span")).isEnabled())
                return false;
        }
        return true;
    }

    public void fill_timesheet()
    {
        WebElement time_filled=driver.findElement(By.xpath("//td[3]//input"));

            WebElement delete_timeSheet=driver.findElement(By.xpath("//td[10]/button"));
            delete_timeSheet.click();


        WebElement e1=driver.findElement(By.xpath("//td[1]//input"));
        e1.clear();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        e1.sendKeys("T");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//tbody/tr[1]/td[1]//div[2]//div[2]/div[1]")).click();
        driver.findElement(By.xpath("//tbody/tr[1]/td[2]//div[2]//div[2]/i")).click();
        driver.findElement(By.xpath("//tbody/tr[1]/td[2]//div[2]//div[2]/div[2]")).click();
        for(int i=3;i<=8;i++)
        {
            WebElement e= driver.findElement(By.xpath("//td["+i+"]//input"));
            e.clear();
            e.sendKeys("8");
        }
    }
}
