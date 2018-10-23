package ru.stqa.pft.newaddresbook.newappmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {

    super(wd);
  }
  public void login(String login, String password) {
    type(By.name("user"), login);
    type(By.name("pass"), password);
    click(By.xpath("//input[@value='Login']"));
  }

  public void Logout() {
    wd.findElement(By.linkText("Logout")).click();
  }
}
