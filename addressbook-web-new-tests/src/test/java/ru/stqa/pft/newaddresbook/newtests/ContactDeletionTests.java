package ru.stqa.pft.newaddresbook.newtests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testDeletionContact () {
    app.getNavigationHelper().gotoHomePage();

    if (! app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new ContactData(
              "Firstname",
              "lastname",
              "adress",
              "Group"
      ), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContactDeletion(before.size() - 1);
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().modalWindowContact();
    //app.getContactHelper().returnToHomePage();
    app.getContactHelper().returnToHomePageLink();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }
}
