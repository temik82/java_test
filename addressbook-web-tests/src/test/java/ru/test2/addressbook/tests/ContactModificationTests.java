package ru.test2.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.test2.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().contactPage();
    if (app.contact().list().size()==0) {
      app.contact().create(new ContactData()
              .withFirstName("Petr").withLastName("Petrov").withPhone("89777777771").withEmail("test1@test.ru"));
    }
  }

  @Test(enabled = false)
  public void testContactModification() {

    List<ContactData> before = app.contact().list();
    int index=before.size() - 1;
    ContactData contact = new ContactData()
            .withId(before.get(index).getId()).withFirstName("Ivan")
            .withLastName("Ivanov").withPhone("89777777771").withEmail("test1@test.ru");
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
