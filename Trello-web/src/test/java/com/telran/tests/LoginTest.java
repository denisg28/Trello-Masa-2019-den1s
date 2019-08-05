package com.telran.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase
{
    @BeforeMethod
    public void preconditions()
    {
        app.logout();
    }

    @Test
    public void loginTest() throws InterruptedException {
        //click on loginbutton
        String currentUrl = app.driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://trello.com/logged-out");


        app.clickOnLoginbutton();  //Ctrl+alt+m
        app.pause(2000);
        app.fillUserForm("denisg28g@gmail.com", "denisg28g28g28");   //Ctrl+Alt+p
        app.confirmLoginButton();
        app.pause(2000);
//        clickOnPlusButtonOnHeader();
//        pause(5000);
//        selectCreateBoardFromDropDown();
//        pause(2000);

        Assert.assertTrue(isUserLoggedIn());


        return;

    }


    public boolean isUserLoggedIn()
    {
        return isElementPresent(By.cssSelector(".js-open-header-member-menu"));
    }

    public boolean isElementPresent(By locator)
    {
        return app.driver.findElements(locator).size()>0;
    }
}
