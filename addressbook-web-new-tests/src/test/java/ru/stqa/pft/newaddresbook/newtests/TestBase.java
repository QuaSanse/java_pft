package ru.stqa.pft.newaddresbook.newtests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.newaddresbook.newappmanager.ApplicationManager;

public class TestBase {

  protected final ApplicationManager appl = new ApplicationManager(BrowserType.FIREFOX);

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    appl.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    appl.stop();
  }
}
