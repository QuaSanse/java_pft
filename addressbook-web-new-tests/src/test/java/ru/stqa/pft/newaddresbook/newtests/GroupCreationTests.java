package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testCreationNewGroup() {
    appl.getNavigationHelper().gotoGroupPage();
    appl.getGroupHelper().initGroupCreation();
    appl.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
    appl.getGroupHelper().submitGroupCreation();
    appl.getGroupHelper().returnToGroupPage();
    }
}
