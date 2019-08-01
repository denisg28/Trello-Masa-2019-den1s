package com.telran.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.util.concurrent.TimeUnit;

public abstract class TestBase
{
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://trello.com/home");

        clickOnLoginbutton();  //Ctrl+alt+m
        pause(2000);
        fillUserForm("denisg28g@gmail.com", "denisg28g28g28");   //Ctrl+Alt+p
        confirmLoginButton();
        pause(2000);



    }

    public void pause(int sec) throws InterruptedException {
        Thread.sleep(sec);
    }

    public void confirmLoginButton() {
        click(By.id("login"));
    }

    //Locators for click and sendKeys
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    private void sendKeys(By locator, String text) { driver.findElement(locator).sendKeys(text); }
    ////////////

    //Enter login, password.
    public void fillUserForm(String email, String password) {
        driver.findElement(By.id("user")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void clickOnLoginbutton() {
        click(By.cssSelector("[href='/login']"));
    }
    ////////////

    //Add Table
    public void addOnPlusButtonOnHeader() throws InterruptedException
    {
        click(By.cssSelector("[name=add]"));
        click(By.cssSelector("[data-test-id=header-create-board-button]"));  //  *//[@data-test-id=header-create-board-button]
        sendKeys(By.xpath("//*[@placeholder='Добавить заголовок доски']"), "DenisTable");
        Thread.sleep(5000);
        click(By.cssSelector("[data-test-id=header-create-board-submit-button]"));

    }
    ////////////

    //Edit Table
    public void editTable()  throws InterruptedException
    {
        Thread.sleep(3000);
        sendKeys(By.cssSelector("[name=name]"), "Table");
        Thread.sleep(3000);
        click(By.cssSelector("input[type='submit']"));
    }
    ////////////

    //Exit Account
    public void ExitTrello() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        click(By.cssSelector("[name=house]"));
        Thread.sleep(2000);
        click(By.cssSelector("[data-test-id=header-member-menu-button]"));
        Thread.sleep(2000);
        click(By.cssSelector("[data-test-id=header-member-menu-logout]"));
    }
    ////////////
    @AfterClass
    public void Stop()
    {
        //driver.quit();
    }


    public void logout()
    {
        clickOnAvatar();
        clickLogOut();
    }

    public void clickLogOut()
    {
    click(By.xpath("//*[@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar()
    {
        click(By.cssSelector(".js-open-header-member-menu"));
    }
}
