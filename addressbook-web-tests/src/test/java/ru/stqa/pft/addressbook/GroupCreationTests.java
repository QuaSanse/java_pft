package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {

    gotoCroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test2", "hrtest2", "frtest3"));
    submitGroupCreation();
    returnToGroupPage();
    Logout();
  }

}
