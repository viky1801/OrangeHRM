package Support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {

    WebDriver driver;
    public login(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//form//button")
    public WebElement login_page;

    @FindBy(xpath = "//form/div[1]//input")
    public WebElement userName;

    @FindBy (xpath = "//form/div[2]//input")
    public WebElement password;

    public void enter_userName_password(String user, String pass)
    {
        userName.clear();
        password.clear();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        userName.sendKeys(user);
        password.sendKeys(pass);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        login_page.click();
    }
}
