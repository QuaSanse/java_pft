package ru.stqa.pft.newaddresbook;

import org.testng.annotations.*;

public class CreationContact extends TestBase {

  @Test
  public void testCreationContact() throws Exception {
    initContactCreation();
    fillContactForm(new ContactData("namme", "middlename", "lastname", "nickname", "adress", "telmobile", "telwork", "email", "1", "January", "2000"));
    submitContactCreation();
    returnToHomePage();
  }

}
