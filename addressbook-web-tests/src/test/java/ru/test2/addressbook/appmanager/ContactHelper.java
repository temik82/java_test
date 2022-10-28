package ru.test2.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    type(By.name("firstname"), contactData.firstName());
    type(By.name("lastname"), contactData.lastNane());
    type(By.name("mobile"), contactData.phone());
    type(By.name("email"), contactData.email());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
    wd.get("http://localhost/addressbook/edit.php");
  }
}
