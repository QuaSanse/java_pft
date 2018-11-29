package ru.stqa.pft.newaddresbook.newtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddContactInGroup extends TestBase {
  WebDriver wd;

  @Test
  public void testsAddContactInGroup() {
    @Test
    public void testAddContactInGroup() {
      wd.findElement(By.id("151")).click();
      wd.findElement(By.name("to_group")).click();
      wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::option[1]")).click();
      wd.findElement(By.name("add")).click();
      wd.findElement(By.linkText("group page \"test1\"")).click();
    }
  }
}
