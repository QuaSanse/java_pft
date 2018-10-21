package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {

    app.gotoCroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test2", "hrtest2", "frtest3"));
    app.submitGroupCreation();
    app.returnToGroupPage();
    app.Logout();
  }

}
