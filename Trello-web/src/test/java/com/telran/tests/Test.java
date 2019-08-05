package com.telran.tests;

import org.openqa.selenium.By;
import org.testng.Assert;


   //////////////////////////TEST TEAM TRELLO.COM///////////////////////
public class Test extends TestBase{

  @org.testng.annotations.Test


  public void test() throws Exception {

    int before= app.getTeamsCount();
    System.out.println(before + ":");
    app.driver.get("https://trello.com/denisa309/boards");

   app.driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='команды'])[1]/following::span[5]")).click();
   app.driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Участники'])[1]/following::span[5]")).click();
   app.driver.findElement(By.xpath("//span[@class='icon-gear icon-sm OiX3P2i2J92Xat']")).click();
   app.driver.findElement(By.xpath("//span[text()='Удалить команду']")).click();
   app.driver.findElement(By.cssSelector(".js-confirm")).click();
    app.driver.findElement(By.xpath("//*[@class='icon-add icon-sm OiX3P2i2J92Xat']")).click();
    app.driver.findElement(By.xpath("//input[@class='_1CLyNodCAa-vQi']")).clear();
    app.driver.findElement(By.xpath("//input[@class='_1CLyNodCAa-vQi']")).sendKeys("Den");
    app.driver.findElement(By.xpath("//textarea[@class='_15aIJYNKhrO4vB']")).click();
    app.driver.findElement(By.xpath("//textarea[@class='_15aIJYNKhrO4vB']")).clear();
    app.driver.findElement(By.xpath("//textarea[@class='_15aIJYNKhrO4vB']")).sendKeys("123");
    app.driver.findElement(By.xpath("//button[@data-test-id='header-create-team-submit-button']")).click();
    app.driver.get("https://trello.com/denisa309/boards");
    Thread.sleep(5000);
    int after= app.getTeamsCount();

    System.out.println(after);
    Assert.assertEquals(after, before +1);

  }






  //  public int getTeamsCount2()
//  {
//    return driver.findElements(By.cssSelector("nav.home-left-sidebar-container .js-react-root li")).size();
//  }

}
