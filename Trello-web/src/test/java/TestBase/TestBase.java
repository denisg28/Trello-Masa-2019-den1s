package TestBase;

import com.telran.tests.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public abstract class TestBase
{
    WebDriver driver;

    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://trello.com/home");

    }

    protected void pause(int sec) throws InterruptedException {
        Thread.sleep(sec);
    }

    protected void confirmLoginButton() {
        click(By.id("login"));
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void fillUserForm(String email, String password) {
        driver.findElement(By.id("user")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    protected void clickOnLoginbutton() {
        click(By.cssSelector("body > header > nav > div.float-right.buttons > a.btn.btn-sm.btn-link.text-white"));
    }

    @AfterClass
    public void Stop()
    {
        driver.quit();
    }


}
