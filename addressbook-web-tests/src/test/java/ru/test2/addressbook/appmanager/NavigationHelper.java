package ru.test2.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    click(By.linkText("groups"));
  }

  public void contactPage() {
    click(By.linkText("home"));
  }
}
