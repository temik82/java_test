package ru.test3.mantis.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.test3.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase{
  @Test
  public void testLogin() throws IOException {
    HttpSession session=app.newSession();
    Assert.assertTrue(session.Login("administrator","root1"));
    Assert.assertTrue(session.isLoggedInAs("administrator"));

  }
}
