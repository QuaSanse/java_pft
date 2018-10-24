package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testDeletionContact () {
    appl.getContactHelper().selectContactDelerion();
    appl.getContactHelper().submitContactDelerion();
    appl.getContactHelper().modalwindowContact();
  }
}
