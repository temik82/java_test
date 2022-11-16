package ru.test2.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.test2.addressbook.model.ContactData;

import java.util.Set;


public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.goTo().contactPage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Sergey")
            .withLastName("Sidorov").withPhone("9777777777").withEmail("test@test.ru");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);


    contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());
    before.add(contact);


    Assert.assertEquals(before, after);

  }


}
