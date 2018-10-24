package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testModificationGroup() {
    appl.getNavigationHelper().gotoGroupPage();
    appl.getGroupHelper().selectGroup();
    appl.getGroupHelper().initModificationGroup();
    appl.getGroupHelper().fillGroupForm(new GroupData("group1", "groupheader", "groupfooter"));
    appl.getGroupHelper().submitModificationGroup();
    appl.getGroupHelper().returnToGroupPage();
  }
}
