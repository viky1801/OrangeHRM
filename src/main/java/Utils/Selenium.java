package Utils;

import Support.Constant;
import Test.Leave;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.c;

public class Selenium {

    WebDriver driver;
    Constant c;
    public Selenium(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        c=new Constant(driver);
    }

    public void click(WebElement e)
    {
        e.click();
    }

    public String getText(WebElement e)
    {
        return e.getText();
    }

    public void sendKeys(WebElement e, String s)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        e.clear();
        e.sendKeys(s);
    }

    public void scroll_down()
    {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }

    public void Dropdowm(WebElement e,String option)
    {
        String script = "arguments[0].setAttribute('value', 'New text')";
        //((JavascriptExecutor) driver).executeScript(script, textField);
    }

    public String getURL()
    {
        return driver.getCurrentUrl();
    }

    public void form_drop_down(String path,int i)
    {
        i++;
        driver.findElement(By.xpath(path)).click();
        driver.findElement((By.xpath(path+"/div[2]/div["+i+"]"))).click();
    }

    public void Upper_dropMenu(int i,int j)
    {
        driver.findElement(By.xpath("//nav/ul/li["+i+"]")).click();
        driver.findElement(By.xpath("//nav/ul/li[2]/ul/li["+j+"]")).click();

    }

    public void uploadFile()
    {
        String s="\"C:\\Users\\vtyagi\\Documents\\New Text Document.txt\"";
        WebElement addFile = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[1]"));
        //addFile.click();
        addFile.sendKeys(s);
        // driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[1]")).sendKeys(s);
    }

    public boolean Wait(WebElement e, int t)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(t));
        wait.until(ExpectedConditions.visibilityOf(e));
        if(!e.isDisplayed())
            Wait(e,t);
        else
            return true;

        return false;
    }


    public boolean list_records()
    {

        if(getText(c.Leave_list).equalsIgnoreCase("No Records Found"))
        {
            return true;
        }
        else
        {
            WebElement list= driver.findElement(By.xpath("//*[@class=\"oxd-table-card\"]"));
            List<WebElement> recordList=list.findElements(By.tagName("input"));
            String str=getText(c.Leave_list);
            int num=str.charAt(1)-'0';
            if(num==recordList.size())
                return true;
            else
                return false;
        }
    }
}
