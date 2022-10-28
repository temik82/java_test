package ru.test2.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.test3.addressbook.appmanager.BaseHelper;
import ru.test2.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
    wd.get("http://localhost/addressbook/");
  }

  public void submit() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactData(ContactData contactData) {
    type("firstname", By.name("firstname"), contactData.firstName());
    type("lastname", By.name("lastname"), contactData.lastNane());
    type("mobile", By.name("mobile"), contactData.phone());
    type("email", By.name("email"), contactData.email());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
    wd.get("http://localhost/addressbook/edit.php");
  }
}
