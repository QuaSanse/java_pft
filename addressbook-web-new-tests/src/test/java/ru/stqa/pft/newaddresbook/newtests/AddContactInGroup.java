package ru.stqa.pft.newaddresbook.newtests;

import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;
import ru.stqa.pft.newaddresbook.newmodel.Contacts;


public class AddContactInGroup extends TestBase {

  @Test
  public void testAddContactInGroup() {
    Contacts before = app.db().contacts();
    ContactData selectContact = before.iterator().next();
    app.goTo().contactPage();
    ContactData contact = new ContactData();
    //выбор контакта
    app.contact().selectContactById(selectContact.getId());
    //wd.findElement(By.id("151")).click();
    //раскрытие списка групп
    app.contact().selectToGroup();
    //выбор из списка группу
    app.contact().selectedNameGroup();
    //клик по кнопке добавления
    app.contact().inputAdd();
    //переход по ссылке
    //wd.findElement(By.linkText("group page \"test1\"")).click();
  }
}
