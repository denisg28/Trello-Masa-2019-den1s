package com.telran.tests;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginTest extends TestBase
{

    @Test
    public void loginTest() throws InterruptedException {
        //click on loginbutton
        clickOnLoginbutton();  //Ctrl+alt+m
        pause(2000);
        fillUserForm("elena.telran@yahoo.com", "12345.com");   //Ctrl+Alt+p
        confirmLoginButton();
        pause(20000);
        return;

    }


}
