package ru.test2.addressbook.tests;

import org.testng.annotations.Test;
import ru.test2.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {
  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Petr", "Petrov", "89777777771", "test1@test.ru"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().switchAlertYes();
    app.getContactHelper().returnToHomePage();


  }
}
