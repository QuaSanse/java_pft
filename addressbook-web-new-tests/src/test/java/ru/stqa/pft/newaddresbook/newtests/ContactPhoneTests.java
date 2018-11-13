package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
                      .withFirstname("Firstname")
                      .withLastname("lastname")
                      .withAdress("adress")
                      .withGroup("Group")
              , true);
    }
  }

  @Test
  public void testContactPhones() {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditorForm = app.contact().infoFromEditorForm(contact);
  }
}
