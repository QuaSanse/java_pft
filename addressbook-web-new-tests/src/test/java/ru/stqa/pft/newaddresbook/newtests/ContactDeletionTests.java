package ru.stqa.pft.newaddresbook.newtests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testDeletionContact () {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereContact()) {
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
    app.getContactHelper().selectContactDeletion(before - 1);
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().modalWindowContact();
    //app.getContactHelper().returnToHomePage();
    app.getContactHelper().returnToHomePageLink();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }
}
