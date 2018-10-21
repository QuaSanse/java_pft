package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.gotoCroupPage();
    app.selectGroup();
    app.deletSelectedGroups();
    app.returnToGroupPage();
    app.Logout();
  }

}
