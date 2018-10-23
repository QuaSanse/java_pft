package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.Test;

public class GroupDeletion extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    appl.gotoGroupPage();
    appl.selectGroup();
    appl.deletSelectedGroups();
    appl.returnToGroupPage();
  }
}
