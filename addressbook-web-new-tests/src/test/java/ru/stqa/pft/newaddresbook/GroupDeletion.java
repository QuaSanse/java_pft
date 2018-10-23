package ru.stqa.pft.newaddresbook;

import org.testng.annotations.Test;

public class GroupDeletion extends TastBase {

  @Test
  public void testGroupDeletion() throws Exception {
    gotoGroupPage();
    selectGroup();
    deletSelectedGroups();
    returnToGroupPage();
  }
}
