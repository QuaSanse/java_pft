package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;
import ru.stqa.pft.newaddresbook.newmodel.Contacts;
import ru.stqa.pft.newaddresbook.newmodel.GroupData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validContact() {
    List<Object[]> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resources/stru.png");
    list.add(new Object[] {new ContactData()
            .withFirstname("Firstname")
            .withLastname("lastname")
            .withPhoto(photo)
            .withAddress("address")
            .withGroup("Group")
    });
    list.add(new Object[] {new ContactData()
            .withFirstname("Firstname2")
            .withLastname("lastname2")
            .withPhoto(photo)
            .withAddress("address2")
            .withGroup("Group")
    });
    return list.iterator();
  }

  @Test(dataProvider = "validContact")
  public void testCreationContact(ContactData contact) throws Exception {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
