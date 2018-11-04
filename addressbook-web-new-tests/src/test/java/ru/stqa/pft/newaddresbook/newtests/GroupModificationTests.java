package ru.stqa.pft.newaddresbook.newtests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testModificationGroup() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectGroup(before - 1);
    app.getGroupHelper().initModificationGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("test", "groupheader", "groupfooter"));
    app.getGroupHelper().submitModificationGroup();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
