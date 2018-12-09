package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class PassHelper extends HelperBase {

  public PassHelper(ApplicationManager app) {
    super(app);
  }

  public void linkManageUsers() {
    click((By.linkText("Manage")));
    click((By.linkText("Manage Users")));
  }


  public void selectUser() {
    click(By.xpath("//*[@id='main-container']//*[contains(text(), 'user')]"));
  }

  public void clickUser(int id) {
    click(By.cssSelector("a[href='manage_user_edit_page.php?user_id=" + id + "']"));
  }

  public String getEmail() {
    String email = wd.findElement(By.xpath("//tr[3]//input[@name='email']")).getAttribute("value");
    return email;
  }

  public String getName() {
    String name = wd.findElement(By.xpath("//tr[1]//input[@name='username']")).getAttribute("value");
    return name;
  }

  public void resetUserPassword() {
    click(By.cssSelector("input[value='Reset Password']"));
  }

  public void cheangePassword(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("input[value='Update User']"));
  }
}
