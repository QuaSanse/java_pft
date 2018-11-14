package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditorForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned (String phone) {
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
