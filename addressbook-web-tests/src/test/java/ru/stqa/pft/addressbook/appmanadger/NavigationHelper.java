package ru.stqa.pft.addressbook.appmanadger;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoCroupPage() {
    click(By.linkText("groups"));
  }
}
