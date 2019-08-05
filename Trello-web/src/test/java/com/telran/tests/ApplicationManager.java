package com.telran.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

public class ApplicationManager
{


    protected WebDriver driver;
    protected StringBuffer verificationErrors = new StringBuffer();
    private String baseUrl;
    private boolean acceptNextAlert = true;

    protected void init() throws InterruptedException {
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

    //Enter login, password.
    public void fillUserForm(String email, String password) {
        driver.findElement(By.id("user")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void clickOnLoginbutton() {
        click(By.cssSelector("[href='/login']"));
    }

    //Add Table
    public void addOnPlusButtonOnHeader() throws InterruptedException
    {
        click(By.cssSelector("[name=add]"));
        click(By.cssSelector("[data-test-id=header-create-board-button]"));  //  *//[@data-test-id=header-create-board-button]
        sendKeys(By.xpath("//*[@placeholder='Добавить заголовок доски']"), "DenisTable111");
        Thread.sleep(5000);
        click(By.cssSelector("[name=down]"));
        click(By.xpath("//*[contains(text(), 'Без команды')]"));


        click(By.cssSelector("[data-test-id=header-create-board-submit-button]"));

    }

    //Edit Table
    public void editTable()  throws InterruptedException
    {
        Thread.sleep(3000);
        sendKeys(By.cssSelector("[name=name]"), "Table");
        Thread.sleep(3000);
        click(By.cssSelector("input[type='submit']"));
    }

    //Exit Account
    public void ExitTrello() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        click(By.cssSelector("[name=house]"));
        Thread.sleep(2000);
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
        stop();
    }

    /////////LOG OUT FROM ACCOUNT/////////////
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

    protected void stop() {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
      try {
        driver.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    private boolean isAlertPresent() {
      try {
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    private String closeAlertAndGetItsText() {
      try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
          alert.accept();
        } else {
          alert.dismiss();
        }
        return alertText;
      } finally {
        acceptNextAlert = true;
      }
    }

    ////////////COUNT NUMBER OF TEAMS//////////////
    public int getTeamsCount()
    {
      WebElement teamList = driver.findElement(By.cssSelector("nav.home-left-sidebar-container .js-react-root"));
      return teamList.findElements(By.xpath(".//li")).size();
    }
}
