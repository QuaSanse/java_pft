package ru.stqa.pft.newaddresbook.newtests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.GroupData;
import ru.stqa.pft.newaddresbook.newmodel.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Groups before = app.group().all();
    GroupData modifieddGroup = before.iterator().next();
    int index = before.size() - 1;
    GroupData group = new GroupData()
            .withId(modifieddGroup.getId())
            .withName("test1")
            .withHeader("groupheader")
            .withFooter("groupfooter");
    app.group().modify(group);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifieddGroup).withAdded(group)));
  }
}
