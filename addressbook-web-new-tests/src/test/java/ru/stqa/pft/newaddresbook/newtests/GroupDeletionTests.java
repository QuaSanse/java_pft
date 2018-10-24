package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    appl.getNavigationHelper().gotoGroupPage();
    appl.getGroupHelper().selectGroup();
    appl.getGroupHelper().deletSelectedGroups();
    appl.getGroupHelper().returnToGroupPage();
  }
}
