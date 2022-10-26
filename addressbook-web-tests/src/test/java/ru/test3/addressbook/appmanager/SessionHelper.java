package ru.test3.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.test2.addressbook.appmanager.BaseHelper;

public class SessionHelper extends BaseHelper {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String login, String password) {
    type(By.name("user"), login);
    type(By.name("pass"), password);
    click(By.xpath("//input[@value='Login']"));
  }
}
