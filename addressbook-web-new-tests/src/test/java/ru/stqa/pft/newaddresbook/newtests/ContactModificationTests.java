package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;
import ru.stqa.pft.newaddresbook.newmodel.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData()
                      .withFirstname("Firstname")
                      .withLastname("lastname")
                      .withAddress("adress")
                      .withGroup("Group")
              , true);
    }
}

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstname("Firstname")
            .withLastname("lastname")
            .withAddress("adress")
            .withGroup("Group")
    ;
    app.goTo().contactPage();
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUi();
  }
}
