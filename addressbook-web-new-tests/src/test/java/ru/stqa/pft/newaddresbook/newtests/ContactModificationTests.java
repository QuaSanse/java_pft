package ru.stqa.pft.newaddresbook.newtests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereContactMod()) {
      app.getContactHelper().createContact(new ContactData(
              "namme",
              "middlename",
              "lastname",
              "nickname",
              "adress",
              "telmobile",
              "telwork",
              "email",
              "1",
              "January",
              "2000",
              "test1"
      ),true);
    }
    app.getContactHelper().editContactModification(before - 1);
    app.getContactHelper().fillContactForm(new ContactData(
            "namme2",
            "middlename",
            "lastname",
            "nickname",
            "adress",
            "telmobile",
            "telwork",
            "email",
            "1",
            "January",
            "2000",
            null
            ),
            false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}
