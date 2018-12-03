package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;
import ru.stqa.pft.newaddresbook.newmodel.Contacts;
import ru.stqa.pft.newaddresbook.newmodel.GroupData;
import ru.stqa.pft.newaddresbook.newmodel.Groups;

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
    //Выбираем все группы
    Groups groups = app.db().groups();
    GroupData group = groups.iterator().next();
    //Выбираем все контакты
    Contacts contacts = app.db().contacts();
    ContactData contact = contacts.iterator().next();

    app.goTo().contactPage();
    app.contact().deleteContactFromGroup(contact.getId(), group.getId());
  }
}

