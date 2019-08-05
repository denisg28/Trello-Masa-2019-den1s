package com.telran.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClickBoardTest extends TestBase
{


    @Test

    public void boardCreationTest() throws InterruptedException {

        int beforeCreation = getBoardsCount();
        int afterCreation = getBoardsCount();
        app.addOnPlusButtonOnHeader();
        app.editTable();
        app.ExitTrello();
        app.pause(5000);


        Assert.assertEquals(afterCreation, beforeCreation +1);
    }

    public int getBoardsCount()
    {
        return app.driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-2;
    }
}
