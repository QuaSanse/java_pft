package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;
import ru.stqa.pft.newaddresbook.newmodel.Contacts;
import ru.stqa.pft.newaddresbook.newmodel.GroupData;
import ru.stqa.pft.newaddresbook.newmodel.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeletionContactFromGroup extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    //Добавляем группу
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    //Добавляем контакт без группы
    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData()
                      .withFirstname("Firstname")
                      .withLastname("lastname")
                      .withAddress("adress")
              //.withGroup("Group")
              , true);
    }
  }

  @Test
  public void testDeletionContactFromGroup() {
    //Выбираем все группы и контакты
    Groups group = app.db().groups();
    Contacts before = app.db().contacts();

    GroupData deletedGroup = group.iterator().next();
    ContactData selectContact = before.iterator().next();

    app.goTo().contactPage();
    app.contact().deleteContactFromGroup(selectContact.getId(), deletedGroup.getId());

    Groups after = app.db().contacts().iterator().next().getGroups();
    assertThat(after, equalTo(before.without(selectContact)));

  }
}

