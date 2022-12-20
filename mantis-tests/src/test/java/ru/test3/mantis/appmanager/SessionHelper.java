package ru.test3.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends BaseHelper {


  public SessionHelper(WebDriver wd) {

    super(wd);
  }
  public void login(String username, String password) {
    type(By.name("username"),username);
    type(By.name("password"),password);

    click(By.xpath("//input[@value='Login']"));
  }
}
