package ru.test2.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.test2.addressbook.model.ContactData;
import ru.test2.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData().withFirstName("Petr").withLastName("Petrov").withMobilePhone("89777777771").withEmail("test1@test.ru"));
    }
  }

  @Test
  public void testContactModification() {

    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("Ivan")
            .withLastName("Ivanov").withMobilePhone("89777777771")
            .withEmail("test1@test.ru").withEmail2("test2@test.ru")
            .withPostAddress("546783").withPhone2("85536788990").withWorkPhone("2000000000")
            .withEmail3("test4@test.ru").withHomePhone("3000000000").withAddress2("122234");
    app.goTo().contactPage();
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }


}
