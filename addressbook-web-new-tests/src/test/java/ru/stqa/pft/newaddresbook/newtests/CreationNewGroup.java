package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.GroupData;

public class CreationNewGroup extends TestBase {

  @Test
  public void testCreationNewGroup() throws Exception {
    appl.gotoGroupPage();
    appl.initGroupCreation();
    appl.fillGroupForm(new GroupData("group1", "groupheader", "groupfooter"));
    appl.submitGroupCreation();
    appl.returnToGroupPage();
    }

}
