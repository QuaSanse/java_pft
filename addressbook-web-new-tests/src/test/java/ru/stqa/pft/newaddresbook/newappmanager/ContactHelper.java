package ru.stqa.pft.newaddresbook.newappmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;
import ru.stqa.pft.newaddresbook.newmodel.Contacts;

import java.util.*;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }
  public void returnToHomePageLink() {
    click(By.linkText("home"));
  }

  public void submitContactCreation() {
    click(By.xpath("//input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAdress());
    if (creation) {
      if (!Objects.equals(contactData.getGroup(), contactData.getGroup())) {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void editContactModificationById(int id) {
    wd.findElement(By.xpath("//input[@value='"+id+"']//ancestor::td//following-sibling::td//img[@title='Edit']")).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContactDeletionById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void submitContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void modalWindowContact() {
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contact, boolean creation) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    editContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactDeletionById(contact.getId());
    submitContactDeletion();
    modalWindowContact();
    contactCache = null;
    //returnToHomePage();
    returnToHomePageLink();
  }

  public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
    //return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
  }

  public boolean isThereContactMod() {
    return isElementPresent(By.xpath("//img[@alt='Edit']"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String adress = cells.get(3).getText();
      String[] phones = cells.get(5).getText().split("\n");
      contactCache.add(new ContactData()
              .withId(id)
              .withFirstname(firstname)
              .withLastname(lastname)
              .withAdress(adress)
              .withHomePhone(phones[0])
              .withMobilePhone(phones[1])
              .withWorkPhone(phones[2])
      );
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditorForm(ContactData contact) {
    initContactModificacionById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId())
            .withFirstname(firstname)
            .withLastname(lastname)
            .withHomePhone(home)
            .withMobilePhone(mobile)
            .withWorkPhone(work);
  }

  private void initContactModificacionById(int id) {
    wd.findElement(By.xpath("//input[@value='"+id+"']//ancestor::td//following-sibling::td//img[@title='Edit']")).click();
    //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=$s']", id))).click();
  }
}
