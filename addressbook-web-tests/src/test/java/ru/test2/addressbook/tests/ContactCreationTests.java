package ru.test2.addressbook.tests;

import org.testng.annotations.*;
import ru.test2.addressbook.model.ContactData;



public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().goToContactPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactData(new ContactData("Petr", "Petrov", "89777777771", "test1@test.ru"));
    app.getContactHelper().submit();
    app.getContactHelper().returnToHomePage();

  }


}
