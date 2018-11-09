package ru.stqa.pft.newaddresbook.newtests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereContactMod()) {
      app.getContactHelper().createContact(new ContactData(
              "Firstname",
              "lastname",
              "adress",
              "Group"
      ), true);
    }
  }

  @Test
  public void testDeletionContact () {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContactDeletion(before.size() - 1);
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().modalWindowContact();
    //app.getContactHelper().returnToHomePage();
    app.getContactHelper().returnToHomePageLink();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
