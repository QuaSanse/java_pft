package ru.stqa.pft.newaddresbook;

import org.testng.annotations.Test;

public class CreationNewGroup extends TestBase {

  @Test
  public void testCreationNewGroup() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("group1", "groupheader", "groupfooter"));
    submitGroupCreation();
    returnToGroupPage();
    }

}
