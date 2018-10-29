package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    appl.getNavigationHelper().gotoHomePage();
    appl.getContactHelper().editContactModification();
    appl.getContactHelper().fillContactForm(new ContactData(
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
    appl.getContactHelper().submitContactModification();
    appl.getContactHelper().returnToHomePage();
  }
}
