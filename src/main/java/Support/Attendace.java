package Support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Attendace {
    WebDriver driver;
    public Attendace(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div/h6")
    public WebElement punch_in_text;

   public boolean dropList()
    {
        for(int i=1;i<=4;i++)
        {
            boolean e= driver.findElement(By.xpath("//ul/li[2]//li["+i+"])")).isEnabled();
            if(!e)
                return false;
        }
        return true;
    }
    public void punchIn(String date,String time)
    {
        timeout(5);
        WebElement date1=driver.findElement(By.xpath("//form/div/div/div[1]//input"));
        timeout(2);
        WebElement time1=driver.findElement(By.xpath("//form/div/div/div[2]//input"));
        time1.clear();
        timeout(2);
        time1.sendKeys(time);
        timeout(2);
       // date1.sendKeys(date);
        driver.findElement(By.xpath("//form/div[3]/button")).click();

    }

    void timeout(int t)
    {
        try {
            Thread.sleep(t*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
