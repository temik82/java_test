package ru.test3.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper  extends BaseHelper{




  public RegistrationHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl")+"/signup_page.php");
    type(By.name("username"),username);
    type(By.name("email"),email);
     click(By.cssSelector("input.button"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"),password);
    type(By.name("password_confirm"),password);
    click(By.cssSelector("input[value='Update user']"));


  }
}
