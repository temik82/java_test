package ru.test2.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.test2.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().contactPage();
    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData()
              .withFirstName("Petr").withLastName("Petrov").withPhone("89777777771").withEmail("test1@test.ru"));
    }
  }

  @Test
  public void testContactModification() {

    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact=before.iterator().next();


    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("Ivan")
            .withLastName("Ivanov").withPhone("89777777771").withEmail("test1@test.ru");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifiedContact);
    before.add(contact);

    Assert.assertEquals(before, after);
  }


}
