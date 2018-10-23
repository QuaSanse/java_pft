package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.*;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

public class CreationContact extends TestBase {

  @Test
  public void testCreationContact() throws Exception {
    appl.initContactCreation();
    appl.fillContactForm(new ContactData("namme", "middlename", "lastname", "nickname", "adress", "telmobile", "telwork", "email", "1", "January", "2000"));
    appl.submitContactCreation();
    appl.returnToHomePage();
  }

}
