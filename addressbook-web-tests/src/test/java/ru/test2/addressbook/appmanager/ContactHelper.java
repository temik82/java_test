package ru.test2.addressbook.appmanager;

import org.jetbrains.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.test2.addressbook.model.ContactData;
import ru.test2.addressbook.model.Contacts;
import ru.test2.addressbook.model.GroupData;
import ru.test2.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));

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

    attach(By.name("photo"), contact.getPhoto());


    type(By.name("phone2"), contact.getPhone2());
    type(By.name("address2"), contact.getAddress2());


    if (creation) {
      if (contact.getGroups().size() > 0) {
        Assert.assertTrue(contact.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contact.getGroups().iterator().next().getName());
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
    String address2 = wd.findElement(By.name("address2")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstName)
            .withLastName(lastName).withHomePhone(home).withMobilePhone(mobile)
            .withWorkPhone(work).withPhone2(phone2).withEmail(email).withEmail2(email2)
            .withEmail3(email3).withPostAddress(postAddress).withAddress2(address2);


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
    waitConfirm();
    returnToHomePage();
  }


  private void waitConfirm() {
    wd.findElement(By.cssSelector("div.msgbox"));
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


  public void addToGroup(ContactData contact, GroupData group) {
    selectContactById(contact.getId());
    new Select(wd.findElement(By.name("to_group"))).selectByValue(String.valueOf(group.getId()));
    clickToAdd();
    waitConfirm();


  }

  private void clickToAdd() {
    wd.findElement(By.name("add")).click();
  }

  public void deleteContactFromGroup(ContactData contact, GroupData group) {
    new Select(wd.findElement(By.name("group"))).selectByValue(String.valueOf(group.getId()));
    selectContactById(contact.getId());
    clickToRemove();
    waitConfirm();


  }

  private void clickToRemove() {
    wd.findElement(By.name("remove")).click();

  }

 // @Nullable
  public GroupData getGroupData(Groups groups, ContactData selectedContact,boolean add) {
      GroupData selectedGroup=null;

    if (selectedContact != null && !add) {
      selectedGroup = findGroup(selectedContact, groups,false);

    } else if (selectedContact != null) {
      selectedGroup = findGroup(selectedContact, groups,true);

    }
      return selectedGroup;
    }



  @Nullable
  public boolean getaVoid (ContactData selectedContact){
    if (selectedContact != null) {
      return true;
    }
    return false;
  }
  @Nullable
  public boolean getaVoid (GroupData selectedGroup){
    if (selectedGroup != null) {
      return true;
    }

    return false;
  }

  public ContactData findContact(Contacts contacts, Groups groups,boolean add) {
    List<ContactData> contact = new ArrayList<>();
    contact.addAll(contacts);
    for (int i = 0; i < contact.size(); i++) {
      ContactData selectedContact = contact.get(i);
      List<GroupData> before = new ArrayList<>();
      for (GroupData group : groups) {
        if (add) {
          if (!group.getContacts().contains(selectedContact)) {
            before.add(group);
          }
        } if (group.getContacts().contains(selectedContact)) {
          before.add(group);
        }
        if (before.size() > 0) {

          return selectedContact;

        }

      }

    }return null;
  }

  private GroupData findGroup(ContactData selectedContact, Groups groups,boolean add){
    for (GroupData group : groups) {
     if (add){
      if (!group.getContacts().contains(selectedContact) ) {
        return group;
      }
      } else if(group.getContacts().contains(selectedContact)) {
       return group;
     }
    }
    return null;
  }


  public ContactData getDataContactAfter(Contacts contactsAfter, int contactId) {
    for (ContactData contactData : contactsAfter) {
      if (contactData.getId() == contactId) {

        return contactData;

      }

    }return null;

  }

}

