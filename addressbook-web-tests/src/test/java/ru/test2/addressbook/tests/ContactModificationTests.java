package ru.test2.addressbook.tests;

import org.testng.annotations.Test;
import ru.test2.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Petr", "Petrov", "89777777771", "test1@test.ru"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactData(new ContactData("Ivan", "Ivanov", "89777777771", "test1@test.ru"), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

  }
}
