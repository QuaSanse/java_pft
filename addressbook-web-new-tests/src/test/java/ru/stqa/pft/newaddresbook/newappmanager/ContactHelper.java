package ru.stqa.pft.newaddresbook.newappmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

  public void fillContactForm(ContactData contactData) {
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
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }
}
