package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testDeletionContact () {
    app.getContactHelper().selectContactDelerion();
    app.getContactHelper().submitContactDelerion();
    app.getContactHelper().modalwindowContact();
  }
}
