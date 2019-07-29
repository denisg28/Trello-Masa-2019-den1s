package com.telran.tests;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ClickBoardTest extends TestBase
{

    @Test

    public void boardCreationTest() throws InterruptedException {
        clickOnLoginbutton();  //Ctrl+alt+m
        pause(2000);
        fillUserForm("elena.telran@yahoo.com", "12345.com");   //Ctrl+Alt+p
        confirmLoginButton();
        pause(20000);

        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        fillBoardCreationForm();
        confirmBoardCreation();
        clickOnHomeButtonOnHeader();



    }

    private void selectCreateBoardFromDropDown()
    {

    }

    private void clickOnPlusButtonOnHeader()
    {
    click(By.cssSelector(""));
    }

}
