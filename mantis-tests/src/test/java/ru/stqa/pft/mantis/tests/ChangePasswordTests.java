package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
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
    String newPassword = "newPassword";
    app.pass().initloginPageAdmin("administrator", "root");
    app.pass().linkManageUsers();

    UserData selectUser = app.db().users().stream().filter((u) -> username.equals(u.getUsername()))
            .iterator().next();
    app.pass().clickUser(selectUser.getId());
    app.pass().resetUserPassword();

    List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, selectUser.getEmail());
    app.pass().cheangePassword(confirmationLink, newPassword);
    assertTrue(app.newSession().login(username, newPassword));
    assertTrue(app.newSession().isLoggedInAs(username));
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() throws Exception {
    app.mail().stop();
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

}
