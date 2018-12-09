package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {
  @BeforeMethod
  public void startMailServer() throws Exception {
    app.mail().start();
  }


  @Test
  public void testChangePasswordByAdmin() throws IOException, MessagingException {
    String username = "user1";
    String password = "newpassword"; // Задаем новый пароль
    //Вход от Администратора
    app.registration().startAdmin("administrator", "root");
    app.pass().linkManageUsers();
    //Выбор id юзера из БД
    UserData selectUser = app.db().users().stream().filter((u) -> username.equals(u.getUsername()))
            .iterator().next();
    app.pass().clickUser(selectUser.getId());
    app.pass().resetUserPassword();

    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = app.mail().findConfirmationLink(mailMessages, selectUser.getEmail());

    app.registration().finish(confirmationLink, password);
    HttpSession session = app.newSession();
    assertTrue(session.login(username, password));
    assertTrue(session.isLoggedInAs(username));
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() throws Exception {
    app.mail().stop();
  }
}

