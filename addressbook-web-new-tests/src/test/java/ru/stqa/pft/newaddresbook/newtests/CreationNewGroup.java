package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.GroupData;

public class CreationNewGroup extends TestBase {

  @Test
  public void testCreationNewGroup() throws Exception {
    appl.getNavigationHelper().gotoGroupPage();
    appl.getGroupHelper().initGroupCreation();
    appl.getGroupHelper().fillGroupForm(new GroupData("group1", "groupheader", "groupfooter"));
    appl.getGroupHelper().submitGroupCreation();
    appl.getGroupHelper().returnToGroupPage();
    }

}
