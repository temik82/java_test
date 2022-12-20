package ru.test3.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.test3.mantis.appmanager.HttpSession;
import ru.test3.mantis.model.MailMessage;
import ru.test3.mantis.model.UserData;
import ru.test3.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class ChangePasswordTests extends TestBase {
  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangePassword() throws MessagingException, IOException {
    String password = "secret";
    Users users = app.db().users();
    UserData user = users.iterator().next();
    String userName = user.getUserName();
    String email=user.getEmail();
    app.changePassword().start(userName);
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = app.changePassword().findConfirmationLink(mailMessages, email);
    app.changePassword().finish(confirmationLink, password);
    HttpSession session = app.newSession();
    Assert.assertTrue(session.Login(userName, password));
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }

}


