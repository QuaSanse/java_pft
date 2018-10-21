package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoCroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deletSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    app.Logout();
  }

}
