package com.telran.tests;

import org.openqa.selenium.By;
import org.testng.Assert;


   //////////////////////////TEST TEAM TRELLO.COM///////////////////////
public class Test extends TestBase{

  @org.testng.annotations.Test


  public void test() throws Exception {

    int before=getTeamsCount();
    System.out.println(before + ":");
    driver.get("https://trello.com/denisa309/boards");

   driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='команды'])[1]/following::span[5]")).click();
   driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Участники'])[1]/following::span[5]")).click();
   driver.findElement(By.xpath("//span[@class='icon-gear icon-sm OiX3P2i2J92Xat']")).click();
   driver.findElement(By.xpath("//span[text()='Удалить команду']")).click();
   driver.findElement(By.cssSelector(".js-confirm")).click();
    driver.findElement(By.xpath("//*[@class='icon-add icon-sm OiX3P2i2J92Xat']")).click();
    driver.findElement(By.xpath("//input[@class='_1CLyNodCAa-vQi']")).clear();
    driver.findElement(By.xpath("//input[@class='_1CLyNodCAa-vQi']")).sendKeys("Den");
    driver.findElement(By.xpath("//textarea[@class='_15aIJYNKhrO4vB']")).click();
    driver.findElement(By.xpath("//textarea[@class='_15aIJYNKhrO4vB']")).clear();
    driver.findElement(By.xpath("//textarea[@class='_15aIJYNKhrO4vB']")).sendKeys("123");
    driver.findElement(By.xpath("//button[@data-test-id='header-create-team-submit-button']")).click();
    driver.get("https://trello.com/denisa309/boards");
    Thread.sleep(5000);
    int after=getTeamsCount();

    System.out.println(after);
    Assert.assertEquals(after, before +1);

  }






  //  public int getTeamsCount2()
//  {
//    return driver.findElements(By.cssSelector("nav.home-left-sidebar-container .js-react-root li")).size();
//  }

}
