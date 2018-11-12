package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;
import ru.stqa.pft.newaddresbook.newmodel.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreationContact() throws Exception {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("Firstname")
            .withLastname("lastname")
            .withAdress("adress")
            .withGroup("Group")
    ;
    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
