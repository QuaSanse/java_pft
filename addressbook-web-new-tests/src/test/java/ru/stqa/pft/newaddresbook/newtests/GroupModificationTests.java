package ru.stqa.pft.newaddresbook.newtests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.GroupData;

import java.util.Set;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testModificationGroup() {
    Set<GroupData> before = app.group().all();
    GroupData modifieddGroup = before.iterator().next();
    int index = before.size() - 1;
    GroupData group = new GroupData()
            .withId(modifieddGroup.getId())
            .withName("test1")
            .withHeader("groupheader")
            .withFooter("groupfooter");
    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifieddGroup);
    before.add(group);
    Assert.assertEquals(before, after);
  }
}
