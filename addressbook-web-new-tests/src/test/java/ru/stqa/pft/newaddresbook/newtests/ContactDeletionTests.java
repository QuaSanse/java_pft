package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testDeletionContact () {
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
    app.getContactHelper().selectContactDelerion();
    app.getContactHelper().submitContactDelerion();
    app.getContactHelper().modalwindowContact();
  }
}
