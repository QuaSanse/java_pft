package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;
import ru.stqa.pft.newaddresbook.newmodel.Contacts;
import ru.stqa.pft.newaddresbook.newmodel.GroupData;
import ru.stqa.pft.newaddresbook.newmodel.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddContactInGroup extends TestBase {
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
  public void testAddContactInGroup() {
    //Выбираем все группы и контакты
    Groups allGroups = app.db().groups();
    Contacts allContacts = app.db().contacts();
    //Строим множества контактов
    ContactData contactForAdd = findAnyContact(allContacts);
    //
    Groups beforeAddContactToGroup = contactForAdd.getGroups();
    //Проверяем группы для контакта
    checkCreateGroup(allGroups, contactForAdd);
    //Выбираем пару, контакт + группу
     GroupData emptyGroup = findGroupForContact(contactForAdd);

    app.goTo().contactPage();
    app.contact().addContactToGroup(contactForAdd.getId(), emptyGroup.getId());

    Contacts allContactsAfeterAdd = app.db().contacts();
    ContactData updatedContact = findUpdatedContact(allContactsAfeterAdd, contactForAdd.inGroup(emptyGroup));
    Groups afterAddContactToGroup = updatedContact.getGroups();


    assertThat(afterAddContactToGroup.without(emptyGroup), equalTo(beforeAddContactToGroup));
  }

  private ContactData findUpdatedContact(Contacts allContacts, ContactData contactForAdd) {
    ContactData updatedContact = null;
    for (ContactData contact : allContacts) {
      updatedContact = null;
      if (contact.equals(contactForAdd)) {
        updatedContact = contact;
      }
    }
    return updatedContact;
  }

  private GroupData findGroupForContact(ContactData contactForAdd) {
    Groups groups = app.db().groups();
    GroupData emptyGroup = null;
    for (GroupData group : groups) {
      if (!group.getContacts().contains(contactForAdd)) {
        emptyGroup = group;
      }
    }
    return emptyGroup;
  }

  private void checkCreateGroup(Groups allGroups, ContactData contactForAdd) {
    if (contactForAdd.getGroups().size() == allGroups.size()) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Test1"));
    }
  }

  private ContactData findAnyContact(Set allContacts) {
    ContactData contact = (ContactData) allContacts.iterator().next();
    return contact;
  }


}
