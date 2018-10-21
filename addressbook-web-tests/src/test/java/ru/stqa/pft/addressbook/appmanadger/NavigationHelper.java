package ru.stqa.pft.addressbook.appmanadger;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {

  FirefoxDriver wd;

  NavigationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void gotoCroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }
}
