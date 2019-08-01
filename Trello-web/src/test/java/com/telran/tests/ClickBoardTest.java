package com.telran.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClickBoardTest extends TestBase
{


    @Test

    public void boardCreationTest() throws InterruptedException {

        int beforeCreation = getBoardsCount();
        addOnPlusButtonOnHeader();
        editTable();
        ExitTrello();
        pause(5000);
        int afterCreation = getBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation +1);
    }

    public int getBoardsCount()
    {
        return driver.findElements(By.xpath("")).size()-2;
    }
}
