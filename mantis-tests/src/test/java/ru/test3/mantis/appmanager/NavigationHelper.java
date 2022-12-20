package ru.test3.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void managePage() {
    click(By.linkText("Manage"));
  }

  public void manageUserPage() {
    click(By.linkText("Manage Users"));
  }
}
