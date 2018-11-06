package ru.stqa.pft.newaddresbook.newtests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();

    if (! app.getContactHelper().isThereContactMod()) {
      app.getContactHelper().createContact(new ContactData(
              "Firstname",
              "lastname",
              "adress",
              "Group"
      ), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContactModification(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),
            "Firstname",
            "lastname",
            "adress",
            "Group"
    );
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
