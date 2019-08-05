package com.telran.tests;


import javafx.application.Application;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public abstract class TestBase extends ApplicationManager
{

    @BeforeClass
    public void setUp() throws InterruptedException
    {
        init();


    }

    ////////////

    ////////////

    ////////////

    ////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////////


    public void tearDown() throws Exception {
        stop();
        String verificationErrorString = verificationErrors.toString();
      if (!"".equals(verificationErrorString)) {
        fail(verificationErrorString);
      }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
}
