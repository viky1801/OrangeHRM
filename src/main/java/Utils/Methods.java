package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Methods {
    WebDriver driver;Selenium s;
    public Methods(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        s=new Selenium(driver);
    }

    public void goto_functionality(int n)
    {
        driver.findElement(By.xpath("//aside/nav//li["+n+"]")).click();
    }

    public void select_suggestions(WebElement e)
    {
        s.Wait(e,10);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        e.click();
    }

    public String firstName(WebElement element)
    {
        String s=element.getText();
        String[] words=s.split("\\s+");
        return words[0];
    }

    public void Hard_wait(int t)
    {
        try {
            Thread.sleep(t*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void enterNames(String first,String second,String third)
    {
        String[] names={first,second,third};
        for(int i=1;i<4;i++)
        {
            WebElement e= driver.findElement(By.xpath("//div[2]/div["+i+"]/div[2]/input"));
            e.sendKeys(names[i-1]);
        }
    }
    public void select_suggestion(String path, String s, int number)
    {
        driver.findElement(By.xpath(path+"//input")).sendKeys(s);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath(path+"/div[2]/div["+number+"]")).click();
    }

    void schedule_interview()
    {
        String[] data={"Automation Testing"};
        for(int i=1;i<4;i++)
        {
            WebElement e=driver.findElement(By.xpath("//form/div[2]/div/div["+i+"]//input"));

        }
    }
}
