package ru.test3.mantis.tests;

import org.testng.annotations.Test;
import ru.test3.mantis.model.UserData;
import ru.test3.mantis.model.Users;

public class ChangePasswordTests extends TestBase{

  @Test
  public void testChangePassword(){
    Users users=app.db().users();
    UserData user=users.iterator().next();






  }



}
