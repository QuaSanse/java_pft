package ru.stqa.pft.newaddresbook.newappmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.newaddresbook.newmodel.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("//input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("address"), contactData.getAdress());
    type(By.name("mobile"), contactData.getTelmobile());
    type(By.name("work"), contactData.getTelwork());
    type(By.name("email"), contactData.getEmail());
    click(By.name("bday"));
    select(By.name("bday"), contactData.getBirthdaydate());
    click(By.xpath("//option[@value='1']"));
    click(By.name("bmonth"));
    select(By.name("bmonth"), contactData.getBirthdaymonth());
    click(By.xpath("//option[@value='January']"));
    type(By.name("byear"), contactData.getBirthdayyear());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void editContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void selectContactDelerion() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
  }

  public void submitContactDelerion() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void modalwindowContact() {
    wd.switchTo().alert().accept();
  }
}