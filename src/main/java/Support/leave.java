package Support;

import Utils.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;


public class leave {

    Constant c;
    Selenium s;

    WebDriver driver;
    public leave(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        c=new Constant(driver);
        s=new Selenium(driver);

    }


    public boolean leave_list_records()
    {

        if(s.getText(c.Leave_list).equalsIgnoreCase("No Records Found"))
        {
            return true;
        }
        else
        {
            WebElement list= driver.findElement(By.xpath("//*[@class=\"oxd-table-card\"]"));
            List<WebElement> recordList=list.findElements(By.tagName("input"));
            String str=s.getText(c.Leave_list);
            int num=str.charAt(1)-'0';
            if(num==recordList.size())
                return true;
            else
                return false;
        }
    }


    public int leave_listNumber()
    {
        WebElement list =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div"));
        List<WebElement> recordNumber=list.findElements(By.tagName("div"));
        return recordNumber.size();
    }



    public void configure(int i)
    {
        driver.findElement(By.xpath("//nav/ul/li[5]")).click();
        driver.findElement(By.xpath("//nav/ul/li[5]/ul/li["+i+"]")).click();

    }

}
