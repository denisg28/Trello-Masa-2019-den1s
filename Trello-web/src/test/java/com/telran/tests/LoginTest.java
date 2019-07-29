package com.telran.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginTest
{

    WebDriver driver;

    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://trello.com/home");

    }

    @Test
    public void loginTest() throws InterruptedException {
        //click on loginbutton
    driver.findElement(By.cssSelector("body > header > nav > div.float-right.buttons > a.btn.btn-sm.btn-link.text-white")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("user")).sendKeys("elena.telran@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("12345.com");
    driver.findElement(By.id("login")).click();
        Thread.sleep(20000);
    }



    @AfterClass
    public void Stop()
    {
        driver.quit();
    }

}
