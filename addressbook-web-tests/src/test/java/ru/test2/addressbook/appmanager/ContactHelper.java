package ru.test2.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.test2.addressbook.model.ContactData;
import ru.test2.addressbook.model.Contacts;

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

  public void fillContactData(ContactData contact, boolean creation) {

      type(By.name("firstname"), contact.getFirstName());

      type(By.name("lastname"), contact.getLastName());

      type(By.name("mobile"), contact.getMobilePhone());

      type(By.name("email"), contact.getEmail());

      type(By.name("address"), contact.getPostAddress());

      type(By.name("email2"), contact.getEmail2());

      type(By.name("email3"), contact.getEmail3());

      type(By.name("home"), contact.getHomePhone());

      type(By.name("work"), contact.getWorkPhone());

      attach(By.name("photo"),contact.getPhoto());


      type(By.name("phone2"), contact.getPhone2());

     // System.out.println("No data for test");



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
    //wd.get("http://localhost/addressbook/edit.php");
  }


  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }


  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String postAddress = wd.findElement(By.name("address")).getAttribute("value");
    String phone2 = wd.findElement(By.name("phone2")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstName)
            .withLastName(lastName).withHomePhone(home).withMobilePhone(mobile)
            .withWorkPhone(work).withPhone2(phone2).withEmail(email).withEmail2(email2).withEmail3(email3).withPostAddress(postAddress);


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

  public void create(ContactData contact) {
    initContactCreation();
    fillContactData(contact, true);
    submit();
    returnToHomePage();
  }


  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactData(contact, false);
    submitContactModification();
    returnToHomePage();
  }


  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    switchAlertYes();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));

  }

  public boolean isThereAGroupAtList() {
    return isFirstGroupAtListPresent(By.name("new_group"));

  }
  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }


  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String lastName = cells.get(1).getText();
      String firstName = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
      String postAddress = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
              .withAllPhones(allPhones).withPostAddress(postAddress).withAllEmails(allEmails));
    }
    return contacts;
  }


}

