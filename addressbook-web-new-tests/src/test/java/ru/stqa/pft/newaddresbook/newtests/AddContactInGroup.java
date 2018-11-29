package ru.stqa.pft.newaddresbook.newtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

public class AddContactInGroup extends TestBase {
  WebDriver wd;

  @Test
  public void testAddContactInGroup() {
    app.goTo().contactPage();
    ContactData contact = new ContactData();
    //выбор контакта
    app.contact().selectContactDeletionById(contact.getId());
    //wd.findElement(By.id("151")).click();
    //раскрытие списка групп
    selectToGroup();
    //выбор из списка группу
    selectedNameGroup();
    //клик по кнопке добавления
    inputAdd();
    //переход по ссылке
    wd.findElement(By.linkText("group page \"test1\"")).click();
  }



  private void selectToGroup() {
    wd.findElement(By.name("to_group")).click();
  }
  private void selectedNameGroup() {
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select all'])[1]/following::option[1]")).click();
  }
  private void inputAdd() {
    wd.findElement(By.name("add")).click();
  }
}
