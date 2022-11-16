package ru.test2.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.test2.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().contactPage();
    if (app.contact().list().size()==0) {
      app.contact().create(new ContactData()
              .withFirstName("Petr").withLastName("Petrov").withPhone("89777777771").withEmail("test1@test.ru"));
    }
  }
  @Test
  public void testContactDeletion() {
    List<ContactData> before = app.contact().list();
    int index=before.size() - 1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }




}
