package ru.test2.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.test2.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Petr", "Petrov", "89777777771", "test1@test.ru"));
    }
    List<ContactData> before=app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().initContactModification();
    ContactData contact=new ContactData(before.get(before.size()-1).getId(),"Ivan", "Ivanov", "89777777771", "test1@test.ru");
    app.getContactHelper().fillContactData(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size());
    before.remove(before.size()-1);
    before.add(contact);
    Comparator<? super ContactData> byId=(c1,c2)->Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    System.out.println(before);
    System.out.println(after);
    Assert.assertEquals(before,after);




  }
}
