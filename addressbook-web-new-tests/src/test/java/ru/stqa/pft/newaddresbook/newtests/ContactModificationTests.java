package ru.stqa.pft.newaddresbook.newtests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

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
    app.getContactHelper().fillContactForm(new ContactData(
                    "Firstname",
                    "lastname",
                    "adress",
                    "Group"
            ),
            false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}
