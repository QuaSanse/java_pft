package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.*;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreationContact() throws Exception {
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
    ), true);
  }

}
