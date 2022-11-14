package ru.test2.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.test2.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
    //wd.get("http://localhost/addressbook/");
  }

  public void submit() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactData(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.firstName());
    type(By.name("lastname"), contactData.lastName());
    type(By.name("mobile"), contactData.phone());
    type(By.name("email"), contactData.email());

    if (creation) {
      if (isThereAGroupAtList()) {
        new Select(wd.findElement(By.name("new_group"))).selectByIndex(1);
      } else {
        new Select(wd.findElement(By.name("new_group"))).selectByIndex(0);
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }


  }

  public void initContactCreation() {
    click(By.linkText("add new"));
    wd.get("http://localhost/addressbook/edit.php");
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void submitContactModification() {
    click(By.xpath("//input[@name='update']"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void switchAlertYes() {
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactData(contact, true);
    submit();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));

  }

  public boolean isThereAGroupAtList() {
    return isFirstGroupAtListPresent(By.name("new_group"));

  }


  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, firstName, lastName, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}

