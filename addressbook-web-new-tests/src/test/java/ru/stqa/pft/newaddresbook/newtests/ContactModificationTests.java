package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().editContactModification();
    app.getContactHelper().fillContactForm(new ContactData(
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
            null
            ),
            false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
