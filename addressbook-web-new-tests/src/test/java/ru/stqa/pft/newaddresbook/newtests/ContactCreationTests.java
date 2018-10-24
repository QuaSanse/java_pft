package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.*;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreationContact() throws Exception {
    appl.getContactHelper().initContactCreation();
    appl.getContactHelper().fillContactForm(new ContactData("namme", "middlename", "lastname", "nickname", "adress", "telmobile", "telwork", "email", "1", "January", "2000"));
    appl.getContactHelper().submitContactCreation();
    appl.getContactHelper().returnToHomePage();
  }

}
