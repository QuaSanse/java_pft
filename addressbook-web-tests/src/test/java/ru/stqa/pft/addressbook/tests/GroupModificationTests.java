package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification () {
    app.getNavigationHelper().gotoCroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification ();
    app.getGroupHelper().fillGroupForm(new GroupData("test2", "hrtest2", "frtest3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    app.Logout();
    }
}
